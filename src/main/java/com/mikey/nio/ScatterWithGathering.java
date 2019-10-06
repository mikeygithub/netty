package com.mikey.nio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Arrays;

/**
 * @ProjectName netty
 * @Author 麦奇
 * @Email biaogejiushibiao@outlook.com
 * @Date 10/5/19 8:36 AM
 * @Version 1.0
 * @Description:
 **/

public class ScatterWithGathering {
    public static void main(String[] args) throws Exception {

        ServerSocketChannel socketChannel = ServerSocketChannel.open();
        InetSocketAddress address = new InetSocketAddress(8899);
        socketChannel.socket().bind(address);

        int messageLength = 2 + 3 + 4;

        ByteBuffer[] buffers = new ByteBuffer[3];

        buffers[0] = ByteBuffer.allocate(2);
        buffers[1] = ByteBuffer.allocate(3);
        buffers[2] = ByteBuffer.allocate(4);

        SocketChannel accept = socketChannel.accept();

        while (true){
            int bytesRead = 0;
            while (bytesRead < messageLength){
                long r = accept.read(buffers);
                bytesRead += r;
                System.out.println("byteRead:"+bytesRead);
                Arrays.asList(buffers).stream().map(buffer-> "buffer:"+buffer.toString()).forEach(System.out::println);
            }
            Arrays.asList(buffers).forEach(buffer->{
                buffer.flip();
            });

            long byteWritten = 0;
            while (byteWritten < messageLength){
                long r = accept.write(buffers);
                byteWritten+=r;
            }
            Arrays.asList(buffers).forEach(buffer->{
                buffer.clear();
            });

            System.out.println("bytesRead:"+bytesRead);
            System.out.println("bytesWritten:"+byteWritten);
            System.out.println("messageLength:"+messageLength);
        }
    }
}
