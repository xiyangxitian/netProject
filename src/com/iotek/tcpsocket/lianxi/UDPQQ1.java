package com.iotek.tcpsocket.lianxi;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.util.Scanner;

public class UDPQQ1 {
    public static void main(String[] args) throws IOException {
        DatagramSocket ds = new DatagramSocket();
        String content;
        SocketAddress socketAddress = new InetSocketAddress("localhost", 8888);
        DatagramPacket packet;
        DatagramPacket packet1;
        Scanner scanner = new Scanner(System.in);
        byte[] buf = new byte[100];
        while (true) {
            System.out.println("qq1请输入要发送的信息：");
            content = scanner.next();
            packet = new DatagramPacket(content.getBytes(), content.length(), socketAddress);
            packet1 = new DatagramPacket(buf, buf.length);
            ds.send(packet);
            ds.receive(packet1);
            byte[] data = packet1.getData();
            String receiveData = new String(data, 0, packet1.getLength());
            System.out.println("qq1收到消息：" + receiveData);
            if (content.equalsIgnoreCase("over") || receiveData.equalsIgnoreCase("over")) {
                System.out.println("聊天结束！");
                break;
            }
        }
        scanner.close();
        ds.close();
    }
}
