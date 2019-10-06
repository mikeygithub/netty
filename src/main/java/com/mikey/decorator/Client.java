package com.mikey.decorator;

/**
 * @ProjectName netty
 * @Author 麦奇
 * @Email biaogejiushibiao@outlook.com
 * @Date 10/4/19 10:46 AM
 * @Version 1.0
 * @Description:
 **/

public class Client {

    public static void main(String[] args) {

        Component concreteDecorator1 = new ConcreteDecorator1(new ConcreteComponent());
        concreteDecorator1.doSomething();
        Component concreteDecorator2 = new ConcreteDecorator2(new ConcreteComponent());
        concreteDecorator2.doSomething();
    }
}
