package com.mikey.heartjump;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.timeout.IdleStateHandler;

import java.util.concurrent.TimeUnit;


/**
 * @ProjectName netty
 * @Author 麦奇
 * @Email biaogejiushibiao@outlook.com
 * @Date 9/28/19 10:33 AM
 * @Version 1.0
 * @Description:
 **/

public class HeartJumpServerInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel ch) throws Exception {

        ChannelPipeline pipeline = ch.pipeline();
        // netty 提供的空闲检测
        pipeline.addLast(new IdleStateHandler(5,7,4, TimeUnit.SECONDS));
        // 自定义的空闲检测
        pipeline.addLast(new HeartJumpServerHandler());
    }
}
