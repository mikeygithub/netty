package com.mikey.socket;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.util.Scanner;

/**
 * @ProjectName netty
 * @Author 麦奇
 * @Email biaogejiushibiao@outlook.com
 * @Date 9/25/19 11:05 PM
 * @Version 1.0
 * @Description:
 **/

public class Client {

    public static void main(String[] args) throws InterruptedException {

        EventLoopGroup eventExecutors = new NioEventLoopGroup();


        try {
            Bootstrap bootstrap = new Bootstrap();

            bootstrap.group(eventExecutors)
                    .channel(NioSocketChannel.class)
                    .handler(new ClientInitializer());
            ChannelFuture localhost = bootstrap.connect("localhost", 8888);

            localhost.channel().closeFuture().sync();

        }finally {
            eventExecutors.shutdownGracefully().sync();
        }
    }
}
