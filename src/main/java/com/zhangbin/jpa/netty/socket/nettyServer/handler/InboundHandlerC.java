package com.zhangbin.jpa.netty.socket.nettyServer.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class InboundHandlerC extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("inboundHandlerC: " + msg);
        ctx.fireChannelRead(msg);
    }
}

