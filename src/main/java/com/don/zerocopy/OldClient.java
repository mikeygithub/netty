package com.don.zerocopy;

import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.net.Socket;

/**
 * @ProjectName netty
 * @Author 麦奇
 * @Email biaogejiushibiao@outlook.com
 * @Date 10/15/19 11:01 PM
 * @Version 1.0
 * @Description:
 **/

public class OldClient {
    public static void main(String[] args) throws Exception{

        Socket socket = new Socket("localhost", 8899);
        String fileName = "/home/mikey/下载/thrift-0.12.0.tar.gz";
        FileInputStream inputStream = new FileInputStream(fileName);

        DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

        byte[] bytes = new byte[4096];
        long readCount;
        long total = 0;
        long startTime = System.currentTimeMillis();
        while ((readCount = inputStream.read(bytes))>=0){
            total+= readCount;
            dataOutputStream.write(bytes);
        }
        System.out.println("发送字节数目："+total+",耗时："+(System.currentTimeMillis()-startTime));

        dataOutputStream.close();
        socket.close();
        inputStream.close();
    }
}
