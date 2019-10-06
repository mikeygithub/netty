//package com.mikey.message;
//
//import nio.netty.bootstrap.ServerBootstrap;
//import nio.netty.channel.ChannelFuture;
//import nio.netty.channel.nio.NioEventLoopGroup;
//import nio.netty.channel.socket.nio.NioServerSocketChannel;
//import nio.netty.handler.logging.LogLevel;
//import nio.netty.handler.logging.LoggingHandler;
//
///**
// * @ProjectName netty
// * @Author 麦奇
// * @Email biaogejiushibiao@outlook.com
// * @Date 9/28/19 10:39 PM
// * @Version 1.0
// * @Description:
// **/
//
//public class StudentServer {
//
//    public static void main(String[] args) throws Exception {
//
//
//        NioEventLoopGroup bossGroup = new NioEventLoopGroup();
//
//        NioEventLoopGroup workGroup = new NioEventLoopGroup();
//
//        try {
//            ServerBootstrap serverBootstrap = new ServerBootstrap();
//
//            serverBootstrap.group(bossGroup,workGroup)
//                    .channel(NioServerSocketChannel.class)
//                    .handler(new LoggingHandler(LogLevel.INFO))
//                    .childHandler(new StudentServerInitializer());
//
//            ChannelFuture future = serverBootstrap.bind(8899).sync();
//
//            future.channel().closeFuture().sync();
//
//        }finally {
//            bossGroup.shutdownGracefully().sync();
//            bossGroup.shutdownGracefully().sync();
//        }
//
//    }
//}
