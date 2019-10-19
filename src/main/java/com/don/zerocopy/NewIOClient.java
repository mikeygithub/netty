package com.don.zerocopy;

import java.io.FileInputStream;
import java.net.InetSocketAddress;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;

/**
 * @ProjectName netty
 * @Author 麦奇
 * @Email biaogejiushibiao@outlook.com
 * @Date 10/15/19 10:59 PM
 * @Version 1.0
 * @Description:
 **/

public class NewIOClient {

    public static void main(String[] args) throws Exception{

        SocketChannel open = SocketChannel.open();

        open.connect(new InetSocketAddress("localhost",8899));

        open.configureBlocking(true);

        String fileName = "/home/mikey/下载/thrift-0.12.0.tar.gz";

        FileChannel fileChannel = new FileInputStream(fileName).getChannel();

        long startTime = System.currentTimeMillis();

        /**
         * <p> This method is potentially much more efficient than a simple loop
         * that reads from the source channel and writes to this channel.  Many
         * operating systems can transfer bytes directly from the source channel
         * into the filesystem cache without actually copying them.  </p>
         */
        long transferTo = fileChannel.transferTo(0, fileChannel.size(), open);

        System.out.println("发送总字节数目："+transferTo+",耗时"+((System.currentTimeMillis()-startTime)));
        /**
         * 发送总字节数目：3906291,耗时12
         */
    }
}
