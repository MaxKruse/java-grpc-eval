// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: simple_service.proto

package xyz.mkruse.sdk;

public final class SimpleService {
  private SimpleService() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_sdk_GetUserRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_sdk_GetUserRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_sdk_GetUserResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_sdk_GetUserResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_sdk_CreateUserRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_sdk_CreateUserRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_sdk_CreateUserResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_sdk_CreateUserResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_sdk_User_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_sdk_User_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\024simple_service.proto\022\003sdk\"\034\n\016GetUserRe" +
      "quest\022\n\n\002id\030\001 \001(\t\"*\n\017GetUserResponse\022\027\n\004" +
      "user\030\001 \001(\0132\t.sdk.User\",\n\021CreateUserReque" +
      "st\022\027\n\004user\030\001 \001(\0132\t.sdk.User\"-\n\022CreateUse" +
      "rResponse\022\027\n\004user\030\001 \001(\0132\t.sdk.User\"/\n\004Us" +
      "er\022\n\n\002id\030\001 \001(\t\022\014\n\004name\030\002 \001(\t\022\r\n\005email\030\003 " +
      "\001(\t2\206\001\n\013UserService\0226\n\007GetUser\022\023.sdk.Get" +
      "UserRequest\032\024.sdk.GetUserResponse\"\000\022?\n\nC" +
      "reateUser\022\026.sdk.CreateUserRequest\032\027.sdk." +
      "CreateUserResponse\"\000B\022\n\016xyz.mkruse.sdkP\001" +
      "b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_sdk_GetUserRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_sdk_GetUserRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_sdk_GetUserRequest_descriptor,
        new java.lang.String[] { "Id", });
    internal_static_sdk_GetUserResponse_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_sdk_GetUserResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_sdk_GetUserResponse_descriptor,
        new java.lang.String[] { "User", });
    internal_static_sdk_CreateUserRequest_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_sdk_CreateUserRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_sdk_CreateUserRequest_descriptor,
        new java.lang.String[] { "User", });
    internal_static_sdk_CreateUserResponse_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_sdk_CreateUserResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_sdk_CreateUserResponse_descriptor,
        new java.lang.String[] { "User", });
    internal_static_sdk_User_descriptor =
      getDescriptor().getMessageTypes().get(4);
    internal_static_sdk_User_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_sdk_User_descriptor,
        new java.lang.String[] { "Id", "Name", "Email", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
