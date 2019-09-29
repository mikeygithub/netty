package com.mikey.protocolbuffers.student;

import com.google.protobuf.InvalidProtocolBufferException;
import student.DataInfo;

/**
 * @ProjectName netty
 * @Author 麦奇
 * @Email biaogejiushibiao@outlook.com
 * @Date 9/28/19 10:26 PM
 * @Version 1.0
 * @Description:
 **/

public class MainDemo {
    public static void main(String[] args) throws InvalidProtocolBufferException {
        DataInfo.Student student = DataInfo.Student.newBuilder()
                .setName("麦奇")
                .setAge(10)
                .setAddress("广西柳州")
                .build();
        System.out.println(student);

        byte[] bytes = student.toByteArray();

        DataInfo.Student student1 = DataInfo.Student.parseFrom(bytes);

        System.out.println(student1);

        System.out.println(student == student1);

        System.out.println(student.equals(student1));
    }
}
