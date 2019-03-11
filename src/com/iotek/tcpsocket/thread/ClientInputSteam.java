package com.iotek.tcpsocket.thread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.SocketException;

public class ClientInputSteam implements Runnable {
    private Socket socket;

    public ClientInputSteam(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {

        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        while (true) {
            try {
                String line = br.readLine();
                System.out.println("服务端返回的数据:" + line);
            } catch (SocketException e) {
                break;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
//            System.out.println("br closed");
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
