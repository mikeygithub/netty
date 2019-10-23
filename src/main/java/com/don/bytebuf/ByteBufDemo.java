package com.don.bytebuf;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

/**
 * @ProjectName netty
 * @Author 麦奇
 * @Email biaogejiushibiao@outlook.com
 * @Date 10/23/19 9:09 AM
 * @Version 1.0
 * @Description:
 *
 * TODO:  Direct Buffer (直接缓冲区)
 * 在堆外直接分配内存空间,直接缓冲区并不会占用堆内存的容量空间,因为它是由操作系统在本地内存进行的数据分配.
 *
 * TODO: 优点：
 * 在使用Socket进行数据传输时,性能非常好,因为数据直接位于操作系统的本地内存中,所以不需要从JVM将数据复制到直接缓冲区中,性能好.
 * TODO: 缺点：
 * 因为Direct Buffer是直接在操作系统内存中的,所以内存空间的分配与释放要比堆空间更加复杂,而且速度要慢一些.
 *
 * Netty 通过提供内存池来解决这个问题,直接缓冲区并不支持通过字节数组的方式来访问数据.
 * 重点：对于后端的业务消息的编码来说,推荐使用HeapByteBuf;对于I/O通信线程在读写缓冲区时,推荐使用DirectByteBuf
 *
 **/

public class ByteBufDemo {
    public static void main(String[] args) {

        ByteBuf buffer = Unpooled.buffer(10);

        for (int i = 0; i < 10; i++) {
            buffer.writeByte(i);
        }

//        for (int i = 0; i < 10; i++) {
//            System.out.println(buffer.getByte(i));
//        }

        for (int i = 0; i < 10; i++) {
            System.out.println(buffer.readByte());
        }
    }
}
