package com.pei.proxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

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
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                System.out.println("befor " + method.getName());
                Object res = methodProxy.invokeSuper(o, objects);
                System.out.println("after" + method.getName());
                return null;
            }
        });
        Pei proxy = (Pei) enhancer.create();
        proxy.eat();
        proxy.sleep();
        proxy.doPlay();
    }
}
