package com.mikey.demo;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * @ProjectName netty
 * @Author 麦奇
 * @Email biaogejiushibiao@outlook.com
 * @Date 9/25/19 5:29 PM
 * @Version 1.0
 * @Description:
 **/

public class Server {
    public static void main(String[] args) throws Exception{

        //事件线程组
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        NioEventLoopGroup workGroup = new NioEventLoopGroup();

        try {

            ServerBootstrap serverBootstrap = new ServerBootstrap();

            serverBootstrap.group(bossGroup,workGroup)
                .channel(NioServerSocketChannel.class)
                .childHandler(new ServerInitializer());//自定义

            ChannelFuture sync = serverBootstrap.bind(8899).sync();

            sync.channel().closeFuture().sync();

        }finally {
            bossGroup.shutdownGracefully();
            workGroup.shutdownGracefully();
        }
    }
}
