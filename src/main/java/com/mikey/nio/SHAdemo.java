package com.mikey.nio;

import org.apache.shiro.crypto.hash.Sha256Hash;

/**
 * @ProjectName netty
 * @Author 麦奇
 * @Email biaogejiushibiao@outlook.com
 * @Date 10/6/19 9:05 AM
 * @Version 1.0
 * @Description:
 **/

public class SHAdemo {
    public static void main(String[] args) {

        String pwd = new Sha256Hash("111111", "OUPptS8rzkDafcHYaUCa").toHex();
        System.out.println(pwd);
        System.out.println("7de738601738142491513d5eaad4b9b2c19e15e0b8cb08c37b841cdef343cfd9");

    }
}
