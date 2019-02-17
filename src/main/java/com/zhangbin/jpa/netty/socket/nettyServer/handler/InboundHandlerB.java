package com.zhangbin.jpa.netty.socket.nettyServer.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class InboundHandlerB extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
//        System.out.println("inboundHandlerB:" + msg);
//        ctx.fireChannelRead(msg);

//        channelRead方法的特殊处理 用来调试异常的触发链

    }

//    @Override
//    public void channelActive(ChannelHandlerContext ctx) throws Exception {
//        ctx.channel().pipeline().fireChannelRead("hello word");
//    }


    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        System.out.println("InboundHandlerB.exectionCaught()");
        ctx.fireExceptionCaught(cause);
    }
}
