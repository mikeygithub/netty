package com.don.thread;

import io.grpc.netty.shaded.io.netty.util.NettyRuntime;
import io.grpc.netty.shaded.io.netty.util.internal.SystemPropertyUtil;

/**
 * @ProjectName netty
 * @Author 麦奇
 * @Email biaogejiushibiao@outlook.com
 * @Date 10/16/19 9:10 AM
 * @Version 1.0
 * @Description:
 **/

public class Demo {
    public static void main(String[] args) {
        int result = Math.max(1, SystemPropertyUtil.getInt(
                "io.netty.eventLoopThreads", NettyRuntime.availableProcessors() * 2
        ));
        System.out.println("Result:核心数*2="+result);
    }
}
