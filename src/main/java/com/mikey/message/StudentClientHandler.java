//package com.mikey.message;
//
//import com.mikey.message.DataInfo;
//import nio.netty.channel.ChannelHandlerContext;
//import nio.netty.channel.SimpleChannelInboundHandler;
//
//import java.util.Random;
//
///**
// * @ProjectName netty
// * @Author 麦奇
// * @Email biaogejiushibiao@outlook.com
// * @Date 9/28/19 10:55 PM
// * @Version 1.0
// * @Description:
// **/
//
//public class StudentClientHandler extends SimpleChannelInboundHandler<DataInfo.Messages> {
//
//    @Override
//    protected void channelRead0(ChannelHandlerContext ctx, DataInfo.Messages msg) throws Exception {
//
//    }
//
//    @Override
//    public void channelActive(ChannelHandlerContext ctx) throws Exception {
//
//        int nextInt = new Random().nextInt(3);
//        DataInfo.Messages.Builder builder;
//
//        if (nextInt == 0){
//            builder = DataInfo.Messages.newBuilder().setDataType(DataInfo.Messages.DataType.PersonType).setPerson(
//                    DataInfo.Person.newBuilder().setName("麦奇").setAge(20).setAddress("广西柳州").build());
//        }else if (nextInt ==1){
//            builder = DataInfo.Messages.newBuilder().setDataType(DataInfo.Messages.DataType.DogType).setDog(
//                    DataInfo.Dog.newBuilder().setName("阿拉斯加").setAge(5).build());
//        }else{
//            builder = DataInfo.Messages.newBuilder().setDataType(DataInfo.Messages.DataType.CatType).setCat(
//                    DataInfo.Cat.newBuilder().setName("加菲猫").setCity("纽约").build());
//        }
//
//        ctx.channel().writeAndFlush(builder);
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
