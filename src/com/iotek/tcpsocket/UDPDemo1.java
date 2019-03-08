package com.iotek.tcpsocket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * 基于UDP的编程  和TCP不同 没有用到IO。
 */
public class UDPDemo1 {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket();//随机生成端口
        String str = "I like you";
        //将数据进行封装  封装到数据包中
        DatagramPacket packet = new DatagramPacket(str.getBytes(), str.length(), InetAddress.getByName("localhost"), 8000);
        socket.send(packet);//把数据包发送出去

        byte[] buff = new byte[100];
        DatagramPacket packet1 = new DatagramPacket(buff, 100);
        socket.receive(packet1);
        System.out.println(new String(buff,0,packet1.getLength()));
        socket.close();
    }
}
