import beans.NodeBeans;
import it.grpc.tokenRing.Node;

public class FollowingNodeWrapper{
    private static NodeBeans followingNode;
    private static FollowingNodeWrapper instance;
    private boolean cleaned;

    private FollowingNodeWrapper() {
        this.followingNode = new NodeBeans();
        cleaned = false;
    }

    public static FollowingNodeWrapper getInstance() {
        if (followingNode==null)
            instance = new FollowingNodeWrapper();
        return instance;
    }

    public synchronized void setFollowingNode(NodeBeans nb) {
        this.followingNode.setId(nb.getId());
        this.followingNode.setIp(nb.getIp());
        this.followingNode.setPort(nb.getPort());
    }

    public synchronized String getId(){ // essendo le stringhe immutabli, non ho dovuto fare una copia
        return followingNode.getId();
    }

    public synchronized String getIp(){
        return followingNode.getIp();
    }

    public synchronized Integer getPort(){
        return new Integer(followingNode.getPort());
    }

    public synchronized Node getNode(){
        return Node.newBuilder().setId(followingNode.getId()).setIp(followingNode.getIp()).setPort(followingNode.getPort()).build();
    }

    public synchronized NodeBeans getNodeBeans(){
        return new NodeBeans(followingNode.getId(), followingNode.getIp(), followingNode.getPort());
    }

    public synchronized void clear(){
        cleaned = true;
        notify();
    }

    public synchronized boolean isDeleted() throws InterruptedException {
        while (!cleaned)
            wait();
        return cleaned;
    }
}
