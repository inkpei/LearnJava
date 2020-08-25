package com.pei.demo.proxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;

/**
 * @Project: LearnJdkCode
 * @Author: Pei
 * @Description: TODO
 * @Data: 2020/4/12
 */
public class PeiMethodIncepter  {

    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Pei.class);
        enhancer.setCallback((MethodInterceptor) (o, method, objects, methodProxy) -> {
            System.out.println("befor " + method.getName());
            Object res = methodProxy.invokeSuper(o, objects);
            System.out.println("after" + method.getName());
            return res;
        });
        Pei proxy = (Pei) enhancer.create();
        proxy.eat();
        proxy.sleep();
        proxy.doPlay();
    }
}
