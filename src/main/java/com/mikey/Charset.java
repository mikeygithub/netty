package com.mikey;

import java.io.File;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;

/**
 * @ProjectName netty
 * @Author 麦奇
 * @Email biaogejiushibiao@outlook.com
 * @Date 10/6/19 9:55 AM
 * @Version 1.0
 * @Description:java 的 编解码
 * ASCII (American Standard Code For Information Interchange)美国信息交换标准码
 * 7 bit 来表示一个字符,共计可以表示128种字符
 *
 * ISO-8859-1
 * 8 bit 来表示一个字符,共计可以表示1256种字符
 *
 * gb2312
 * 2 bit 表示一个汉字
 *
 * gbk
 * gb18030
 * big5
 * unicode:2 bit 表示一个字符
 *
 * UTF：Unicode Translation Format
 * unicode是一种编码方式,而UTF则是一种存储方式：UTF-8是Unicode的实现方式之一
 * UTF-16LE(little endian) UTF16-BE (big endian);
 * Zero With No-Break Space ,0xFEFF(BE)大端,0xFEFE(LE)小端
 *
 * UTF-8：变长字节表示形式
 * 一般来说,UTF-8会通过3个字节来表示一个汉字
 * BOM(Byte Order Mark),
 **/

public class Charset {
    public static void main(String[] args) throws Exception {

        String inputFile = "NIO_INPUT.txt";
        String ouputFile = "NIO_OUTPUT.txt";

        RandomAccessFile inputRandomAccessFIle = new RandomAccessFile(inputFile, "r");
        RandomAccessFile outputRandomAccessFile = new RandomAccessFile(ouputFile, "rw");

        long inputLength = new File(inputFile).length();

        FileChannel inputRandomAccessFIleChannel = inputRandomAccessFIle.getChannel();
        FileChannel outputRandomAccessFileChannel = outputRandomAccessFile.getChannel();

        MappedByteBuffer inputData = inputRandomAccessFIleChannel.map(FileChannel.MapMode.READ_ONLY, 0, inputLength);

//        java.nio.charset.Charset charset = java.nio.charset.Charset.forName("utf-8");
        java.nio.charset.Charset charset = java.nio.charset.Charset.forName("iso-8859-1");
//        java.nio.charset.Charset charset = java.nio.charset.Charset.forName("GBK");
        //编码解码器
        CharsetDecoder charsetDecoder = charset.newDecoder();//解码器：将字节转成字符串
        CharsetEncoder charsetEncoder = charset.newEncoder();//编码器：将字符串转成字节

        CharBuffer charBuffer = charsetDecoder.decode(inputData);
        System.out.println(charBuffer.get(9));
        ByteBuffer outputData = charsetEncoder.encode(charBuffer);

//        ByteBuffer outputData = java.nio.charset.Charset.forName("utf-8").encode(charBuffer);

        outputRandomAccessFileChannel.write(outputData);
        inputRandomAccessFIleChannel.close();
        outputRandomAccessFileChannel.close();

//        System.out.println("=========Charset===========");
//        java.nio.charset.Charset.availableCharsets().forEach((k, v) -> {
//            System.out.println("k=" + k + "," + "v=" + v);
//        });
//        System.out.println("=========Charset===========");
    }
}
