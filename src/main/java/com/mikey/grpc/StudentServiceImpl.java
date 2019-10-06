package com.mikey.grpc;

import io.grpc.stub.StreamObserver;

/**
 * @ProjectName netty
 * @Author 麦奇
 * @Email biaogejiushibiao@outlook.com
 * @Date 10/2/19 10:55 AM
 * @Version 1.0
 * @Description:
 **/

public class StudentServiceImpl extends StudentServiceGrpc.StudentServiceImplBase{

    @Override
    public void getRealNameByUserName(Request request, StreamObserver<Response> responseObserver) {

        System.out.println("接收到客户端信息："+request.getUsername());

        responseObserver.onNext(Response.newBuilder().setRealname(request.getUsername()).build());

        responseObserver.onCompleted();

    }
}
