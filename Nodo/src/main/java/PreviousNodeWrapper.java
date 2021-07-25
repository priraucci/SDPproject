import beans.NodeBeans;
import it.grpc.tokenRing.Node;

public class PreviousNodeWrapper{
    private static NodeBeans previousNode;
    private static PreviousNodeWrapper instance;
    private boolean cleaned;

    private PreviousNodeWrapper() {
        this.previousNode = new NodeBeans();
        cleaned = false;
    }

    public static PreviousNodeWrapper getInstance() {
        if (previousNode == null)
            instance = new PreviousNodeWrapper();
        return instance;
    }

    public synchronized void setPreviousNode(NodeBeans nb) {
        this.previousNode.setId(nb.getId());
        this.previousNode.setIp(nb.getIp());
        this.previousNode.setPort(nb.getPort());
    }

    public synchronized String getId(){ // essendo le stringhe immutabli, non ho dovuto fare una copia
        return previousNode.getId();
    }

    public synchronized String getIp(){
        return previousNode.getIp();
    }

    public synchronized Integer getPort(){
        return new Integer(previousNode.getPort());
    }

    public synchronized Node getNode(){
        return Node.newBuilder().setId(previousNode.getId()).setIp(previousNode.getIp()).setPort(previousNode.getPort()).build();
    }

    public synchronized NodeBeans getNodeBeans(){
        return new NodeBeans(previousNode.getId(), previousNode.getIp(), previousNode.getPort());
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
