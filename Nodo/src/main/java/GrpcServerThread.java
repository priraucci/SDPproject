import beans.NodeBeans;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import it.grpc.tokenRing.Node;

import java.io.IOException;

public class GrpcServerThread extends Thread{
    private Integer port;
    private TokenRingImpl tokenRingServer;
    private Server grpcServer;

    public GrpcServerThread(String id, FollowingNodeWrapper fNode, PreviousNodeWrapper pNode, MySyncTokenBuffer t, Integer port) {
        this.port = port;
        tokenRingServer = new TokenRingImpl(id, fNode, pNode, t);
    }

    public void run(){
        grpcServer = ServerBuilder
                .forPort(port)
                .addService(tokenRingServer).build();

        try {
            grpcServer.start();

            grpcServer.awaitTermination();
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }
    }

    public void stopMeGently() throws InterruptedException {
        grpcServer.shutdown();
    }
}
