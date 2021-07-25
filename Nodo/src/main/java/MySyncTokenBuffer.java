import it.grpc.tokenRing.Token;

public class MySyncTokenBuffer {
    private Token token = null;

    public MySyncTokenBuffer() {
        this.token = null;
    }

    private Token getToken() {
        return token;
    }

    private void setToken(Token t) {
        this.token = t;
    }

    public synchronized void produce(Token t) throws InterruptedException {
        while(this.getToken() != null){
            wait();
        }
        this.setToken(t);
        notify();
    }

    public synchronized Token consume() throws InterruptedException {
        while(this.getToken() == null){
            wait();
        }
        Token t = this.getToken();
        this.setToken(null);
        notify();
        return t;
    }
}
