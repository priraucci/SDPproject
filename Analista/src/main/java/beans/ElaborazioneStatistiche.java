package beans;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

@XmlRootElement
public class ElaborazioneStatistiche {
    private double media;
    private double devstandard;

    public ElaborazioneStatistiche() {}

    public ElaborazioneStatistiche(double media, double devstandard) {
        this.media = media;
        this.devstandard = devstandard;
    }

    public ElaborazioneStatistiche(ArrayList<Statistic> ll) {
        this.media = this.calcolaMedia(ll);
        this.devstandard = this.calcolaDevstandard(ll);
    }

    private double calcolaDevstandard(ArrayList<Statistic> ll) {
        double temp = 0;
        for (int i = 0; i < ll.size(); i++)
        {
            double val = ll.get(i).getVal();
            // find the square of its distance to the mean
            double squrDiffToMean = Math.pow(val - media, 2);
            // Sum the values
            temp += squrDiffToMean;
        }
        // Divide by the number of data points
        double meanOfDiffs = (double) temp / (double) (ll.size());
        // Take the square root
        return Math.sqrt(meanOfDiffs);
    }

    private double calcolaMedia(ArrayList<Statistic> ll) {
        if (ll.isEmpty()) return 0;

        double sum = 0;
        for (Statistic stat : ll) {
            sum += stat.getVal();
        }
        return (sum / ll.size());
    }

    public double getMedia() {
        return media;
    }

    public void setMedia(double media) {
        this.media = media;
    }

    public double getDevstandard() {
        return devstandard;
    }

    public void setDevstandard(double devstandard) {
        this.devstandard = devstandard;
    }
}
