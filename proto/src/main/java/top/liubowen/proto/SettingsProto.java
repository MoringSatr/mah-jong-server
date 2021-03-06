// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: settings.proto

package top.liubowen.proto;

public final class SettingsProto {
  private SettingsProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  public interface SettingsMsgOrBuilder extends
      // @@protoc_insertion_point(interface_extends:settingsProto.SettingsMsg)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <pre>
     *  背景音乐
     * </pre>
     *
     * <code>int32 background_music = 1;</code>
     */
    int getBackgroundMusic();

    /**
     * <pre>
     *  音效
     * </pre>
     *
     * <code>int32 sound_effect = 2;</code>
     */
    int getSoundEffect();
  }
  /**
   * <pre>
   ** 用户设置信息 
   * </pre>
   *
   * Protobuf type {@code settingsProto.SettingsMsg}
   */
  public  static final class SettingsMsg extends
      com.google.protobuf.GeneratedMessageV3 implements
      // @@protoc_insertion_point(message_implements:settingsProto.SettingsMsg)
      SettingsMsgOrBuilder {
  private static final long serialVersionUID = 0L;
    // Use SettingsMsg.newBuilder() to construct.
    private SettingsMsg(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private SettingsMsg() {
      backgroundMusic_ = 0;
      soundEffect_ = 0;
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return this.unknownFields;
    }
    private SettingsMsg(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      this();
      if (extensionRegistry == null) {
        throw new java.lang.NullPointerException();
      }
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
              if (!parseUnknownFieldProto3(
                  input, unknownFields, extensionRegistry, tag)) {
                done = true;
              }
              break;
            }
            case 8: {

              backgroundMusic_ = input.readInt32();
              break;
            }
            case 16: {

              soundEffect_ = input.readInt32();
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
      return top.liubowen.proto.SettingsProto.internal_static_settingsProto_SettingsMsg_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return top.liubowen.proto.SettingsProto.internal_static_settingsProto_SettingsMsg_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              top.liubowen.proto.SettingsProto.SettingsMsg.class, top.liubowen.proto.SettingsProto.SettingsMsg.Builder.class);
    }

    public static final int BACKGROUND_MUSIC_FIELD_NUMBER = 1;
    private int backgroundMusic_;
    /**
     * <pre>
     *  背景音乐
     * </pre>
     *
     * <code>int32 background_music = 1;</code>
     */
    public int getBackgroundMusic() {
      return backgroundMusic_;
    }

    public static final int SOUND_EFFECT_FIELD_NUMBER = 2;
    private int soundEffect_;
    /**
     * <pre>
     *  音效
     * </pre>
     *
     * <code>int32 sound_effect = 2;</code>
     */
    public int getSoundEffect() {
      return soundEffect_;
    }

    private byte memoizedIsInitialized = -1;
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized == 1) return true;
      if (isInitialized == 0) return false;

      memoizedIsInitialized = 1;
      return true;
    }

    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      if (backgroundMusic_ != 0) {
        output.writeInt32(1, backgroundMusic_);
      }
      if (soundEffect_ != 0) {
        output.writeInt32(2, soundEffect_);
      }
      unknownFields.writeTo(output);
    }

    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (backgroundMusic_ != 0) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt32Size(1, backgroundMusic_);
      }
      if (soundEffect_ != 0) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt32Size(2, soundEffect_);
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
      if (!(obj instanceof top.liubowen.proto.SettingsProto.SettingsMsg)) {
        return super.equals(obj);
      }
      top.liubowen.proto.SettingsProto.SettingsMsg other = (top.liubowen.proto.SettingsProto.SettingsMsg) obj;

      boolean result = true;
      result = result && (getBackgroundMusic()
          == other.getBackgroundMusic());
      result = result && (getSoundEffect()
          == other.getSoundEffect());
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
      hash = (37 * hash) + BACKGROUND_MUSIC_FIELD_NUMBER;
      hash = (53 * hash) + getBackgroundMusic();
      hash = (37 * hash) + SOUND_EFFECT_FIELD_NUMBER;
      hash = (53 * hash) + getSoundEffect();
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static top.liubowen.proto.SettingsProto.SettingsMsg parseFrom(
        java.nio.ByteBuffer data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static top.liubowen.proto.SettingsProto.SettingsMsg parseFrom(
        java.nio.ByteBuffer data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static top.liubowen.proto.SettingsProto.SettingsMsg parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static top.liubowen.proto.SettingsProto.SettingsMsg parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static top.liubowen.proto.SettingsProto.SettingsMsg parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static top.liubowen.proto.SettingsProto.SettingsMsg parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static top.liubowen.proto.SettingsProto.SettingsMsg parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static top.liubowen.proto.SettingsProto.SettingsMsg parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static top.liubowen.proto.SettingsProto.SettingsMsg parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input);
    }
    public static top.liubowen.proto.SettingsProto.SettingsMsg parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static top.liubowen.proto.SettingsProto.SettingsMsg parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static top.liubowen.proto.SettingsProto.SettingsMsg parseFrom(
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
    public static Builder newBuilder(top.liubowen.proto.SettingsProto.SettingsMsg prototype) {
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
     * <pre>
     ** 用户设置信息 
     * </pre>
     *
     * Protobuf type {@code settingsProto.SettingsMsg}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:settingsProto.SettingsMsg)
        top.liubowen.proto.SettingsProto.SettingsMsgOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return top.liubowen.proto.SettingsProto.internal_static_settingsProto_SettingsMsg_descriptor;
      }

      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return top.liubowen.proto.SettingsProto.internal_static_settingsProto_SettingsMsg_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                top.liubowen.proto.SettingsProto.SettingsMsg.class, top.liubowen.proto.SettingsProto.SettingsMsg.Builder.class);
      }

      // Construct using top.liubowen.proto.SettingsProto.SettingsMsg.newBuilder()
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
        }
      }
      public Builder clear() {
        super.clear();
        backgroundMusic_ = 0;

        soundEffect_ = 0;

        return this;
      }

      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return top.liubowen.proto.SettingsProto.internal_static_settingsProto_SettingsMsg_descriptor;
      }

      public top.liubowen.proto.SettingsProto.SettingsMsg getDefaultInstanceForType() {
        return top.liubowen.proto.SettingsProto.SettingsMsg.getDefaultInstance();
      }

      public top.liubowen.proto.SettingsProto.SettingsMsg build() {
        top.liubowen.proto.SettingsProto.SettingsMsg result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      public top.liubowen.proto.SettingsProto.SettingsMsg buildPartial() {
        top.liubowen.proto.SettingsProto.SettingsMsg result = new top.liubowen.proto.SettingsProto.SettingsMsg(this);
        result.backgroundMusic_ = backgroundMusic_;
        result.soundEffect_ = soundEffect_;
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
        if (other instanceof top.liubowen.proto.SettingsProto.SettingsMsg) {
          return mergeFrom((top.liubowen.proto.SettingsProto.SettingsMsg)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(top.liubowen.proto.SettingsProto.SettingsMsg other) {
        if (other == top.liubowen.proto.SettingsProto.SettingsMsg.getDefaultInstance()) return this;
        if (other.getBackgroundMusic() != 0) {
          setBackgroundMusic(other.getBackgroundMusic());
        }
        if (other.getSoundEffect() != 0) {
          setSoundEffect(other.getSoundEffect());
        }
        this.mergeUnknownFields(other.unknownFields);
        onChanged();
        return this;
      }

      public final boolean isInitialized() {
        return true;
      }

      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        top.liubowen.proto.SettingsProto.SettingsMsg parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (top.liubowen.proto.SettingsProto.SettingsMsg) e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }

      private int backgroundMusic_ ;
      /**
       * <pre>
       *  背景音乐
       * </pre>
       *
       * <code>int32 background_music = 1;</code>
       */
      public int getBackgroundMusic() {
        return backgroundMusic_;
      }
      /**
       * <pre>
       *  背景音乐
       * </pre>
       *
       * <code>int32 background_music = 1;</code>
       */
      public Builder setBackgroundMusic(int value) {
        
        backgroundMusic_ = value;
        onChanged();
        return this;
      }
      /**
       * <pre>
       *  背景音乐
       * </pre>
       *
       * <code>int32 background_music = 1;</code>
       */
      public Builder clearBackgroundMusic() {
        
        backgroundMusic_ = 0;
        onChanged();
        return this;
      }

      private int soundEffect_ ;
      /**
       * <pre>
       *  音效
       * </pre>
       *
       * <code>int32 sound_effect = 2;</code>
       */
      public int getSoundEffect() {
        return soundEffect_;
      }
      /**
       * <pre>
       *  音效
       * </pre>
       *
       * <code>int32 sound_effect = 2;</code>
       */
      public Builder setSoundEffect(int value) {
        
        soundEffect_ = value;
        onChanged();
        return this;
      }
      /**
       * <pre>
       *  音效
       * </pre>
       *
       * <code>int32 sound_effect = 2;</code>
       */
      public Builder clearSoundEffect() {
        
        soundEffect_ = 0;
        onChanged();
        return this;
      }
      public final Builder setUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.setUnknownFieldsProto3(unknownFields);
      }

      public final Builder mergeUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.mergeUnknownFields(unknownFields);
      }


      // @@protoc_insertion_point(builder_scope:settingsProto.SettingsMsg)
    }

    // @@protoc_insertion_point(class_scope:settingsProto.SettingsMsg)
    private static final top.liubowen.proto.SettingsProto.SettingsMsg DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new top.liubowen.proto.SettingsProto.SettingsMsg();
    }

    public static top.liubowen.proto.SettingsProto.SettingsMsg getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<SettingsMsg>
        PARSER = new com.google.protobuf.AbstractParser<SettingsMsg>() {
      public SettingsMsg parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
        return new SettingsMsg(input, extensionRegistry);
      }
    };

    public static com.google.protobuf.Parser<SettingsMsg> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<SettingsMsg> getParserForType() {
      return PARSER;
    }

    public top.liubowen.proto.SettingsProto.SettingsMsg getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_settingsProto_SettingsMsg_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_settingsProto_SettingsMsg_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\016settings.proto\022\rsettingsProto\"=\n\013Setti" +
      "ngsMsg\022\030\n\020background_music\030\001 \001(\005\022\024\n\014soun" +
      "d_effect\030\002 \001(\005B#\n\022top.liubowen.protoB\rSe" +
      "ttingsProtob\006proto3"
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
    internal_static_settingsProto_SettingsMsg_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_settingsProto_SettingsMsg_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_settingsProto_SettingsMsg_descriptor,
        new java.lang.String[] { "BackgroundMusic", "SoundEffect", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
