// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Student.proto

package com.mikey.grpcstream;

public interface StudentResponseListOrBuilder extends
    // @@protoc_insertion_point(interface_extends:com.mikey.grpc.StudentResponseList)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>repeated .com.mikey.grpc.StudentResponse studentResponse = 1;</code>
   */
  java.util.List<com.mikey.grpcstream.StudentResponse> 
      getStudentResponseList();
  /**
   * <code>repeated .com.mikey.grpc.StudentResponse studentResponse = 1;</code>
   */
  com.mikey.grpcstream.StudentResponse getStudentResponse(int index);
  /**
   * <code>repeated .com.mikey.grpc.StudentResponse studentResponse = 1;</code>
   */
  int getStudentResponseCount();
  /**
   * <code>repeated .com.mikey.grpc.StudentResponse studentResponse = 1;</code>
   */
  java.util.List<? extends com.mikey.grpcstream.StudentResponseOrBuilder> 
      getStudentResponseOrBuilderList();
  /**
   * <code>repeated .com.mikey.grpc.StudentResponse studentResponse = 1;</code>
   */
  com.mikey.grpcstream.StudentResponseOrBuilder getStudentResponseOrBuilder(
      int index);
}
