package com.zhangbin.jpa.netty.socket.server;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

@Slf4j
public class Server {
    private ServerSocket serverSocket;

    public Server(int port) {
        try {
            //构造方法中只是建立一个serverSocket来监听端口号
            this.serverSocket = new ServerSocket(port);
            log.info("服务端启动成功,端口:{}", port);
        } catch (IOException e) {
            log.error("服务端启动失败");
        }
    }

    public void start() {
        /** 为什么要new一个线程 不希望创建server的线程阻塞主线程
          *@Description:
          *@author: liuqing
          *@date: 2019/2/5
         */
        new Thread(new Runnable() {
            @Override
            public void run() {
                //最终接受客户端的连接
                doStart();
            }
        }).start();
    }

    private void doStart(){
        //不断的以阻塞的去接受新用户的连接
        //对应netty中的就是nio event loop：就是nio事件的一个循环。一个是新链接的接入 还有一个是当前存在的数据流上的数据的读写
        //在端口上监听到一个新用户的连接 新用户的连接在java底层实际上是一个socket来处理的
        //在io编程模型中是一个socket在nio编程模型中是一个socketChannel
        //在netty中封装成的是一个自定义的channel 之后一系列的读写都可以在这个连接上操作 其实就是对一个socket的抽象


        while (true){
            try {
                Socket client = serverSocket.accept();
                // 不断的去监听这条连接上是否有数据的读写
                new ClientHandler(client).start();
            } catch (IOException e) {
                e.printStackTrace();
                log.error("服务端启动异常");
            }
        }
    }
}
