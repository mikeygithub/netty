package com.mikey.nio;

import java.nio.ByteBuffer;

/**
 * @ProjectName netty
 * @Author 麦奇
 * @Email biaogejiushibiao@outlook.com
 * @Date 10/4/19 10:46 PM
 * @Version 1.0
 * @Description:只读buffer
 **/

public class ReadOnlyBuffer {
    public static void main(String[] args) {

        ByteBuffer allocate = ByteBuffer.allocate(10);

        for (int i = 0; i <allocate.capacity(); i++) {
            allocate.putInt(i);
        }

        ByteBuffer readOnlyBuffer = allocate.asReadOnlyBuffer();

        for (int i = 0; i < readOnlyBuffer.capacity(); i++) {
            System.out.println(readOnlyBuffer.get());
        }

        //readOnlyBuffer.putInt(77);//error
    }
}
