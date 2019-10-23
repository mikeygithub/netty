package com.don.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

/**
 * @ProjectName netty
 * @Author 麦奇
 * @Email biaogejiushibiao@outlook.com
 * @Date 10/22/19 10:33 PM
 * @Version 1.0
 * @Description:
 **/
@Component
public class Demo {
    @Logger
    public void demoMethod(String name){
        System.out.println("Name = "+name);
    }

    public void director(){
        demoMethod("Test Demo");
    }

    public static void main(String[] args) {
        ApplicationContext applicationContext= new ClassPathXmlApplicationContext("classpath:applicationContent.xml");
        Demo demo = (Demo) applicationContext.getBean("demo");
        demo.demoMethod("Test Demo");
    }
}
