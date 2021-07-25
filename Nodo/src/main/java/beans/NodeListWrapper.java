package beans;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

@XmlRootElement
public class NodeListWrapper {
    private ArrayList<NodeBeans> ll;

    public NodeListWrapper(){}

    public NodeListWrapper(ArrayList<NodeBeans> ll) {
        this.ll = ll;
    }

    public ArrayList<NodeBeans> getLl() {
        return ll;
    }

    public void setLl(ArrayList<NodeBeans> ll) {
        this.ll = ll;
    }
}
