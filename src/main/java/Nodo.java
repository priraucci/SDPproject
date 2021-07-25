import beans.NodeBeans;
import it.grpc.tokenRing.*;
import simulatori.PM10Simulator;

import java.io.IOException;
import java.util.*;

public class Nodo {
    private static String id;
    private static String ip = "localhost";
    private static Integer port ;

    private static MySyncTokenBuffer tokenbuffer;
    private static MySyncSlidingWindow slidingWindow;
    private static PreviousNodeWrapper previousNode;
    private static FollowingNodeWrapper followingNode;

    private static RESTClient restClient;
    private static GrpcClientTopology grpcClientTopology;

    public static void main(String[] args) throws IOException, InterruptedException {
        restClient = new RESTClient();

        List<NodeBeans> listaNodi = askGatewayJoinNetwork();
        if (listaNodi == null) {
            System.out.println("Impossibile al momento inserirsi alla rete, ritentare più tardi");
            return;
        }
        System.out.println("nodo aggiunto alla rete, Id assegnato: " + id);
        port = 1338 + Integer.parseInt(id);

        grpcClientTopology = new GrpcClientTopology(id, ip, port);

        //creo strutture dati condivise tra thread
        tokenbuffer = new MySyncTokenBuffer();  // da questo punto in poi vi si accede solo con metodi produce/consume
        slidingWindow = new MySyncSlidingWindow();
        followingNode = FollowingNodeWrapper.getInstance();
        previousNode = PreviousNodeWrapper.getInstance();

        //richiedo l'accesso alla rete tramite comunicazione con nodo precedente
        NodeBeans pNB = findNeighbour(listaNodi);
        previousNode.getInstance().setPreviousNode(pNB);

        GrpcServerThread grpcServerThread = new GrpcServerThread(id, followingNode, previousNode, tokenbuffer, port);
        grpcServerThread.start();

        Node fn = grpcClientTopology.sendEntranceNoticeGRPC(previousNode.getInstance().getNodeBeans(), true);
        if (fn == null) {
            System.out.println("i nodi non stanno permettendo l'ingresso nella rete");
            return;
        }
        followingNode.getInstance().setFollowingNode(new NodeBeans(fn.getId(), fn.getIp(), fn.getPort()));
        grpcClientTopology.sendEntranceNoticeGRPC(followingNode.getInstance().getNodeBeans(), false);

        //creo il client grpc per la gestione dei token
        GrpcClientThread grpcClientThread = new GrpcClientThread(id, tokenbuffer, slidingWindow, followingNode, restClient);
        grpcClientThread.start();

        // avvio il simulatore del senosore
        PM10Simulator pm10Simulator = new PM10Simulator(id, slidingWindow);
        pm10Simulator.start();

        System.out.println("Premere invio per terminare...");
        System.in.read();
        System.out.println("Sto facendo terminare il Nodo");

        pm10Simulator.stopMeGently();
        restClient.richiestaRimozioneGateway(id);

        if (followingNode.getInstance().getId().equals(id) && previousNode.getInstance().getId().equals(id)) {
            grpcClientThread.join(1000);
            if (grpcClientThread.isAlive()) {
                grpcClientThread.interrupt();
                grpcClientThread = null;
            }
            //System.out.println("grpcClientThread joined");

            grpcServerThread.stopMeGently();
            grpcServerThread.join();
            //System.out.println("grpcServerThread joined");
        } else {
            grpcClientTopology.sendExitNotice(followingNode, previousNode);

            grpcServerThread.stopMeGently();
            grpcServerThread.join();
            //System.out.println("grpcServerThread joined");

            grpcClientThread.stopMeGently();
            grpcClientThread.join(1000);
            if (grpcClientThread.isAlive()) {
                grpcClientThread.interrupt();
                grpcClientThread = null;
            }
            //System.out.println("grpcClientThread joined");
        }

        pm10Simulator.join();
        //System.out.println("pm10Simulator joined");

        System.out.println("Node stopped");
    }

    // funzione pre trovare un id non assegnato con cui entrare nel gateway
    private static List<NodeBeans> askGatewayJoinNetwork() {
        Random rand = new Random();
        List<NodeBeans> listaNodi = null;
        int i = 0;
        while(i < 3 && listaNodi == null){      // tento di inserirmi nella rete facendo 3 tentativi
            int nrand = rand.nextInt(100);
            id = Integer.toString(nrand);
            // System.out.println("tento di inserire "+ id);
            listaNodi = restClient.richiestaAggiuntaGateway(id, ip, 1338+ Integer.parseInt(id));
            i++;
        }
        return listaNodi;
    }

    // funzione pre trovare il nodo a cui fare la richista nella rete
    private static NodeBeans findNeighbour(List<NodeBeans> listaNodi) throws InterruptedException {

        NodeBeans previousNode = null;
        if (listaNodi.isEmpty()){   //se è da solo nella rete ---non devo mandar
            previousNode = new NodeBeans(id, ip, port);
            Token emptyToken = Token.newBuilder().build();

            followingNode.getInstance().setFollowingNode(new NodeBeans(id, ip, port));

            tokenbuffer.produce(emptyToken);
        } else {
            // se ci sono altri nodi
            Collections.sort(listaNodi);
            int i = 0;
            int j = listaNodi.size()-1;
            if (listaNodi.get(i).getId().compareTo(id) > 0){ // se (prevNodeId > NodeId)
                previousNode = listaNodi.get(j);
            }
            while (previousNode == null && i < listaNodi.size()){
                if (listaNodi.get(i).getId().compareTo(id) > 0) { // se (prevNodeId < NodeId)
                    previousNode = listaNodi.get(j);
                }
                i++;
                j = (j+1)%listaNodi.size();
            }
            if(previousNode == null){
                previousNode = listaNodi.get(listaNodi.size()-1);
            }
        }

        return previousNode;
    }

}
