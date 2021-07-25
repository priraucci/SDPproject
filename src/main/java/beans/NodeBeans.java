package beans;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class NodeBeans implements Comparable<NodeBeans>{
    private String id;
    private String ip; // cambiare con un tipo più adatto!
    private Integer port; // cambiare con un tipo più adatto!(?)

    public NodeBeans(){}

    public NodeBeans(String id, String ip, Integer port) {
        this.id = id;
        this.ip = ip;
        this.port = port;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public String toString(){ return "Node: "+id +"."+ ip +"."+ port+"\n"; }

    public int compareTo(NodeBeans nd) {
        String thisId = id;
        String otherId = nd.getId();
        return thisId.compareTo(otherId);
    }
}
