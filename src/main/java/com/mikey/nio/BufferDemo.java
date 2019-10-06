package com.mikey.nio;

import java.nio.ByteBuffer;

/**
 * @ProjectName netty
 * @Author 麦奇
 * @Email biaogejiushibiao@outlook.com
 * @Date 10/4/19 10:17 PM
 * @Version 1.0
 * @Description:
 **/

public class BufferDemo {
    public static void main(String[] args) {

        ByteBuffer allocate = ByteBuffer.allocate(64);

        allocate.putInt(15);
        allocate.putLong(12345678L);
        allocate.putDouble(33333.33333);
        allocate.putChar('我');
        allocate.putShort((short) 1);
        allocate.putChar('你');

        allocate.flip();

        System.out.println(allocate.getInt());
        System.out.println(allocate.getLong());
        System.out.println(allocate.getDouble());
        System.out.println(allocate.getChar());
        System.out.println(allocate.getShort());
        System.out.println(allocate.getChar());
    }
}
