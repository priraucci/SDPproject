
import beans.Statistic;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import it.grpc.tokenRing.Ack;
import it.grpc.tokenRing.Node;
import it.grpc.tokenRing.Token;
import it.grpc.tokenRing.TokenRingGrpc;
import simulatori.Measurement;

import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;

public class GrpcClientThread extends Thread {
    private String selfId;
    private volatile boolean senderGateway;
    private boolean stopFlag;

    private MySyncSlidingWindow slidingWindow;
    private MySyncTokenBuffer tokenbuffer;
    private FollowingNodeWrapper followingNode;
    private String currentFollowingID;

    private RESTClient restClient;

    public GrpcClientThread(String id, MySyncTokenBuffer token, MySyncSlidingWindow slidingWindow, FollowingNodeWrapper fn, RESTClient restClient) {
        this.selfId = id;
        this.tokenbuffer = token;
        this.slidingWindow = slidingWindow;
        this.followingNode = fn;
        this.restClient = restClient;
        this.senderGateway = false;
        this.stopFlag = false;
    }


    StreamObserver<Ack> responseObserver = new StreamObserver<Ack>() {
        @Override
        public void onNext(Ack value) {
        }

        @Override
        public void onError(Throwable t) {
            System.out.println(Level.WARNING.toString() + ":TokenRingClient Encountered error in the TokenRing " + t.toString());
        }

        @Override
        public void onCompleted() {}

    };

    public void run(){
        ManagedChannel channel = null;
        TokenRingGrpc.TokenRingStub asyncStub;
        Token localToken = null;
        Token readyToSendToken = null;
        StreamObserver<Token> requestObserver = null;


        while(!stopFlag){

            if (requestObserver != null) {
                requestObserver.onCompleted();
            }

            currentFollowingID = followingNode.getInstance().getId();
            if(currentFollowingID.compareTo(selfId) <= 0) {
                senderGateway = true;
                } else senderGateway = false;

            channel = ManagedChannelBuilder.forAddress(followingNode.getInstance().getIp(), followingNode.getInstance().getPort())
                        .usePlaintext(true)
                        .build();

            asyncStub = TokenRingGrpc.newStub(channel);
            requestObserver = asyncStub.sendToken(responseObserver);

            while(followingNIsCorrect()){

                if (readyToSendToken != null) {
                    requestObserver.onNext(readyToSendToken);
                    readyToSendToken = null;
                }

                try {
                    if (localToken != null) {
                        if (senderGateway) {
                            List<Double> mes = localToken.getMeasurementList();

                            if(mes.size() != 0){
                                double sum = 0;
                                for (Double d : mes) sum = +d;
                                double value = sum / mes.size();

                                Statistic s = new Statistic(value, new Timestamp(System.currentTimeMillis()));
                                restClient.invioStatisticaGateway(s);
                                localToken = Token.newBuilder().build();
                                System.out.println("sendGateway");
                            }
                        }

                        LinkedList<Measurement> mlist = slidingWindow.getMeasurement();
                        if (mlist == null) { //non ho nulla da inviare - inoltro il token invariato
                            readyToSendToken = localToken;
                            localToken = null;
                        }
                        if (mlist != null) {

                            double sum = 0;
                            for (Measurement m : mlist) {
                                sum = +m.getValue();
                            }
                            double value = sum / mlist.size();

                            //System.out.println("GrpcClientThread- slidingwindow value :"+ value);
                            readyToSendToken = Token.newBuilder().addMeasurement(value).addAllMeasurement(localToken.getMeasurementList()).build();
                            localToken = null;
                        }

                        if (!followingNIsCorrect()) break;
                        else {
                            requestObserver.onNext(readyToSendToken);
                            readyToSendToken = null;
                        }
                    }
                }catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try{
                    Thread.sleep(1000);
                    localToken = tokenbuffer.consume();
                    System.out.print(". ");

                } catch (InterruptedException e) {
                    //System.out.println("GrpcClient stopping... ");
                    requestObserver.onCompleted();
                    return;
                }
            }
        }
        //System.out.println("GrpcClient stopping... ");
        requestObserver.onCompleted();
    }

    private boolean followingNIsCorrect(){
        return (currentFollowingID.compareTo(followingNode.getInstance().getId()) == 0);
    }

    public void stopMeGently(){
        stopFlag = true;
    }
}
