package com.mikey.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @ProjectName netty
 * @Author 麦奇
 * @Email biaogejiushibiao@outlook.com
 * @Date 10/4/19 9:33 PM
 * @Version 1.0
 * @Description:
 **/

public class ChannelDemo {

    public static void main(String[] args) throws Exception{
        demo(args);
//        FileInputStream fileInputStream = new FileInputStream("nio.txt");
//        FileOutputStream fileOutputStream = new FileOutputStream("channeloutput.txt");
//
//        FileChannel inputStreamChannel = fileInputStream.getChannel();
//        FileChannel outputStreamChannel = fileOutputStream.getChannel();
//
//        outputStreamChannel.transferTo(inputStreamChannel)
    }

    public static void demo(String[] args) throws Exception{

        FileInputStream fileInputStream = new FileInputStream("nio.txt");
        FileOutputStream fileOutputStream = new FileOutputStream("channeloutput.txt");

        FileChannel inputStreamChannel = fileInputStream.getChannel();
        FileChannel outputStreamChannel = fileOutputStream.getChannel();

        ByteBuffer buffer = ByteBuffer.allocate(1024);

        while (true){
//            buffer.clear();
            System.out.println("A:===>>>"+buffer);
            //pos==lim return 0
            int read = inputStreamChannel.read(buffer);
            System.out.println("阅读的字节个数："+read);
            if (read == -1)break;
            //lim=145 pos=0
            buffer.flip();
            System.out.println("B:===>>>"+buffer);
            //lim=145 pos=145
            int write = outputStreamChannel.write(buffer);
            System.out.println("C:===>>>"+buffer);
            System.out.println("写入的字节个数："+write);
        }

        inputStreamChannel.close();
        outputStreamChannel.close();
    }
}
