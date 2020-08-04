package com.pei.proxy;

/**
 * @Project: LearnJdkCode
 * @Author: Pei
 * @Description: TODO
 * @Data: 2020/4/12
 */
public class Pei implements Person {
    @Override
    public void eat() {
        System.out.println("eat");
    }

    @Override
    public void sleep() {
        System.out.println("sleep");
    }

    @Override
    public int say(int x) {
        return x;
    }

    private void play() {
        System.out.println("play");
    }

    public void doPlay() {
        play();
    }
}
