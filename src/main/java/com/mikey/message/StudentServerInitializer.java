//package com.mikey.message;
//
//import nio.netty.channel.ChannelInitializer;
//import nio.netty.channel.ChannelPipeline;
//import nio.netty.channel.socket.SocketChannel;
//import nio.netty.handler.codec.protobuf.ProtobufDecoder;
//import nio.netty.handler.codec.protobuf.ProtobufEncoder;
//import nio.netty.handler.codec.protobuf.ProtobufVarint32FrameDecoder;
//import nio.netty.handler.codec.protobuf.ProtobufVarint32LengthFieldPrepender;
//
///**
// * @ProjectName netty
// * @Author 麦奇
// * @Email biaogejiushibiao@outlook.com
// * @Date 9/28/19 10:45 PM
// * @Version 1.0
// * @Description:
// **/
//
//public class StudentServerInitializer extends ChannelInitializer<SocketChannel> {
//    @Override
//    protected void initChannel(SocketChannel ch) throws Exception {
//        ChannelPipeline pipeline = ch.pipeline();
//        pipeline.addLast(new ProtobufVarint32FrameDecoder());
//        pipeline.addLast(new ProtobufDecoder(DataInfo.Messages.getDefaultInstance()));
//        pipeline.addLast(new ProtobufVarint32LengthFieldPrepender());
//        pipeline.addLast(new ProtobufEncoder());
//        pipeline.addLast(new StudnetServerHandler());
//    }
//}
