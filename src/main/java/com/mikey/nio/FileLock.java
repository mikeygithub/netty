package com.mikey.nio;

import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

/**
 * @ProjectName netty
 * @Author 麦奇
 * @Email biaogejiushibiao@outlook.com
 * @Date 10/5/19 8:33 AM
 * @Version 1.0
 * @Description:
 **/

public class FileLock {
    public static void main(String[] args) throws Exception{

        RandomAccessFile randomAccessFile = new RandomAccessFile("NIO.txt", "rw");

        FileChannel channel = randomAccessFile.getChannel();

        java.nio.channels.FileLock lock = channel.lock(3,6,true);

        System.out.println("valid:"+lock.isValid());
        System.out.println("lock type:"+lock.isShared());

        lock.release();

        channel.close();

    }
}
