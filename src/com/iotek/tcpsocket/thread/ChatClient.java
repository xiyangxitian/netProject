package com.iotek.tcpsocket.thread;

import java.io.IOException;
import java.net.Socket;

public class ChatClient {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 8888);
        new Thread(new ClientOutputStream(socket)).start();
        new Thread(new ClientInputSteam(socket)).start();

        Socket socket1 = new Socket("127.0.0.1", 8888);
        new Thread(new ClientOutputStream(socket1)).start();
        new Thread(new ClientInputSteam(socket1)).start();




    }

}
