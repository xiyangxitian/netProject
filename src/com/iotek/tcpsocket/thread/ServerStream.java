package com.iotek.tcpsocket.thread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerStream implements Runnable {
    private Socket socket;
    private int number;

    public ServerStream(Socket socket, int number) {
        this.socket = socket;
        this.number = number;
    }


    @Override
    public void run() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);
            while (true) {
                String line = br.readLine();
                System.out.println("客户端" + number + "：发来的消息" + line);
                pw.println(line.toUpperCase());
                if (line.equalsIgnoreCase("bye")) {
                    System.out.println("客户端" + number + ":已经断开连接");
                    break;
                }
            }
            br.close();
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
