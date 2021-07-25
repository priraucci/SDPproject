import beans.NodeBeans;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import it.grpc.tokenRing.*;

public class GrpcClientTopology {
    private static String id;
    private static String ip;
    private static Integer port;

    public GrpcClientTopology(String id, String ip, Integer port) {
        this.id = id;
        this.ip = ip;
        this.port = port;
    }

    // funzione per notificare l'ingresso tramite grpc ad un nodo della rete
    static Node sendEntranceNoticeGRPC(NodeBeans node, boolean askfollowing){
        Node followingNode;

        final ManagedChannel channel = ManagedChannelBuilder.forTarget(node.getIp()+":"+node.getPort().toString())
                .usePlaintext(true)
                .build();

        TokenRingGrpc.TokenRingBlockingStub stub = TokenRingGrpc.newBlockingStub(channel);

        Node self = Node.newBuilder().setId(id).setIp(ip).setPort(port).build();

        Ack ack = stub.noticeEntrace(Entrance.newBuilder().setSenderN(self).setSucc(askfollowing).build());
        if (askfollowing) {
            followingNode = ack.getFollowingN();
            channel.shutdown();
            return followingNode;
        }
        channel.shutdown();
        return null;
    }

    static boolean sendExitNotice(FollowingNodeWrapper followingNode, PreviousNodeWrapper previousNode){

        final ManagedChannel channelprev = ManagedChannelBuilder.forTarget(previousNode.getInstance().getIp()+":"+previousNode.getInstance().getPort().toString())
                .usePlaintext(true)
                .build();

        TokenRingGrpc.TokenRingBlockingStub stubprev = TokenRingGrpc.newBlockingStub(channelprev);

        Node sn = Node.newBuilder().setId(id).setIp(ip).setPort(port).build();
        Node pn = previousNode.getInstance().getNode();
        Node fn = followingNode.getInstance().getNode();
        Exit newMessage = Exit.newBuilder().setPreviousN(pn).setFollowingN(fn).setSenderN(sn).build();
        Ack a1 = stubprev.noticeExit(newMessage);

        if(!previousNode.getInstance().getId().equals(followingNode.getInstance().getId())){
            final ManagedChannel channelsucc = ManagedChannelBuilder.forTarget(followingNode.getInstance().getIp()+":"+followingNode.getInstance().getPort().toString())
                .usePlaintext(true)
                .build();

            TokenRingGrpc.TokenRingBlockingStub stubsucc = TokenRingGrpc.newBlockingStub(channelsucc);

            Ack a2 = stubsucc.noticeExit(newMessage);
            return (a1.getAck() && a2.getAck());
        }

        return a1.getAck();
    }
}
