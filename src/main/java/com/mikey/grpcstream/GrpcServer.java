package com.mikey.grpcstream;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.util.logging.Logger;

/**
 * @ProjectName netty
 * @Author 麦奇
 * @Email biaogejiushibiao@outlook.com
 * @Date 10/2/19 12:33 PM
 * @Version 1.0
 * @Description:
 **/

public class GrpcServer {

    private static final Logger logger = Logger.getLogger(com.mikey.grpcstream.GrpcServer.class.getName());

    private Server server;

    private void start() throws Exception{
        this.server = ServerBuilder.forPort(GrpcClient.PORT).addService(new StudentGrpcImpl()).build().start();
        logger.info("The Server Already Start");
        Runtime.getRuntime().addShutdownHook(new Thread(()->{
            logger.info("关闭jvm");
            GrpcServer.this.stop();
        }));
    }

    private void stop() {
        if (null != this.server){
            this.server.shutdown();
        }
    }

    private void awaitTermination () throws Exception {
        if (null != this.server){
            this.server.awaitTermination();
        }
    }

    public static void main(String[] args) throws Exception {

        GrpcServer grpcServer = new GrpcServer();

        grpcServer.start();

        grpcServer.awaitTermination();

    }
}
