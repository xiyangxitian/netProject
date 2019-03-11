package com.iotek.tcpsocket.thread;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ClientOutputStream implements Runnable {

    private Socket socket;

    public ClientOutputStream(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        PrintWriter pw = null;
        BufferedReader br = null;
        try {
            OutputStream os = socket.getOutputStream();
            pw = new PrintWriter(os, true);
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.println("你要发送的内容：");
                String sendMsg = scanner.next();
                pw.println(sendMsg.getBytes());
                if (sendMsg.equalsIgnoreCase("bye")) {
                    System.out.println("Bye");
                    break;
                }
//                -Dfile.encoding=GB18030
                String s = br.readLine();
                String result = new String(s.getBytes(),"GB18030");
                System.out.println("服务器返回的结果：" + result);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("finally");
            try {
                br.close();
                pw.close();
            } catch (IOException e) {
            }
        }
    }
}
