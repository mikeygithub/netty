package com.don.bytebuf;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

import java.nio.charset.Charset;

/**
 * @ProjectName netty
 * @Author 麦奇
 * @Email biaogejiushibiao@outlook.com
 * @Date 10/23/19 9:42 AM
 * @Version 1.0
 * @Description:
 **/

public class CopiedBufferDemo {
    public static void main(String[] args) {

        ByteBuf copiedBuffer = Unpooled.copiedBuffer("hello netty 广西\n", Charset.forName("utf-8"));

        if (copiedBuffer.hasArray()){
            byte[] content = copiedBuffer.array();
            System.out.println(new String(content,Charset.forName("utf-8")));
        }
        System.out.println(copiedBuffer);

        System.out.println("偏移量="+copiedBuffer.arrayOffset());
        System.out.println("读指针="+copiedBuffer.readerIndex());
        System.out.println("写指针="+copiedBuffer.writerIndex());
        System.out.println("容量="+copiedBuffer.capacity());
    }
}
