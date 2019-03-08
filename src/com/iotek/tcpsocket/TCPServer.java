package com.iotek.tcpsocket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
/**
 * 基于TCP的Socket编程
 */
public class TCPServer {

    public static void main(String[] args) throws IOException {
        //1.创建一个ServerSocket对象
        ServerSocket serverSocket = new ServerSocket(8888);
        //2.调用accept()方法来接受客户端的请求
        Socket socket = serverSocket.accept();
        System.out.println(socket.getInetAddress().getHostAddress() + "has connected");
        //3.获取socket对象的输入输出流                 字符流
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        //
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);
        String line = null;
        //读取客户端传送过来的数据
        while ((line = br.readLine()) != null) {
            if(line.equalsIgnoreCase("over")){
                break;
            }
            System.out.println(line);
//            bw.write(line.toUpperCase());//把转换成大写的字符串传送给客户端
//            bw.newLine();
//            bw.flush();
            pw.println(line.toUpperCase());
        }
        //释放资源
        pw.close();
//        bw.close();
        br.close();
        socket.close();
        System.out.println(socket.getInetAddress().getHostAddress() + "has deconnected");
    }

}
