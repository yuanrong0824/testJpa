package com.liuqing.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class UseServerClient {
    public static void main(String[] args) throws Exception {
        System.out.println("*******这是客户端*********");
        Socket socket = new Socket("127.0.0.1", 8000);
        OutputStream outputStream = socket.getOutputStream();
        for (int i = 0; i < 10; i++) {
            outputStream.write(("你好，我是看看看看" + i).getBytes());
            outputStream.flush();
        }
        outputStream.close();
    }
}
