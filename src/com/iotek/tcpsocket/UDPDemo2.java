package com.iotek.tcpsocket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPDemo2 {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket(8000);

        byte[] buff = new byte[100];
        DatagramPacket packet = new DatagramPacket(buff, 100);
        socket.receive(packet);
        System.out.println(new String(new String(buff, 0, packet.getLength())));


        //回复消息给demo1
        String str = "Me too";
//        System.out.println(packet.getAddress()+" demo1's port: "+ packet.getPort());
        DatagramPacket packet1 = new DatagramPacket(str.getBytes(), str.length(), packet.getAddress(), packet.getPort());
        socket.send(packet1);
        socket.close();

    }
}
