package com.zhangbin.jpa.netty.socket.nettyServer;

import com.zhangbin.jpa.netty.handle.ServerHandler;
import com.zhangbin.jpa.netty.socket.nettyServer.handler.*;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.util.AttributeKey;

public class NettyServer {

    public static void main(String[] args) {
//        服务端接受客户端链接的线程 对应的是io编程中server的new thread()线程
        EventLoopGroup bossLoopGroup = new NioEventLoopGroup(1);
//        每个连接的读写线程 对应的是client中的new thread线程
        EventLoopGroup workerLoopGroup = new NioEventLoopGroup();
//      引导类 什么也不做
        ServerBootstrap serverBootstrap = new ServerBootstrap();
        serverBootstrap.group(bossLoopGroup,workerLoopGroup)
//                设置服务端的socketchannel
                .channel(NioServerSocketChannel.class)
//                给后面指定的每一条客户端连接设置tcp的基本属性 TCP_NODELAY
//               禁用 nagle算法 可以传输小数据
                .childOption(ChannelOption.TCP_NODELAY,true)
//               每次创建客户端连接的时候 可以绑定一些基本的属性
                .childAttr(AttributeKey.newInstance("childAttr"),"childAttrValue")
//                对应在服务端启动过程中 有什么样的逻辑
                .handler(new ServerHandler())
//               一般都会配置一大长串的handle 新连接数据流读写的一些逻辑 在client中对应的数据读写
                .childHandler(new ChannelInitializer<SocketChannel>(){
                    @Override
                    protected void initChannel(SocketChannel ch) {
                        ch.pipeline().addLast(new InboundHandlerA())
                        .addLast(new InboundHandlerB())
                        .addLast(new InboundHandlerC())
                        .addLast(new OutBoundHandlerA())
                        .addLast(new OutBoundHandlerB())
                        .addLast(new OutBoundHandlerC());
                    }
                });
        try {
            ChannelFuture bind = serverBootstrap.bind(8888).sync();
            bind.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            bossLoopGroup.shutdownGracefully();
            workerLoopGroup.shutdownGracefully();
        }
    }
}
