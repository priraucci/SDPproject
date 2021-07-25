package beans;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

@XmlRootElement
public class StatisticListWrapper {
    private ArrayList<Statistic> ll;

    public StatisticListWrapper(){}

    public StatisticListWrapper(ArrayList<Statistic> ll) {
        this.ll = ll;
    }

    public ArrayList<Statistic> getLl() {
        return ll;
    }

    public void setLl(ArrayList<Statistic> ll) {
        this.ll = ll;
    }
}
