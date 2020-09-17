package com.pei.leetcode;


import java.lang.reflect.Field;

public
class Solution {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, InterruptedException {

        ThreadLocal<Integer> local = new ThreadLocal<>();
        local.set(100);
//        local = null;
        System.gc();
        Thread t = Thread.currentThread();
        Class<? extends Thread> clz = t.getClass();
        Field field = clz.getDeclaredField("threadLocals");
        field.setAccessible(true);
        Object ThreadLocalMap = field.get(t);
        Class<?> tlmClass = ThreadLocalMap.getClass();
        Field tableField = tlmClass.getDeclaredField("table");
        tableField.setAccessible(true);
        Object[] arr = (Object[]) tableField.get(ThreadLocalMap);
        for (Object o : arr) {
            if (o != null) {
                Class<?> entryClass = o.getClass();
                Field valueField = entryClass.getDeclaredField("value");
                Field referenceField = entryClass.getSuperclass().getSuperclass().getDeclaredField("referent");
                valueField.setAccessible(true);
                referenceField.setAccessible(true);
                System.out.printf("弱引用key: %s ,值: %s\t%n", referenceField.get(o), valueField.get(o));
            }
        }
    }
}
