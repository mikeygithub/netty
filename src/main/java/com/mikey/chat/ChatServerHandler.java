package com.mikey.chat;

import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;

/**
 * @ProjectName netty
 * @Author 麦奇
 * @Email biaogejiushibiao@outlook.com
 * @Date 9/26/19 9:35 AM
 * @Version 1.0
 * @Description:
 **/

public class ChatServerHandler extends SimpleChannelInboundHandler<String> {

    private  static ChannelGroup channelGroup =new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {

        Channel channel = ctx.channel();

        channelGroup.forEach(ch -> {
            if (channel != ch){
                ch.writeAndFlush("[客户]"+channel.remoteAddress() + "发送的消息：" + msg +"\n");
            }else {
                ch.writeAndFlush("[自己]：" + msg+ "\n");
            }
        });
    }
    //通道激活
    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {

        Channel channel = ctx.channel();

        System.out.println("[服务器]-"+channel.remoteAddress()+"\t离线了");
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {

        Channel channel = ctx.channel();

        System.out.println("[服务器]-"+channel.remoteAddress()+"上线了");
    }

    //连接
    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {

        Channel channel = ctx.channel();

        channelGroup.writeAndFlush("[客户端]-"+ctx.channel().remoteAddress()+"加入聊天\n");

        channelGroup.add(channel);

    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {

        Channel channel = ctx.channel();

        //channels.remove(channel);//可自己调用

        channelGroup.writeAndFlush("[客户端]-"+channel.remoteAddress()+"退出聊天\n");

        System.out.println(channelGroup.size());
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
