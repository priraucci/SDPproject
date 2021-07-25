package it.grpc.tokenRing;

import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.7.0)",
    comments = "Source: TokenRing.proto")
public final class TokenRingGrpc {

  private TokenRingGrpc() {}

  public static final String SERVICE_NAME = "TokenRing";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<it.grpc.tokenRing.Token,
      it.grpc.tokenRing.Ack> METHOD_SEND_TOKEN =
      io.grpc.MethodDescriptor.<it.grpc.tokenRing.Token, it.grpc.tokenRing.Ack>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
          .setFullMethodName(generateFullMethodName(
              "TokenRing", "sendToken"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              it.grpc.tokenRing.Token.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              it.grpc.tokenRing.Ack.getDefaultInstance()))
          .setSchemaDescriptor(new TokenRingMethodDescriptorSupplier("sendToken"))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<it.grpc.tokenRing.Entrance,
      it.grpc.tokenRing.Ack> METHOD_NOTICE_ENTRACE =
      io.grpc.MethodDescriptor.<it.grpc.tokenRing.Entrance, it.grpc.tokenRing.Ack>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "TokenRing", "noticeEntrace"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              it.grpc.tokenRing.Entrance.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              it.grpc.tokenRing.Ack.getDefaultInstance()))
          .setSchemaDescriptor(new TokenRingMethodDescriptorSupplier("noticeEntrace"))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<it.grpc.tokenRing.Exit,
      it.grpc.tokenRing.Ack> METHOD_NOTICE_EXIT =
      io.grpc.MethodDescriptor.<it.grpc.tokenRing.Exit, it.grpc.tokenRing.Ack>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "TokenRing", "noticeExit"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              it.grpc.tokenRing.Exit.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              it.grpc.tokenRing.Ack.getDefaultInstance()))
          .setSchemaDescriptor(new TokenRingMethodDescriptorSupplier("noticeExit"))
          .build();

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static TokenRingStub newStub(io.grpc.Channel channel) {
    return new TokenRingStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static TokenRingBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new TokenRingBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static TokenRingFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new TokenRingFutureStub(channel);
  }

  /**
   */
  public static abstract class TokenRingImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     *streaming bidirezinale per l'invio-ricezione dei token e la gestione dell'uscita
     * </pre>
     */
    public io.grpc.stub.StreamObserver<it.grpc.tokenRing.Token> sendToken(
        io.grpc.stub.StreamObserver<it.grpc.tokenRing.Ack> responseObserver) {
      return asyncUnimplementedStreamingCall(METHOD_SEND_TOKEN, responseObserver);
    }

    /**
     * <pre>
     * RPC semplice per l'avviso di ingresso dalla rete
     * </pre>
     */
    public void noticeEntrace(it.grpc.tokenRing.Entrance request,
        io.grpc.stub.StreamObserver<it.grpc.tokenRing.Ack> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_NOTICE_ENTRACE, responseObserver);
    }

    /**
     * <pre>
     * RPC semplice per l'avviso di ingresso dalla rete
     * </pre>
     */
    public void noticeExit(it.grpc.tokenRing.Exit request,
        io.grpc.stub.StreamObserver<it.grpc.tokenRing.Ack> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_NOTICE_EXIT, responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_SEND_TOKEN,
            asyncClientStreamingCall(
              new MethodHandlers<
                it.grpc.tokenRing.Token,
                it.grpc.tokenRing.Ack>(
                  this, METHODID_SEND_TOKEN)))
          .addMethod(
            METHOD_NOTICE_ENTRACE,
            asyncUnaryCall(
              new MethodHandlers<
                it.grpc.tokenRing.Entrance,
                it.grpc.tokenRing.Ack>(
                  this, METHODID_NOTICE_ENTRACE)))
          .addMethod(
            METHOD_NOTICE_EXIT,
            asyncUnaryCall(
              new MethodHandlers<
                it.grpc.tokenRing.Exit,
                it.grpc.tokenRing.Ack>(
                  this, METHODID_NOTICE_EXIT)))
          .build();
    }
  }

  /**
   */
  public static final class TokenRingStub extends io.grpc.stub.AbstractStub<TokenRingStub> {
    private TokenRingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private TokenRingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TokenRingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new TokenRingStub(channel, callOptions);
    }

    /**
     * <pre>
     *streaming bidirezinale per l'invio-ricezione dei token e la gestione dell'uscita
     * </pre>
     */
    public io.grpc.stub.StreamObserver<it.grpc.tokenRing.Token> sendToken(
        io.grpc.stub.StreamObserver<it.grpc.tokenRing.Ack> responseObserver) {
      return asyncClientStreamingCall(
          getChannel().newCall(METHOD_SEND_TOKEN, getCallOptions()), responseObserver);
    }

    /**
     * <pre>
     * RPC semplice per l'avviso di ingresso dalla rete
     * </pre>
     */
    public void noticeEntrace(it.grpc.tokenRing.Entrance request,
        io.grpc.stub.StreamObserver<it.grpc.tokenRing.Ack> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_NOTICE_ENTRACE, getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * RPC semplice per l'avviso di ingresso dalla rete
     * </pre>
     */
    public void noticeExit(it.grpc.tokenRing.Exit request,
        io.grpc.stub.StreamObserver<it.grpc.tokenRing.Ack> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_NOTICE_EXIT, getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class TokenRingBlockingStub extends io.grpc.stub.AbstractStub<TokenRingBlockingStub> {
    private TokenRingBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private TokenRingBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TokenRingBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new TokenRingBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * RPC semplice per l'avviso di ingresso dalla rete
     * </pre>
     */
    public it.grpc.tokenRing.Ack noticeEntrace(it.grpc.tokenRing.Entrance request) {
      return blockingUnaryCall(
          getChannel(), METHOD_NOTICE_ENTRACE, getCallOptions(), request);
    }

    /**
     * <pre>
     * RPC semplice per l'avviso di ingresso dalla rete
     * </pre>
     */
    public it.grpc.tokenRing.Ack noticeExit(it.grpc.tokenRing.Exit request) {
      return blockingUnaryCall(
          getChannel(), METHOD_NOTICE_EXIT, getCallOptions(), request);
    }
  }

  /**
   */
  public static final class TokenRingFutureStub extends io.grpc.stub.AbstractStub<TokenRingFutureStub> {
    private TokenRingFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private TokenRingFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TokenRingFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new TokenRingFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * RPC semplice per l'avviso di ingresso dalla rete
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<it.grpc.tokenRing.Ack> noticeEntrace(
        it.grpc.tokenRing.Entrance request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_NOTICE_ENTRACE, getCallOptions()), request);
    }

    /**
     * <pre>
     * RPC semplice per l'avviso di ingresso dalla rete
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<it.grpc.tokenRing.Ack> noticeExit(
        it.grpc.tokenRing.Exit request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_NOTICE_EXIT, getCallOptions()), request);
    }
  }

  private static final int METHODID_NOTICE_ENTRACE = 0;
  private static final int METHODID_NOTICE_EXIT = 1;
  private static final int METHODID_SEND_TOKEN = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final TokenRingImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(TokenRingImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_NOTICE_ENTRACE:
          serviceImpl.noticeEntrace((it.grpc.tokenRing.Entrance) request,
              (io.grpc.stub.StreamObserver<it.grpc.tokenRing.Ack>) responseObserver);
          break;
        case METHODID_NOTICE_EXIT:
          serviceImpl.noticeExit((it.grpc.tokenRing.Exit) request,
              (io.grpc.stub.StreamObserver<it.grpc.tokenRing.Ack>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SEND_TOKEN:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.sendToken(
              (io.grpc.stub.StreamObserver<it.grpc.tokenRing.Ack>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class TokenRingBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    TokenRingBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return it.grpc.tokenRing.TokenRingProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("TokenRing");
    }
  }

  private static final class TokenRingFileDescriptorSupplier
      extends TokenRingBaseDescriptorSupplier {
    TokenRingFileDescriptorSupplier() {}
  }

  private static final class TokenRingMethodDescriptorSupplier
      extends TokenRingBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    TokenRingMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (TokenRingGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new TokenRingFileDescriptorSupplier())
              .addMethod(METHOD_SEND_TOKEN)
              .addMethod(METHOD_NOTICE_ENTRACE)
              .addMethod(METHOD_NOTICE_EXIT)
              .build();
        }
      }
    }
    return result;
  }
}
