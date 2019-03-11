package com.iotek.tcpsocket.lianxi;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 接受一张图片并且保存
 */
public class TCP_MY_Server {
    public static void main(String[] args) {
        ServerSocket serverSocket;
        Socket socket;
        OutputStream os;
        InputStream is;
        FileOutputStream fos;
        try {
            //1.创建一个ServerSocket对象
            serverSocket = new ServerSocket(8888);
            //2.调用accept()方法来接受客户端的请求
            socket = serverSocket.accept();
            System.out.println(socket.getInetAddress().getHostAddress() + "has connected");
            is = socket.getInputStream();
            fos = new FileOutputStream("E:/io/image/new1.jpg");
            byte[] buf = new byte[10];
            int len;
            while ((len = is.read(buf)) != -1) {
                fos.write(buf, 0, len);
            }
            fos.close();
            is.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
