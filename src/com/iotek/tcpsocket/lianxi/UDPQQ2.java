package com.iotek.tcpsocket.lianxi;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.util.Scanner;

public class UDPQQ2 {
    public static void main(String[] args) throws IOException {
        DatagramSocket ds = new DatagramSocket(8888);
        String content;
        DatagramPacket receivePacket;
        DatagramPacket sendPacket;
        Scanner scanner = new Scanner(System.in);
        byte[] buf = new byte[100];
        while (true) {
            receivePacket = new DatagramPacket(buf, buf.length);
            ds.receive(receivePacket);
            String receiveData = new String(receivePacket.getData(), 0, receivePacket.getLength());
            System.out.println("qq2收到qq1消息：" + receiveData);
            System.out.println("qq2请输入要发送的信息:");
            content = scanner.next();
            sendPacket = new DatagramPacket(content.getBytes(), content.length(),receivePacket.getAddress(),receivePacket.getPort());
            ds.send(sendPacket);
            if (content.equalsIgnoreCase("over") || receiveData.equalsIgnoreCase("over")) {
                System.out.println("聊天结束！");
                break;
            }
        }
        scanner.close();
        ds.close();
    }
}
