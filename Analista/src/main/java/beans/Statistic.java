package beans;

import javax.xml.bind.annotation.XmlRootElement;
import java.sql.Timestamp;

@XmlRootElement
public class Statistic { // necessario aggiungere altri campi??
    private double val;
    private Timestamp timestamp; // Necessario???

    public Statistic() {}

    public Statistic(double val, Timestamp timestamp) {
        this.val = val;
        this.timestamp = timestamp;
    }

    public double getVal() {
        return val;
    }

    public void setVal(double val) {
        this.val = val;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString(){
       return "value: " + val+"     at time: "+timestamp;
    }
}
