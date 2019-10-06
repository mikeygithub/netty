package com.mikey.nio;

import java.nio.ByteBuffer;

/**
 * @ProjectName netty
 * @Author 麦奇
 * @Email biaogejiushibiao@outlook.com
 * @Date 10/4/19 10:41 PM
 * @Version 1.0
 * @Description:
 **/

public class SliceBuffer {

    public static void main(String[] args) {

        ByteBuffer allocate = ByteBuffer.allocate(10);

        for (int i = 0; i < allocate.capacity(); i++) {
            // one int use four byte
            allocate.putInt(i);
        }

        allocate.position(2);
        allocate.limit(5);

        ByteBuffer slice = allocate.slice();

        for (int i = 0; i < slice.capacity(); i++) {
            byte b = slice.get(i);
            b*=2;
            slice.putInt(i,b);
        }

        allocate.position(0);
        allocate.limit(10);

        for (int i = 0; i < allocate.capacity(); i++) {
            System.out.println(allocate.get());
        }
    }
}
