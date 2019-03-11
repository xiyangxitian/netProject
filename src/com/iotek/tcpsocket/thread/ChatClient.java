package com.iotek.tcpsocket.thread;

import java.io.IOException;
import java.net.Socket;

public class ChatClient {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 8888);
        new Thread(new ClientOutputStream(socket)).start();


    }

}
