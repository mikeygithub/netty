package com.mikey.thrift;

import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TSocket;

/**
 * @ProjectName netty
 * @Author 麦奇
 * @Email biaogejiushibiao@outlook.com
 * @Date 9/29/19 4:13 PM
 * @Version 1.0
 * @Description:
 **/

public class ThriftClient {
    public static void main(String[] args) {

        TFramedTransport transport = new TFramedTransport(new TSocket("localhost", 8899), 600);

        TCompactProtocol tCompactProtocol = new TCompactProtocol(transport);

        PersonService.Client client = new PersonService.Client(tCompactProtocol);

        try {
            transport.open();
            Person mikey = client.getPersonByUsername("mikey");
            System.out.println(mikey.getUsername());
            System.out.println(mikey.getAge());
            System.out.println(mikey.isMarried());
            client.savePerson(mikey);

        }catch (Exception e){
            throw new RuntimeException(e.getMessage(),e);
        }finally {
            transport.close();
        }
    }
}
