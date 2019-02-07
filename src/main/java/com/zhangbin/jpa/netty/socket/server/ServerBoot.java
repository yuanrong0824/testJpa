package com.zhangbin.jpa.netty.socket.server;


public class ServerBoot {

    private static final int PORT=8000;
    public static void main(String[] args) {
        //开始启动服务端
        Server server=new Server(PORT);
        //start
        server.start();
    }
}
