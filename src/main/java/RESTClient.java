import beans.NodeBeans;
import beans.NodeListWrapper;
import beans.Statistic;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

public class RESTClient {
    private static final String HOST = "localhost";
    private static final int PORT = 1337;
    private static final String REST_URI = "http://"+HOST+":"+PORT+"/gateway/";
    private static WebTarget webTargetREST;

    public RESTClient() {
        Client clientRest = ClientBuilder.newClient();
        webTargetREST = clientRest.target(REST_URI);
    }

    // funzione per l'invio di richiesta al gateway di affiliazione alla rete tramite Rest
    static List<NodeBeans> richiestaAggiuntaGateway(String id, String ip, Integer port){
        NodeBeans nb = new NodeBeans(id, ip, port);
        Response response = webTargetREST.path("node/add").request(MediaType.APPLICATION_JSON).post(Entity.entity(nb, MediaType.APPLICATION_JSON));
        if (response.getStatus()==304) return null;
        NodeListWrapper nl = response.readEntity(NodeListWrapper.class);
        return nl.getLl();
    }

    // funzione per l'invio di richiesta al gateway di rimozione dalla rete tramite Rest
    static void richiestaRimozioneGateway(String id){
        Response response = webTargetREST.path("node/delete/"+id).request().delete();
        //if (response.getStatus()==200) System.out.println("MainNode - accordato dal gateway l'uscita dal sistema");
    }

    // invio al gateway della richiesta delle statistiche
    static void invioStatisticaGateway(Statistic stat){
        Response response = webTargetREST.path("node/newstat").request().post(Entity.entity(stat, MediaType.APPLICATION_JSON));
    }

}
