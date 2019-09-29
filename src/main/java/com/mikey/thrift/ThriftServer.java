package com.mikey.thrift;

import org.apache.thrift.TProcessorFactory;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.server.THsHaServer;
import org.apache.thrift.transport.TFastFramedTransport;
import org.apache.thrift.transport.TNonblockingServerSocket;
import org.apache.thrift.transport.TTransportException;

/**
 * @ProjectName netty
 * @Author 麦奇
 * @Email biaogejiushibiao@outlook.com
 * @Date 9/29/19 4:06 PM
 * @Version 1.0
 * @Description:
 **/

public class ThriftServer {
    public static void main(String[] args) throws TTransportException {

        TNonblockingServerSocket socket = new TNonblockingServerSocket(8899);
        //连接设置
        THsHaServer.Args args1 = new THsHaServer.Args(socket).minWorkerThreads(2).maxWorkerThreads(4);
        //处理器
        PersonService.Processor<PersonServiceImpl> personServiceProcessor = new PersonService.Processor<>(new PersonServiceImpl());
        //协议工厂
        args1.protocolFactory(new TCompactProtocol.Factory());
        args1.transportFactory(new TFastFramedTransport.Factory());
        args1.processorFactory(new TProcessorFactory(personServiceProcessor));
        //服务
        THsHaServer tHsHaServer = new THsHaServer(args1);
        //启动：异步非阻塞（死循环）
        tHsHaServer.serve();
    }
}
