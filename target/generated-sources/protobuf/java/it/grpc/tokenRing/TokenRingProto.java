// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: TokenRing.proto

package it.grpc.tokenRing;

public final class TokenRingProto {
  private TokenRingProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Token_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Token_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Ack_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Ack_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Node_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Node_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Entrance_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Entrance_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Exit_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Exit_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\017TokenRing.proto\"A\n\005Token\022\023\n\013measuremen" +
      "t\030\001 \003(\001\022\021\n\ttimestamp\030\002 \001(\t\022\020\n\010idsender\030\003" +
      " \001(\t\"-\n\003Ack\022\013\n\003ack\030\001 \002(\010\022\031\n\nfollowingN\030\002" +
      " \001(\0132\005.Node\",\n\004Node\022\n\n\002id\030\001 \002(\t\022\n\n\002ip\030\002 " +
      "\002(\t\022\014\n\004port\030\003 \002(\005\"0\n\010Entrance\022\026\n\007senderN" +
      "\030\001 \002(\0132\005.Node\022\014\n\004succ\030\002 \002(\010\"S\n\004Exit\022\030\n\tp" +
      "reviousN\030\001 \002(\0132\005.Node\022\031\n\nfollowingN\030\002 \002(" +
      "\0132\005.Node\022\026\n\007senderN\030\003 \002(\0132\005.Node2k\n\tToke" +
      "nRing\022\035\n\tsendToken\022\006.Token\032\004.Ack\"\000(\001\022\"\n\r" +
      "noticeEntrace\022\t.Entrance\032\004.Ack\"\000\022\033\n\nnoti",
      "ceExit\022\005.Exit\032\004.Ack\"\000B%\n\021it.grpc.tokenRi" +
      "ngB\016TokenRingProtoP\001"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
    internal_static_Token_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_Token_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Token_descriptor,
        new java.lang.String[] { "Measurement", "Timestamp", "Idsender", });
    internal_static_Ack_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_Ack_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Ack_descriptor,
        new java.lang.String[] { "Ack", "FollowingN", });
    internal_static_Node_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_Node_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Node_descriptor,
        new java.lang.String[] { "Id", "Ip", "Port", });
    internal_static_Entrance_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_Entrance_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Entrance_descriptor,
        new java.lang.String[] { "SenderN", "Succ", });
    internal_static_Exit_descriptor =
      getDescriptor().getMessageTypes().get(4);
    internal_static_Exit_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Exit_descriptor,
        new java.lang.String[] { "PreviousN", "FollowingN", "SenderN", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}