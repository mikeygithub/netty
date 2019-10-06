package com.mikey.grpc;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.ClientCalls;

import java.util.logging.Logger;

/**
 * @ProjectName netty
 * @Author 麦奇
 * @Email biaogejiushibiao@outlook.com
 * @Date 10/2/19 11:02 AM
 * @Version 1.0
 * @Description:
 **/

public class GrpcClient {

    private static final Logger logger = Logger.getLogger(GrpcClient.class.getName());

    public static final String HOST_ADDRESS = "localhost";

    public static final Integer PORT = 8899;

    public static void main(String[] args) throws Exception{

        //构建配置
        ManagedChannelBuilder<?> builder = ManagedChannelBuilder.forAddress(HOST_ADDRESS, PORT).usePlaintext(true);
        //传输管道
        ManagedChannel channel = builder.build();
        //构建请求
        Request request = Request.newBuilder().setUsername("麦奇").build();
        //构建非阻塞服务调用
        StudentServiceGrpc.StudentServiceBlockingStub blockingStub = StudentServiceGrpc.newBlockingStub(channel);
        //服务调用并接收返回参数
        Response response = blockingStub.getRealNameByUserName(request);
        //打印信息
        logger.info(response.getRealname());
        //关闭资源
        channel.shutdown();

    }
}
