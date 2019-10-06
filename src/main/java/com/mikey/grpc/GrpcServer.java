package com.mikey.grpc;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.util.logging.Logger;

/**
 * @ProjectName netty
 * @Author 麦奇
 * @Email biaogejiushibiao@outlook.com
 * @Date 10/2/19 11:02 AM
 * @Version 1.0
 * @Description:
 **/

public class GrpcServer {

    private static final Logger logger = Logger.getLogger(GrpcServer.class.getName());

    public static void main(String[] args) throws Exception{

        Server start = ServerBuilder.forPort(8899)
                .addService(new com.mikey.grpc.StudentServiceImpl())
                .build()
                .start();
        //阻塞
        start.awaitTermination();
        logger.info("Server started, listening on " + start.getPort());
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                // Use stderr here since the logger may have been reset by its JVM shutdown hook.
                System.err.println("*** shutting down gRPC server since JVM is shutting down");
                start.shutdown();
                System.err.println("*** server shut down");
            }
        });
    }
}
