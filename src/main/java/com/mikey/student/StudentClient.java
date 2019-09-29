package com.mikey.student;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;

/**
 * @ProjectName netty
 * @Author 麦奇
 * @Email biaogejiushibiao@outlook.com
 * @Date 9/28/19 10:51 PM
 * @Version 1.0
 * @Description:
 **/

public class StudentClient {

    public static void main(String[] args) throws Exception{

        NioEventLoopGroup eventExecutors = new NioEventLoopGroup();

        try {

            Bootstrap bootstrap = new Bootstrap();

            bootstrap.group(eventExecutors)
                    .channel(NioSocketChannel.class)
                    .handler(new LoggingHandler(LogLevel.INFO))
                    .handler(new StudentClientInitializer());

            bootstrap.connect("localhost",8899).sync();

        }finally {
            eventExecutors.shutdownGracefully().sync();
        }

    }
}
