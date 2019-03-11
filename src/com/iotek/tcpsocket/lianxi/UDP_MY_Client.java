package com.iotek.tcpsocket.lianxi;

import com.iotek.tcpsocket.util.UDPUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDP_MY_Client {

    public static void main(String[] args) {
        byte[] buf = new byte[10];
        DatagramSocket socket;
        DatagramPacket packet;
        try {
            socket = new DatagramSocket();
            packet = new DatagramPacket(buf, buf.length, InetAddress.getByName("localhost"), UDPUtils.PORT);
            FileInputStream fis = new FileInputStream("E:/io/1.jpg");
            int len;
            while ((len = fis.read(buf)) != -1) {
                System.out.println("c -len:" + len);
                packet.setData(buf, 0, len);
                socket.send(packet);
            }
            socket.send(new DatagramPacket("over".getBytes(), "over".length(),InetAddress.getByName("localhost"),UDPUtils.PORT));
            System.out.println("client out");
            socket.close();
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
