package com.pei.demo.netty;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.DefaultFileRegion;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.ssl.SslHandler;
import io.netty.handler.stream.ChunkedFile;

import java.io.RandomAccessFile;
import java.util.*;
import java.util.stream.Collectors;

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

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        Map<Integer, Long> collect = Arrays.stream(arr).boxed().collect(Collectors.groupingBy(p -> p, Collectors.counting()));
        List<Pair> list = collect.entrySet().stream().map(e -> new Pair(e.getKey(), e.getValue())).filter(e -> e.value >= 2).sorted(Comparator.comparingInt(a -> a.key)).collect(Collectors.toList());
        int res = 0;
        if (list.size() >= 2) {
            res = list.get(list.size() - 1).key * list.get(list.size() - 2).key;
        }
        System.out.println(res);

    }
}

class Pair {
    int key;
    long value;

    public Pair(int key, long value) {
        this.key = key;
        this.value = value;
    }
}
