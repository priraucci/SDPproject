import beans.ElaborazioneStatistiche;
import beans.StatisticListWrapper;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.Scanner;

public class Analista {
    private static WebTarget webTarget;
    private static final String HOST = "localhost";
    private static final int PORT = 1337;
    private static final String REST_URI = "http://"+HOST+":"+PORT+"/gateway/";

    public static void main(String[] args){
        String input[];
        String command = null;
        String num = null;

        Client client = ClientBuilder.newClient();
        webTarget = client.target(REST_URI);

        System.out.println("Analista waiting, available commands:\n"+
                "num     : to ask the number of nodes inside the network at the moment\n"+
                "stat n  : to get last \"n\" statistics\n"+
                "elab n  : to get standard deviation and average of last \"n\" statisics\n"+
                "q       : to quit the service\n");

        Scanner scanner = new Scanner(System.in);
         while(true){
             while( command == null) {
                 System.out.println("Please enter a command");
                 input = scanner.nextLine().split(" ");
                 int i = 0;
                 while (i < input.length && command == null) {
                     if (!input[i].equals("")) {
                         command = input[i].trim();
                     }
                     i++;
                 }
                 while (i < input.length && num == null) {
                     if (!input[i].equals("")) {
                         num = input[i].trim();
                     }
                     i++;
                 }
             }

            //gestione dei comandi
             switch(command.charAt(0)){
                 case 'n':
                     String numeroNodi = numberNodes();
                     System.out.println("There are "+ numeroNodi+ " Nodes inside the Network");
                     break;
                 case 's':
                     if (num == null) {
                         System.out.println("Command not valid -missing second parameter");
                         break;
                     }
                     if (checkNumber(num)) {
                         String statistiche = askStatsGateway(num);
                         System.out.println("Last " + num + " statistics are:\n" + statistiche);
                     } break;
                 case 'e':
                     if (num == null) {
                         System.out.println("Command not valid -missing second parameter");
                         break;
                     }
                     if (checkNumber(num)) {
                         String statElaborate = askElaboratedStatsGateway(num);
                         System.out.println("Elaboration of the last "+ num +" statistics:\n" + statElaborate );
                     } break;
                 case 'q':
                     System.out.println("System closing");
                     return;
                 default :
                     System.out.println("Command not valid");
             }
             num = null;
             command= null;
         }

    }

    private static boolean checkNumber(String n) {
        if (Integer.parseInt(n) >= 0) return true;
        System.out.println("please enter a positive number");
        return false;
    }

    // per ottenere il numero di nodi nella rete
    private static String numberNodes() {
        Response response = webTarget.path("analist/size").request(MediaType.APPLICATION_JSON).get();
        return response.readEntity(String.class);
    }

    // funzione che ritorna le utlime n statistiche
    private static String askStatsGateway(String num) {
        Response response =  webTarget.path("analist/getstats/"+num).request(MediaType.APPLICATION_JSON).get();
        StatisticListWrapper swr = response.readEntity(StatisticListWrapper.class);
        ArrayList slist = swr.getLl();
        StringBuilder sb = new StringBuilder();
        for (Object stat : slist){
            sb.append(stat.toString()).append("\n");
        }
        return sb.toString();
    }

    // funzione che ritonra la deviazione standard e media delle ultime n statistiche prodotte
    private static String askElaboratedStatsGateway(String num) {
        Response response =  webTarget.path("analist/elabstat/"+num).request(MediaType.APPLICATION_JSON).get();
        //System.out.println(response.getStatus());
        ElaborazioneStatistiche es = response.readEntity(ElaborazioneStatistiche.class);
        return "average: "+es.getMedia() +"\nstandard deviation: "+es.getDevstandard();
    }

}
