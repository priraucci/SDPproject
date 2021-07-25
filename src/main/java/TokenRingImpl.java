import beans.NodeBeans;
import io.grpc.stub.StreamObserver;
import it.grpc.tokenRing.*;

import java.util.logging.Level;

public class TokenRingImpl extends TokenRingGrpc.TokenRingImplBase {
    private String id;
    private FollowingNodeWrapper followingNode;
    private PreviousNodeWrapper previousNode;
    private MySyncTokenBuffer tokenbuffer;

    public TokenRingImpl(String id, FollowingNodeWrapper fNode, PreviousNodeWrapper pNode, MySyncTokenBuffer t) {
        this.id = id;
        this.followingNode = fNode;
        this.previousNode = pNode;
        this.tokenbuffer = t;
    }

    @Override
    public StreamObserver<Token> sendToken(StreamObserver<Ack> responseObserver) {
        return new StreamObserver<Token>(){
            @Override
            public void onNext(Token value) {
                try {
                    tokenbuffer.produce(value);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onError(Throwable t) {
                System.out.println(Level.WARNING.toString() + ":TokenRingServer Encountered error in the TokenRing " + t.toString());
            }

            @Override
            public void onCompleted() {
                Ack closeAck = Ack.newBuilder().setAck(true).build();
                responseObserver.onNext(closeAck);

                responseObserver.onCompleted();
            }
        };
    }

    @Override
    public void noticeEntrace(Entrance request, StreamObserver<Ack> responseObserver) {
        Node n = request.getSenderN();
        if(request.getSucc()){ //il nodo che richiede accesso richiede l'indirizzo del successivo
            //memorizzo i dati del vecchio successore
            Node oldfriend = Node.newBuilder().setId(followingNode.getInstance().getId()).setIp(followingNode.getInstance().getIp()).setPort(followingNode.getInstance().getPort()).build();

            //cambio i dati del successore
            followingNode.getInstance().setFollowingNode(new NodeBeans(n.getId(), n.getIp(), n.getPort()));

            System.out.println("TokenRingImpl: noticeEntrace- my new following node: "+followingNode.getInstance().getId());
            Ack response = Ack.newBuilder().setAck(true).setFollowingN(oldfriend).build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();

        }else{
            previousNode.getInstance().setPreviousNode(new NodeBeans(n.getId(), n.getIp(), n.getPort()));

            System.out.println("TokenRingImpl: noticeEntrace- my new previous node: "+previousNode.getInstance().getId());
            Ack response = Ack.newBuilder().setAck(true).build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }
    }

    @Override
    public void noticeExit(Exit request, StreamObserver<Ack> responseObserver) {
        Node pn = request.getPreviousN();
        Node fn = request.getFollowingN();
        if(pn.getId().equals(id)){
            followingNode.getInstance().setFollowingNode(new NodeBeans(fn.getId(), fn.getIp(), fn.getPort()));
            System.out.println("TokenRingImpl: followingNode left, the new one is: "+followingNode.getInstance().getId());
        } if (fn.getId().equals(id)) {
            previousNode.getInstance().setPreviousNode(new NodeBeans(pn.getId(), pn.getIp(), pn.getPort()));
            System.out.println("TokenRingImpl: previousNode left, the new one is: "+previousNode.getInstance().getId());
        }

        Ack response = Ack.newBuilder().setAck(true).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

}
