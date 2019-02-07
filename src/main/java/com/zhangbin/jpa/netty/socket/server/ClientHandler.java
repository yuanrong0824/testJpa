package com.zhangbin.jpa.netty.socket.server;


import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

@Slf4j
public class ClientHandler {
    public static final int MAX_DATA_LEN = 1024;
    private final Socket socket;

    public ClientHandler(Socket socket) {
        this.socket = socket;
    }

    public void start() {
        log.info("新客户端连接成功");
        new Thread(new Runnable() {
            @Override
            public void run() {
                doStart();
            }
        }).start();
    }

    private void doStart() {
        //最终客户端的读写过程,客户端读写的过程会阻塞serverSocket.accept的while(true)方法
        try {
            InputStream inputStream = socket.getInputStream();
            while (true) {
                byte[] data = new byte[MAX_DATA_LEN];
                int len;
                while ((len = inputStream.read(data)) != -1) {
                    String message = new String(data, 0, len);
                    System.out.println("客户端传来消息:" + message);
                    socket.getOutputStream().write(data);
                    System.out.println("回写客户端传来消息:" + message);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
