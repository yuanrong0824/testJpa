package com.zhangbin.jpa.netty.socket.nettyServer.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class InboundHandlerA extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("inboundHandlerA: " + msg);
        ctx.fireChannelRead(msg);
    }
}
