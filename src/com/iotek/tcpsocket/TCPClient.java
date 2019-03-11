package com.iotek.tcpsocket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * 基于TCP的Socket编程
 */
public class TCPClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 8888);
        //把键盘标准字节流转换成字符流
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);
        //获取服务端的数据
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        while (true) {
            String line = br.readLine();
            pw.println(line);//传给服务端
//            bw.write(line);
//            bw.newLine();//换行，否则读的时候不知道怎么样是一行。
//            bw.flush();
            if (line.equals("over")) {
                break;
            }
            System.out.println("server pass：" + bufferedReader.readLine());
        }
        pw.close();
        bufferedReader.close();
//        bw.close();
        br.close();
        socket.close();
    }

}
