package com.mikey.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.*;

/**
 * @ProjectName netty
 * @Author 麦奇
 * @Email biaogejiushibiao@outlook.com
 * @Date 10/5/19 10:32 AM
 * @Version 1.0
 * @Description: error
 **/

public class NioServer {

    private static Map<String,SocketChannel> clientMap = new HashMap<>();

    public static void main(String[] args) throws Exception {

        ServerSocketChannel socketChannel = ServerSocketChannel.open();
        //非阻塞
        socketChannel.configureBlocking(false);
        ServerSocket serverSocket = socketChannel.socket();
        serverSocket.bind(new InetSocketAddress(8899));


        Selector selector = Selector.open();
        socketChannel.register(selector, SelectionKey.OP_ACCEPT);

        while (true) {
            selector.select();
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            selectionKeys.forEach(selectionKey -> {
                final SocketChannel client;
                try {
                    if (selectionKey.isAcceptable()) {
                        //表示客户端向服务端发起一个连接
                        ServerSocketChannel server = (ServerSocketChannel) selectionKey.channel();
                        client = server.accept();
                        client.configureBlocking(false);
                        client.register(selector, SelectionKey.OP_READ);
                        String key = "["+ UUID.randomUUID().toString()+"]";
                        clientMap.put(key,client);
                    } else if (selectionKey.isReadable()){
                        client = (SocketChannel)selectionKey.channel();
                        ByteBuffer buffer = ByteBuffer.allocate(1024);
                        int count = client.read(buffer);

                        if (count > 0){
                            buffer.flip();
                            Charset charset = Charset.forName("utf-8");
                            String receivedMessage = String.valueOf(charset.decode(buffer).array());
                            System.out.println("接收客户端"+"信息："+receivedMessage);

                            String senderKey = null;

                            for (Map.Entry<String,SocketChannel> entry: clientMap.entrySet()){
                                if (client == entry.getValue()){
                                    senderKey = entry.getKey();
                                    break;
                                }
                            }
                            for (Map.Entry<String,SocketChannel> entry: clientMap.entrySet()) {
                                SocketChannel value = entry.getValue();
                                ByteBuffer writerBuffer = ByteBuffer.allocate(1024);
                                writerBuffer.put((senderKey+":"+receivedMessage).getBytes());
                                writerBuffer.flip();
                                value.write(buffer);
                            }
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
            selectionKeys.clear();
        }

    }
}
