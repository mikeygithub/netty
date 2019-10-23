package com.don.bytebuf;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.CompositeByteBuf;
import io.netty.buffer.Unpooled;

import java.nio.ByteBuffer;
import java.util.Iterator;

/**
 * @ProjectName netty
 * @Author 麦奇
 * @Email biaogejiushibiao@outlook.com
 * @Date 10/23/19 10:08 AM
 * @Version 1.0
 * @Description:复合Buffe
 *  TODO: Composite Buffer (复合缓冲区)
 *  其可包含多个缓冲区r
 **/

public class CompositeBuffer {

    public static void main(String[] args) {

//        ByteBuffer

        CompositeByteBuf compositeByteBuf = Unpooled.compositeBuffer();

        ByteBuf heappBuf = Unpooled.buffer(10);

        ByteBuf directBuffer = Unpooled.directBuffer(8);

        compositeByteBuf.addComponents(heappBuf,directBuffer);

        Iterator<ByteBuf> iterator = compositeByteBuf.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        compositeByteBuf.forEach(System.out::println);
    }
}
