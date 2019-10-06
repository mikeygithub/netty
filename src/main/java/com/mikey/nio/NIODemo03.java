package com.mikey.nio;

import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @ProjectName netty
 * @Author 麦奇
 * @Email biaogejiushibiao@outlook.com
 * @Date 10/4/19 11:31 AM
 * @Version 1.0
 * @Description:
 **/

public class NIODemo03 {
    public static void main(String[] args) throws Exception{
        FileOutputStream fileOutputStream = new FileOutputStream("niooutput.txt");
        FileChannel channel = fileOutputStream.getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocate(26);
        byte[] bytes = "hello world welcome to nio".getBytes();

        System.out.println(byteBuffer.toString());
        System.out.println("--------------------before-------------------");

        for (int i = 0; i < bytes.length; i++) {
            byteBuffer.put(bytes[i]);
            System.out.println(byteBuffer.toString());
        }
        //将lim = pos,pos = 0
        byteBuffer.flip();
        System.out.println("--------------------flip---------------------");
        System.out.println(byteBuffer.toString());

        byteBuffer.get();
        System.out.println("--------------------get---------------------");
        System.out.println("position:"+byteBuffer.position()+"\tlimit:"+byteBuffer.limit()+"\tcapacity:"+byteBuffer.capacity());

        byteBuffer.put("0".getBytes());
        byteBuffer.put("0".getBytes());
        byteBuffer.put("0".getBytes());
        byteBuffer.put("0".getBytes());
        System.out.println("--------------------put---------------------");
        System.out.println(byteBuffer.toString());

        byteBuffer.flip();
        System.out.println("--------------------flip---------------------");
        System.out.println(byteBuffer.toString());
        channel.write(byteBuffer);


//        System.out.println("=====================java.nio.BufferOverflowException===========================");
//        for (int i = 0; i < bytes.length; i++) {
//            byteBuffer.put(bytes[i]);
//            System.out.println(byteBuffer.toString());
//        }
        byteBuffer.clear();
        System.out.println("--------------------clear---------------------");
        System.out.println(byteBuffer.toString());
        fileOutputStream.close();

    }
}
