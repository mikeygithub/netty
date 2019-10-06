//package com.mikey.message;
//
//import nio.netty.channel.ChannelHandlerContext;
//import nio.netty.channel.SimpleChannelInboundHandler;
//
///**
// * @ProjectName netty
// * @Author 麦奇
// * @Email biaogejiushibiao@outlook.com
// * @Date 9/28/19 10:47 PM
// * @Version 1.0
// * @Description:
// **/
//
//public class StudnetServerHandler extends SimpleChannelInboundHandler<DataInfo.Messages> {
//    @Override
//    protected void channelRead0(ChannelHandlerContext ctx, DataInfo.Messages msg) throws Exception {
//        DataInfo.Messages.DataType dataType = msg.getDataType();
//
//        if (dataType == DataInfo.Messages.DataType.PersonType) {
//            DataInfo.Person person = msg.getPerson();
//            System.out.println("==>>Person");
//            System.out.println(person.getName());
//            System.out.println(person.getAge());
//            System.out.println(person.getAddress());
//        }else if (dataType == DataInfo.Messages.DataType.DogType){
//            DataInfo.Dog dog = msg.getDog();
//            System.out.println("==>>Dog");
//            System.out.println(dog.getName());
//            System.out.println(dog.getName());
//        }else {
//            DataInfo.Cat cat = msg.getCat();
//            System.out.println("==>>Cat");
//            System.out.println(cat.getName());
//            System.out.println(cat.getCity());
//        }
//    }
//
//    @Override
//    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
//
//        cause.printStackTrace();
//
//        ctx.close();
//    }
//}
