// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: TokenRing.proto

package it.grpc.tokenRing;

/**
 * Protobuf type {@code Exit}
 */
public  final class Exit extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:Exit)
    ExitOrBuilder {
private static final long serialVersionUID = 0L;
  // Use Exit.newBuilder() to construct.
  private Exit(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private Exit() {
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private Exit(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    int mutable_bitField0_ = 0;
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          default: {
            if (!parseUnknownField(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
          case 10: {
            it.grpc.tokenRing.Node.Builder subBuilder = null;
            if (((bitField0_ & 0x00000001) == 0x00000001)) {
              subBuilder = previousN_.toBuilder();
            }
            previousN_ = input.readMessage(it.grpc.tokenRing.Node.PARSER, extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(previousN_);
              previousN_ = subBuilder.buildPartial();
            }
            bitField0_ |= 0x00000001;
            break;
          }
          case 18: {
            it.grpc.tokenRing.Node.Builder subBuilder = null;
            if (((bitField0_ & 0x00000002) == 0x00000002)) {
              subBuilder = followingN_.toBuilder();
            }
            followingN_ = input.readMessage(it.grpc.tokenRing.Node.PARSER, extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(followingN_);
              followingN_ = subBuilder.buildPartial();
            }
            bitField0_ |= 0x00000002;
            break;
          }
          case 26: {
            it.grpc.tokenRing.Node.Builder subBuilder = null;
            if (((bitField0_ & 0x00000004) == 0x00000004)) {
              subBuilder = senderN_.toBuilder();
            }
            senderN_ = input.readMessage(it.grpc.tokenRing.Node.PARSER, extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(senderN_);
              senderN_ = subBuilder.buildPartial();
            }
            bitField0_ |= 0x00000004;
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return it.grpc.tokenRing.TokenRingProto.internal_static_Exit_descriptor;
  }

  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return it.grpc.tokenRing.TokenRingProto.internal_static_Exit_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            it.grpc.tokenRing.Exit.class, it.grpc.tokenRing.Exit.Builder.class);
  }

  private int bitField0_;
  public static final int PREVIOUSN_FIELD_NUMBER = 1;
  private it.grpc.tokenRing.Node previousN_;
  /**
   * <code>required .Node previousN = 1;</code>
   */
  public boolean hasPreviousN() {
    return ((bitField0_ & 0x00000001) == 0x00000001);
  }
  /**
   * <code>required .Node previousN = 1;</code>
   */
  public it.grpc.tokenRing.Node getPreviousN() {
    return previousN_ == null ? it.grpc.tokenRing.Node.getDefaultInstance() : previousN_;
  }
  /**
   * <code>required .Node previousN = 1;</code>
   */
  public it.grpc.tokenRing.NodeOrBuilder getPreviousNOrBuilder() {
    return previousN_ == null ? it.grpc.tokenRing.Node.getDefaultInstance() : previousN_;
  }

  public static final int FOLLOWINGN_FIELD_NUMBER = 2;
  private it.grpc.tokenRing.Node followingN_;
  /**
   * <code>required .Node followingN = 2;</code>
   */
  public boolean hasFollowingN() {
    return ((bitField0_ & 0x00000002) == 0x00000002);
  }
  /**
   * <code>required .Node followingN = 2;</code>
   */
  public it.grpc.tokenRing.Node getFollowingN() {
    return followingN_ == null ? it.grpc.tokenRing.Node.getDefaultInstance() : followingN_;
  }
  /**
   * <code>required .Node followingN = 2;</code>
   */
  public it.grpc.tokenRing.NodeOrBuilder getFollowingNOrBuilder() {
    return followingN_ == null ? it.grpc.tokenRing.Node.getDefaultInstance() : followingN_;
  }

  public static final int SENDERN_FIELD_NUMBER = 3;
  private it.grpc.tokenRing.Node senderN_;
  /**
   * <code>required .Node senderN = 3;</code>
   */
  public boolean hasSenderN() {
    return ((bitField0_ & 0x00000004) == 0x00000004);
  }
  /**
   * <code>required .Node senderN = 3;</code>
   */
  public it.grpc.tokenRing.Node getSenderN() {
    return senderN_ == null ? it.grpc.tokenRing.Node.getDefaultInstance() : senderN_;
  }
  /**
   * <code>required .Node senderN = 3;</code>
   */
  public it.grpc.tokenRing.NodeOrBuilder getSenderNOrBuilder() {
    return senderN_ == null ? it.grpc.tokenRing.Node.getDefaultInstance() : senderN_;
  }

  private byte memoizedIsInitialized = -1;
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    if (!hasPreviousN()) {
      memoizedIsInitialized = 0;
      return false;
    }
    if (!hasFollowingN()) {
      memoizedIsInitialized = 0;
      return false;
    }
    if (!hasSenderN()) {
      memoizedIsInitialized = 0;
      return false;
    }
    if (!getPreviousN().isInitialized()) {
      memoizedIsInitialized = 0;
      return false;
    }
    if (!getFollowingN().isInitialized()) {
      memoizedIsInitialized = 0;
      return false;
    }
    if (!getSenderN().isInitialized()) {
      memoizedIsInitialized = 0;
      return false;
    }
    memoizedIsInitialized = 1;
    return true;
  }

  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (((bitField0_ & 0x00000001) == 0x00000001)) {
      output.writeMessage(1, getPreviousN());
    }
    if (((bitField0_ & 0x00000002) == 0x00000002)) {
      output.writeMessage(2, getFollowingN());
    }
    if (((bitField0_ & 0x00000004) == 0x00000004)) {
      output.writeMessage(3, getSenderN());
    }
    unknownFields.writeTo(output);
  }

  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (((bitField0_ & 0x00000001) == 0x00000001)) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, getPreviousN());
    }
    if (((bitField0_ & 0x00000002) == 0x00000002)) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(2, getFollowingN());
    }
    if (((bitField0_ & 0x00000004) == 0x00000004)) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(3, getSenderN());
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof it.grpc.tokenRing.Exit)) {
      return super.equals(obj);
    }
    it.grpc.tokenRing.Exit other = (it.grpc.tokenRing.Exit) obj;

    boolean result = true;
    result = result && (hasPreviousN() == other.hasPreviousN());
    if (hasPreviousN()) {
      result = result && getPreviousN()
          .equals(other.getPreviousN());
    }
    result = result && (hasFollowingN() == other.hasFollowingN());
    if (hasFollowingN()) {
      result = result && getFollowingN()
          .equals(other.getFollowingN());
    }
    result = result && (hasSenderN() == other.hasSenderN());
    if (hasSenderN()) {
      result = result && getSenderN()
          .equals(other.getSenderN());
    }
    result = result && unknownFields.equals(other.unknownFields);
    return result;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    if (hasPreviousN()) {
      hash = (37 * hash) + PREVIOUSN_FIELD_NUMBER;
      hash = (53 * hash) + getPreviousN().hashCode();
    }
    if (hasFollowingN()) {
      hash = (37 * hash) + FOLLOWINGN_FIELD_NUMBER;
      hash = (53 * hash) + getFollowingN().hashCode();
    }
    if (hasSenderN()) {
      hash = (37 * hash) + SENDERN_FIELD_NUMBER;
      hash = (53 * hash) + getSenderN().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static it.grpc.tokenRing.Exit parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static it.grpc.tokenRing.Exit parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static it.grpc.tokenRing.Exit parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static it.grpc.tokenRing.Exit parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static it.grpc.tokenRing.Exit parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static it.grpc.tokenRing.Exit parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static it.grpc.tokenRing.Exit parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static it.grpc.tokenRing.Exit parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static it.grpc.tokenRing.Exit parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static it.grpc.tokenRing.Exit parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static it.grpc.tokenRing.Exit parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static it.grpc.tokenRing.Exit parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(it.grpc.tokenRing.Exit prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code Exit}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:Exit)
      it.grpc.tokenRing.ExitOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return it.grpc.tokenRing.TokenRingProto.internal_static_Exit_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return it.grpc.tokenRing.TokenRingProto.internal_static_Exit_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              it.grpc.tokenRing.Exit.class, it.grpc.tokenRing.Exit.Builder.class);
    }

    // Construct using it.grpc.tokenRing.Exit.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
        getPreviousNFieldBuilder();
        getFollowingNFieldBuilder();
        getSenderNFieldBuilder();
      }
    }
    public Builder clear() {
      super.clear();
      if (previousNBuilder_ == null) {
        previousN_ = null;
      } else {
        previousNBuilder_.clear();
      }
      bitField0_ = (bitField0_ & ~0x00000001);
      if (followingNBuilder_ == null) {
        followingN_ = null;
      } else {
        followingNBuilder_.clear();
      }
      bitField0_ = (bitField0_ & ~0x00000002);
      if (senderNBuilder_ == null) {
        senderN_ = null;
      } else {
        senderNBuilder_.clear();
      }
      bitField0_ = (bitField0_ & ~0x00000004);
      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return it.grpc.tokenRing.TokenRingProto.internal_static_Exit_descriptor;
    }

    public it.grpc.tokenRing.Exit getDefaultInstanceForType() {
      return it.grpc.tokenRing.Exit.getDefaultInstance();
    }

    public it.grpc.tokenRing.Exit build() {
      it.grpc.tokenRing.Exit result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public it.grpc.tokenRing.Exit buildPartial() {
      it.grpc.tokenRing.Exit result = new it.grpc.tokenRing.Exit(this);
      int from_bitField0_ = bitField0_;
      int to_bitField0_ = 0;
      if (((from_bitField0_ & 0x00000001) == 0x00000001)) {
        to_bitField0_ |= 0x00000001;
      }
      if (previousNBuilder_ == null) {
        result.previousN_ = previousN_;
      } else {
        result.previousN_ = previousNBuilder_.build();
      }
      if (((from_bitField0_ & 0x00000002) == 0x00000002)) {
        to_bitField0_ |= 0x00000002;
      }
      if (followingNBuilder_ == null) {
        result.followingN_ = followingN_;
      } else {
        result.followingN_ = followingNBuilder_.build();
      }
      if (((from_bitField0_ & 0x00000004) == 0x00000004)) {
        to_bitField0_ |= 0x00000004;
      }
      if (senderNBuilder_ == null) {
        result.senderN_ = senderN_;
      } else {
        result.senderN_ = senderNBuilder_.build();
      }
      result.bitField0_ = to_bitField0_;
      onBuilt();
      return result;
    }

    public Builder clone() {
      return (Builder) super.clone();
    }
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.setField(field, value);
    }
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return (Builder) super.clearField(field);
    }
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return (Builder) super.clearOneof(oneof);
    }
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return (Builder) super.setRepeatedField(field, index, value);
    }
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.addRepeatedField(field, value);
    }
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof it.grpc.tokenRing.Exit) {
        return mergeFrom((it.grpc.tokenRing.Exit)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(it.grpc.tokenRing.Exit other) {
      if (other == it.grpc.tokenRing.Exit.getDefaultInstance()) return this;
      if (other.hasPreviousN()) {
        mergePreviousN(other.getPreviousN());
      }
      if (other.hasFollowingN()) {
        mergeFollowingN(other.getFollowingN());
      }
      if (other.hasSenderN()) {
        mergeSenderN(other.getSenderN());
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    public final boolean isInitialized() {
      if (!hasPreviousN()) {
        return false;
      }
      if (!hasFollowingN()) {
        return false;
      }
      if (!hasSenderN()) {
        return false;
      }
      if (!getPreviousN().isInitialized()) {
        return false;
      }
      if (!getFollowingN().isInitialized()) {
        return false;
      }
      if (!getSenderN().isInitialized()) {
        return false;
      }
      return true;
    }

    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      it.grpc.tokenRing.Exit parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (it.grpc.tokenRing.Exit) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private it.grpc.tokenRing.Node previousN_ = null;
    private com.google.protobuf.SingleFieldBuilderV3<
        it.grpc.tokenRing.Node, it.grpc.tokenRing.Node.Builder, it.grpc.tokenRing.NodeOrBuilder> previousNBuilder_;
    /**
     * <code>required .Node previousN = 1;</code>
     */
    public boolean hasPreviousN() {
      return ((bitField0_ & 0x00000001) == 0x00000001);
    }
    /**
     * <code>required .Node previousN = 1;</code>
     */
    public it.grpc.tokenRing.Node getPreviousN() {
      if (previousNBuilder_ == null) {
        return previousN_ == null ? it.grpc.tokenRing.Node.getDefaultInstance() : previousN_;
      } else {
        return previousNBuilder_.getMessage();
      }
    }
    /**
     * <code>required .Node previousN = 1;</code>
     */
    public Builder setPreviousN(it.grpc.tokenRing.Node value) {
      if (previousNBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        previousN_ = value;
        onChanged();
      } else {
        previousNBuilder_.setMessage(value);
      }
      bitField0_ |= 0x00000001;
      return this;
    }
    /**
     * <code>required .Node previousN = 1;</code>
     */
    public Builder setPreviousN(
        it.grpc.tokenRing.Node.Builder builderForValue) {
      if (previousNBuilder_ == null) {
        previousN_ = builderForValue.build();
        onChanged();
      } else {
        previousNBuilder_.setMessage(builderForValue.build());
      }
      bitField0_ |= 0x00000001;
      return this;
    }
    /**
     * <code>required .Node previousN = 1;</code>
     */
    public Builder mergePreviousN(it.grpc.tokenRing.Node value) {
      if (previousNBuilder_ == null) {
        if (((bitField0_ & 0x00000001) == 0x00000001) &&
            previousN_ != null &&
            previousN_ != it.grpc.tokenRing.Node.getDefaultInstance()) {
          previousN_ =
            it.grpc.tokenRing.Node.newBuilder(previousN_).mergeFrom(value).buildPartial();
        } else {
          previousN_ = value;
        }
        onChanged();
      } else {
        previousNBuilder_.mergeFrom(value);
      }
      bitField0_ |= 0x00000001;
      return this;
    }
    /**
     * <code>required .Node previousN = 1;</code>
     */
    public Builder clearPreviousN() {
      if (previousNBuilder_ == null) {
        previousN_ = null;
        onChanged();
      } else {
        previousNBuilder_.clear();
      }
      bitField0_ = (bitField0_ & ~0x00000001);
      return this;
    }
    /**
     * <code>required .Node previousN = 1;</code>
     */
    public it.grpc.tokenRing.Node.Builder getPreviousNBuilder() {
      bitField0_ |= 0x00000001;
      onChanged();
      return getPreviousNFieldBuilder().getBuilder();
    }
    /**
     * <code>required .Node previousN = 1;</code>
     */
    public it.grpc.tokenRing.NodeOrBuilder getPreviousNOrBuilder() {
      if (previousNBuilder_ != null) {
        return previousNBuilder_.getMessageOrBuilder();
      } else {
        return previousN_ == null ?
            it.grpc.tokenRing.Node.getDefaultInstance() : previousN_;
      }
    }
    /**
     * <code>required .Node previousN = 1;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        it.grpc.tokenRing.Node, it.grpc.tokenRing.Node.Builder, it.grpc.tokenRing.NodeOrBuilder> 
        getPreviousNFieldBuilder() {
      if (previousNBuilder_ == null) {
        previousNBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            it.grpc.tokenRing.Node, it.grpc.tokenRing.Node.Builder, it.grpc.tokenRing.NodeOrBuilder>(
                getPreviousN(),
                getParentForChildren(),
                isClean());
        previousN_ = null;
      }
      return previousNBuilder_;
    }

    private it.grpc.tokenRing.Node followingN_ = null;
    private com.google.protobuf.SingleFieldBuilderV3<
        it.grpc.tokenRing.Node, it.grpc.tokenRing.Node.Builder, it.grpc.tokenRing.NodeOrBuilder> followingNBuilder_;
    /**
     * <code>required .Node followingN = 2;</code>
     */
    public boolean hasFollowingN() {
      return ((bitField0_ & 0x00000002) == 0x00000002);
    }
    /**
     * <code>required .Node followingN = 2;</code>
     */
    public it.grpc.tokenRing.Node getFollowingN() {
      if (followingNBuilder_ == null) {
        return followingN_ == null ? it.grpc.tokenRing.Node.getDefaultInstance() : followingN_;
      } else {
        return followingNBuilder_.getMessage();
      }
    }
    /**
     * <code>required .Node followingN = 2;</code>
     */
    public Builder setFollowingN(it.grpc.tokenRing.Node value) {
      if (followingNBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        followingN_ = value;
        onChanged();
      } else {
        followingNBuilder_.setMessage(value);
      }
      bitField0_ |= 0x00000002;
      return this;
    }
    /**
     * <code>required .Node followingN = 2;</code>
     */
    public Builder setFollowingN(
        it.grpc.tokenRing.Node.Builder builderForValue) {
      if (followingNBuilder_ == null) {
        followingN_ = builderForValue.build();
        onChanged();
      } else {
        followingNBuilder_.setMessage(builderForValue.build());
      }
      bitField0_ |= 0x00000002;
      return this;
    }
    /**
     * <code>required .Node followingN = 2;</code>
     */
    public Builder mergeFollowingN(it.grpc.tokenRing.Node value) {
      if (followingNBuilder_ == null) {
        if (((bitField0_ & 0x00000002) == 0x00000002) &&
            followingN_ != null &&
            followingN_ != it.grpc.tokenRing.Node.getDefaultInstance()) {
          followingN_ =
            it.grpc.tokenRing.Node.newBuilder(followingN_).mergeFrom(value).buildPartial();
        } else {
          followingN_ = value;
        }
        onChanged();
      } else {
        followingNBuilder_.mergeFrom(value);
      }
      bitField0_ |= 0x00000002;
      return this;
    }
    /**
     * <code>required .Node followingN = 2;</code>
     */
    public Builder clearFollowingN() {
      if (followingNBuilder_ == null) {
        followingN_ = null;
        onChanged();
      } else {
        followingNBuilder_.clear();
      }
      bitField0_ = (bitField0_ & ~0x00000002);
      return this;
    }
    /**
     * <code>required .Node followingN = 2;</code>
     */
    public it.grpc.tokenRing.Node.Builder getFollowingNBuilder() {
      bitField0_ |= 0x00000002;
      onChanged();
      return getFollowingNFieldBuilder().getBuilder();
    }
    /**
     * <code>required .Node followingN = 2;</code>
     */
    public it.grpc.tokenRing.NodeOrBuilder getFollowingNOrBuilder() {
      if (followingNBuilder_ != null) {
        return followingNBuilder_.getMessageOrBuilder();
      } else {
        return followingN_ == null ?
            it.grpc.tokenRing.Node.getDefaultInstance() : followingN_;
      }
    }
    /**
     * <code>required .Node followingN = 2;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        it.grpc.tokenRing.Node, it.grpc.tokenRing.Node.Builder, it.grpc.tokenRing.NodeOrBuilder> 
        getFollowingNFieldBuilder() {
      if (followingNBuilder_ == null) {
        followingNBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            it.grpc.tokenRing.Node, it.grpc.tokenRing.Node.Builder, it.grpc.tokenRing.NodeOrBuilder>(
                getFollowingN(),
                getParentForChildren(),
                isClean());
        followingN_ = null;
      }
      return followingNBuilder_;
    }

    private it.grpc.tokenRing.Node senderN_ = null;
    private com.google.protobuf.SingleFieldBuilderV3<
        it.grpc.tokenRing.Node, it.grpc.tokenRing.Node.Builder, it.grpc.tokenRing.NodeOrBuilder> senderNBuilder_;
    /**
     * <code>required .Node senderN = 3;</code>
     */
    public boolean hasSenderN() {
      return ((bitField0_ & 0x00000004) == 0x00000004);
    }
    /**
     * <code>required .Node senderN = 3;</code>
     */
    public it.grpc.tokenRing.Node getSenderN() {
      if (senderNBuilder_ == null) {
        return senderN_ == null ? it.grpc.tokenRing.Node.getDefaultInstance() : senderN_;
      } else {
        return senderNBuilder_.getMessage();
      }
    }
    /**
     * <code>required .Node senderN = 3;</code>
     */
    public Builder setSenderN(it.grpc.tokenRing.Node value) {
      if (senderNBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        senderN_ = value;
        onChanged();
      } else {
        senderNBuilder_.setMessage(value);
      }
      bitField0_ |= 0x00000004;
      return this;
    }
    /**
     * <code>required .Node senderN = 3;</code>
     */
    public Builder setSenderN(
        it.grpc.tokenRing.Node.Builder builderForValue) {
      if (senderNBuilder_ == null) {
        senderN_ = builderForValue.build();
        onChanged();
      } else {
        senderNBuilder_.setMessage(builderForValue.build());
      }
      bitField0_ |= 0x00000004;
      return this;
    }
    /**
     * <code>required .Node senderN = 3;</code>
     */
    public Builder mergeSenderN(it.grpc.tokenRing.Node value) {
      if (senderNBuilder_ == null) {
        if (((bitField0_ & 0x00000004) == 0x00000004) &&
            senderN_ != null &&
            senderN_ != it.grpc.tokenRing.Node.getDefaultInstance()) {
          senderN_ =
            it.grpc.tokenRing.Node.newBuilder(senderN_).mergeFrom(value).buildPartial();
        } else {
          senderN_ = value;
        }
        onChanged();
      } else {
        senderNBuilder_.mergeFrom(value);
      }
      bitField0_ |= 0x00000004;
      return this;
    }
    /**
     * <code>required .Node senderN = 3;</code>
     */
    public Builder clearSenderN() {
      if (senderNBuilder_ == null) {
        senderN_ = null;
        onChanged();
      } else {
        senderNBuilder_.clear();
      }
      bitField0_ = (bitField0_ & ~0x00000004);
      return this;
    }
    /**
     * <code>required .Node senderN = 3;</code>
     */
    public it.grpc.tokenRing.Node.Builder getSenderNBuilder() {
      bitField0_ |= 0x00000004;
      onChanged();
      return getSenderNFieldBuilder().getBuilder();
    }
    /**
     * <code>required .Node senderN = 3;</code>
     */
    public it.grpc.tokenRing.NodeOrBuilder getSenderNOrBuilder() {
      if (senderNBuilder_ != null) {
        return senderNBuilder_.getMessageOrBuilder();
      } else {
        return senderN_ == null ?
            it.grpc.tokenRing.Node.getDefaultInstance() : senderN_;
      }
    }
    /**
     * <code>required .Node senderN = 3;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        it.grpc.tokenRing.Node, it.grpc.tokenRing.Node.Builder, it.grpc.tokenRing.NodeOrBuilder> 
        getSenderNFieldBuilder() {
      if (senderNBuilder_ == null) {
        senderNBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            it.grpc.tokenRing.Node, it.grpc.tokenRing.Node.Builder, it.grpc.tokenRing.NodeOrBuilder>(
                getSenderN(),
                getParentForChildren(),
                isClean());
        senderN_ = null;
      }
      return senderNBuilder_;
    }
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:Exit)
  }

  // @@protoc_insertion_point(class_scope:Exit)
  private static final it.grpc.tokenRing.Exit DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new it.grpc.tokenRing.Exit();
  }

  public static it.grpc.tokenRing.Exit getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  @java.lang.Deprecated public static final com.google.protobuf.Parser<Exit>
      PARSER = new com.google.protobuf.AbstractParser<Exit>() {
    public Exit parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
        return new Exit(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<Exit> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<Exit> getParserForType() {
    return PARSER;
  }

  public it.grpc.tokenRing.Exit getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

