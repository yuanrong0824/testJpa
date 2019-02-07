package com.zhangbin.jpa.netty.socket.nettyServer;

import com.zhangbin.jpa.netty.handle.ServerHandler;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.util.AttributeKey;

public class NettyServer {

    public static void main(String[] args) {
        EventLoopGroup bossLoopGroup = new NioEventLoopGroup(1);
        EventLoopGroup workerLoopGroup = new NioEventLoopGroup();

        ServerBootstrap serverBootstrap = new ServerBootstrap();
        serverBootstrap.group(bossLoopGroup,workerLoopGroup).channel(NioServerSocketChannel.class)
                .childOption(ChannelOption.TCP_NODELAY,true).childAttr(AttributeKey.newInstance("childAttr"),"childAttrValue")
                .handler(new ServerHandler()).childHandler(new ChannelInitializer<SocketChannel>(){
            @Override
            protected void initChannel(SocketChannel ch) {
//                ch.pipeline().addLast();
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
