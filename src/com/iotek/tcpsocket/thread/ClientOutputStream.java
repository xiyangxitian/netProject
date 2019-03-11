package com.iotek.tcpsocket.thread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * 发信息给服务端
 */
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
            pw = new PrintWriter(socket.getOutputStream(), true);
            br = new BufferedReader(new InputStreamReader(System.in));
            while (true) {
//                System.out.println("你要发送的内容：");
//                -Dfile.encoding=GB18030
                String line = br.readLine();
                pw.println(line);
                if (line.equalsIgnoreCase("bye")) {
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
                pw.close();
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
