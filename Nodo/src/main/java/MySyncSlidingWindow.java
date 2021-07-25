import simulatori.Buffer;
import simulatori.Measurement;

import java.util.LinkedList;

public class MySyncSlidingWindow implements Buffer {
    private LinkedList<Measurement> buffer;

    public MySyncSlidingWindow() {
        this.buffer = new LinkedList<Measurement>();
    }

    public synchronized LinkedList<Measurement> getBuffer() { return new LinkedList<Measurement>(buffer);}

    public synchronized void setBuffer(LinkedList<Measurement> buffer) {
        this.buffer = buffer;
    }

    public synchronized void addMeasurement(Measurement m) {
        buffer.add(m);
        notify();
    }

    public synchronized LinkedList<Measurement> getMeasurement() throws InterruptedException {
        if (buffer.size() < 12)
            return null;

        LinkedList<Measurement> res = new LinkedList<Measurement>(buffer.subList((buffer.size()-12), buffer.size()));

        while( buffer.size() > 6 ) buffer.remove();

        return res;
    }
}
