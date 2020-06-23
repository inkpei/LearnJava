package com.pei.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Project: LearnJdkCode
 * @Author: Pei
 * @Description: TODO
 * @Data: 2020/4/12
 */
public class PeiInvocationHandle implements InvocationHandler {
    private Object target;
    public PeiInvocationHandle(Object target){
        this.target = target;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before " + method.getName() );
        Object res = method.invoke(target, args);
        System.out.println("after " + method.getName());
        return res;
    }

    public static void main(String[] args) {
        Person pei =(Person) Proxy.newProxyInstance(Pei.class.getClassLoader(), Pei.class.getInterfaces(), new PeiInvocationHandle(new Pei()));
        pei.eat();
        pei.sleep();
    }
}
