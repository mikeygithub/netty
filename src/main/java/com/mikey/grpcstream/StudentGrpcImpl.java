package com.mikey.grpcstream;

import io.grpc.stub.ServerCallStreamObserver;
import io.grpc.stub.StreamObserver;

import java.util.logging.Logger;

/**
 * @ProjectName netty
 * @Author 麦奇
 * @Email biaogejiushibiao@outlook.com
 * @Date 10/2/19 12:28 PM
 * @Version 1.0
 * @Description:
 **/

public class StudentGrpcImpl extends com.mikey.grpcstream.StudentServiceGrpc.StudentServiceImplBase {

    private static final Logger logger = Logger.getLogger(StudentGrpcImpl.class.getName());

    @Override
    public void getRealNameByUserName(Request request, StreamObserver<Response> responseObserver) {
        logger.info("参数："+request.getUsername());
        responseObserver.onNext(Response.newBuilder().setRealname("阿姆斯特朗").build());
        responseObserver.onCompleted();
    }

    @Override
    public void getStudentByAge(Request request, StreamObserver<StudentResponse> responseObserver) {
        logger.info("参数："+request.getUsername());
        responseObserver.onNext(StudentResponse.newBuilder().setName("里奥").setAge(20).setCity("北京").build());
        responseObserver.onNext(StudentResponse.newBuilder().setName("麦奇").setAge(20).setCity("柳州").build());
        responseObserver.onNext(StudentResponse.newBuilder().setName("达芬奇").setAge(20).setCity("深圳").build());
        responseObserver.onCompleted();
    }

    @Override
    public StreamObserver<StudentResponseList> getStudentByStream(StreamObserver<StudentResponse> responseObserver) {

        StudentResponse build1 = StudentResponse.newBuilder().setName("1111111111").setAge(111111111).setCity("11111111111").build();
        StudentResponse build2 = StudentResponse.newBuilder().setName("1111111111").setAge(111111111).setCity("11111111111").build();
        StudentResponse build3 = StudentResponse.newBuilder().setName("1111111111").setAge(111111111).setCity("11111111111").build();

       return new StreamObserver<StudentResponseList>() {
           @Override
           public void onNext(StudentResponseList value) {

           }
           @Override
           public void onError(Throwable t) {

           }
           @Override
           public void onCompleted() {
               responseObserver.onNext(build1);
               responseObserver.onNext(build2);
               responseObserver.onNext(build3);
               responseObserver.onCompleted();
           }
       };
    }

    @Override
    public StreamObserver<StreamRequest> biTalk(StreamObserver<StreamResponse> responseObserver) {
        return new StreamObserver<StreamRequest>() {
            @Override
            public void onNext(StreamRequest value) {

            }

            @Override
            public void onError(Throwable t) {

            }

            @Override
            public void onCompleted() {

            }
        };
    }
}
