package com.mikey.socket;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.time.LocalDateTime;
import java.util.Scanner;
import java.util.UUID;

/**
 * @ProjectName netty
 * @Author 麦奇
 * @Email biaogejiushibiao@outlook.com
 * @Date 9/25/19 11:12 PM
 * @Version 1.0
 * @Description:
 **/

public class ClientHandler extends SimpleChannelInboundHandler<String> {

        @Override
        protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {

            System.out.println(ctx.channel().remoteAddress());

            System.out.println("client output:"+msg);

            ctx.channel().writeAndFlush("from client:"+ LocalDateTime.now());

        }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {

        Scanner scanner = new Scanner(System.in);

        System.out.println("请输入msg：");

        String s = scanner.nextLine();

        ctx.channel().writeAndFlush(s);
    }

    @Override
        public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
            cause.printStackTrace();
            ctx.close();
        }
}
