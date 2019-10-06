package com.mikey.grpcstream;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.util.Iterator;
import java.util.logging.Logger;

/**
 * @ProjectName netty
 * @Author 麦奇
 * @Email biaogejiushibiao@outlook.com
 * @Date 10/2/19 12:33 PM
 * @Version 1.0
 * @Description:
 **/

public class GrpcClient {

    private static final Logger logger = Logger.getLogger(com.mikey.grpcstream.GrpcClient.class.getName());

    public static final String HOST_ADDRESS = "localhost";

    public static final Integer PORT = 8899;

    public static void main(String[] args) {

        ManagedChannel build = ManagedChannelBuilder.forAddress(HOST_ADDRESS, PORT)
                .usePlaintext(true)
                .build();

        StudentServiceGrpc.StudentServiceBlockingStub studentServiceBlockingStub = StudentServiceGrpc.newBlockingStub(build);
        //1
        Response mikey = studentServiceBlockingStub.getRealNameByUserName(Request.newBuilder().setUsername("mikey").build());
        logger.info("method one return :"+mikey.getRealname());
        //2
        Iterator<StudentResponse> studentByAge = studentServiceBlockingStub.getStudentByAge(Request.newBuilder().setUsername("20").build());
        studentByAge.forEachRemaining(studentResponse -> {
            logger.info("-----------------------");
            logger.info(studentResponse.getName());
            logger.info(studentResponse.getCity());
            logger.info(studentResponse.getAge()+"");
        });
        //3
    }
}
