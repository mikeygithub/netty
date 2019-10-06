package com.mikey.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @ProjectName netty
 * @Author 麦奇
 * @Email biaogejiushibiao@outlook.com
 * @Date 10/4/19 10:53 PM
 * @Version 1.0
 * @Description:
 **/

public class DeepthCopy {

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

        FileInputStream inputStream = new FileInputStream("nio.txt");
        FileOutputStream outputStream = new FileOutputStream("channeloutput.txt");

        FileChannel inputStreamChannel = inputStream.getChannel();
        FileChannel outputStreamChannel = outputStream.getChannel();

        ByteBuffer buffer = ByteBuffer.allocateDirect(1024);

        while (true){
            buffer.clear();
            int read = inputStreamChannel.read(buffer);
            if (read == -1)break;
            buffer.flip();
            outputStreamChannel.write(buffer);
        }

        inputStreamChannel.close();
        outputStreamChannel.close();
    }
}

