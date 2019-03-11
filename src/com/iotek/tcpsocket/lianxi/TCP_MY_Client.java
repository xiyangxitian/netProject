package com.iotek.tcpsocket.lianxi;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * 传送一张图片
 */
public class TCP_MY_Client {
    public static void main(String[] args) {
        //把键盘标准字节流转换成字符流
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        //获取服务端的数据
        Socket socket;
        FileInputStream fis;
        OutputStream os;
        try {
            socket = new Socket("127.0.0.1", 8888);
            fis = new FileInputStream("E:/io/1.jpg");
            os = socket.getOutputStream();
            byte[] buf = new byte[10];
            int len;
            while ((len = fis.read(buf)) != -1) {
                os.write(buf, 0, len);
            }
            os.close();
            fis.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
