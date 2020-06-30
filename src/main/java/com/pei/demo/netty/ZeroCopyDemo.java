package com.pei.demo.netty;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.DefaultFileRegion;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.ssl.SslHandler;
import io.netty.handler.stream.ChunkedFile;

import java.io.RandomAccessFile;

/**
 * @program: LearnJdkCode
 * @description: Netty 零拷贝案例
 * @author: Peilisher
 * @create: 2020-06-29 10:38
 **/
public class ZeroCopyDemo extends SimpleChannelInboundHandler<String> {


    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, String s) throws Exception {
        RandomAccessFile randomAccessFile = null;
        long length = -1;

        try {
            randomAccessFile = new RandomAccessFile(s, "r");
            length = randomAccessFile.length();
        } catch (Exception e) {
            channelHandlerContext.write("ERR:" + e.getMessage());
            return;
        } finally {
            if (length < 0 && randomAccessFile != null) {
                randomAccessFile.close();
            }
        }

        channelHandlerContext.write("OK," + randomAccessFile.length() + "\n");
        if (channelHandlerContext.pipeline().get(SslHandler.class) == null) {
            channelHandlerContext.write(new DefaultFileRegion(randomAccessFile.getChannel(), 0, length));
        } else {
            channelHandlerContext.write(new ChunkedFile(randomAccessFile));
        }

        channelHandlerContext.writeAndFlush("\n");
    }
}
