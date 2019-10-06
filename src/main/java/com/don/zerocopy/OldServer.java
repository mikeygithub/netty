package com.don.zerocopy;

import java.io.DataInputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @ProjectName netty
 * @Author 麦奇
 * @Email biaogejiushibiao@outlook.com
 * @Date 10/6/19 4:33 PM
 * @Version 1.0
 * @Description:
 **/

public class OldServer {
    public static void main(String[] args) throws Exception{

        ServerSocket serverSocket = new ServerSocket(8999);

        while (true){
            Socket socket = serverSocket.accept();
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());

            try {
                byte[] bytes = new byte[4096];

                while (true) {
                    int readCount = dataInputStream.read(bytes,0,bytes.length);
                }

            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
