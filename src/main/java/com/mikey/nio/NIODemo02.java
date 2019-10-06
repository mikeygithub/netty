package com.mikey.nio;

import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @ProjectName netty
 * @Author 麦奇
 * @Email biaogejiushibiao@outlook.com
 * @Date 10/4/19 11:23 AM
 * @Version 1.0
 * @Description:
 **/

public class NIODemo02 {
    public static void main(String[] args) throws Exception{

        FileInputStream fileInputStream = new FileInputStream("nio.txt");
        FileChannel channel = fileInputStream.getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocate(512);
        channel.read(byteBuffer);

        byteBuffer.flip();

        while (byteBuffer.remaining()>0){
            byte b = byteBuffer.get();
            System.out.println("Character : "+(char)b);
        }

        fileInputStream.close();

    }
}
