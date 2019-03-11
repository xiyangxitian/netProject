package com.iotek.tcpsocket.lianxi;

import com.iotek.tcpsocket.util.UDPUtils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * 接受一张图片并且保存
 */
public class UDP_MY_Server {

    public static void main(String[] args) {
        byte[] buf = new byte[UDPUtils.BUFFER_SIZE];
        DatagramPacket packet;
        DatagramSocket socket;
        FileOutputStream fos;
        try {
            socket = new DatagramSocket(UDPUtils.PORT);
            packet = new DatagramPacket(buf, UDPUtils.BUFFER_SIZE);
            fos = new FileOutputStream("E:/io/jpg/7.jpg");
            System.out.println("server' start");
            while (true) {
                socket.receive(packet);
                System.out.println("server's length:" + packet.getLength());
                if (new String(packet.getData(), 0, packet.getLength()).equalsIgnoreCase("over")) {
                    break;
                }
                fos.write(buf, 0, packet.getLength());
                fos.flush();
            }
            System.out.println("server out");
            socket.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
