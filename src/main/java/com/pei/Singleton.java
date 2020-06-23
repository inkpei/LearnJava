package com.pei;

/**
 * @Project: LearnJdkCode
 * @Author: Pei
 * @Description: TODO
 * @Data: 2020/4/12
 */

// 1.饿汉式
public class Singleton {
    private Singleton (){}
    private static final Singleton instance = new Singleton();
    public static Singleton getInstance(){
        return instance;
    }
}

//// 2.懒汉式
//
//public class Singleton{
//    private Singleton(){}
//    private static Singleton instance;
//    public static Singleton getInstance(){
//        if (instance == null) {
//            instance = new Singleton();
//        }
//        return instance;
//    }
//}
//
//// 3.懒汉式 线程安全
//
//public class Singleton{
//    private Singleton(){}
//    private static Singleton instance;
//    public static synchronized Singleton getInstance(){
//       if (instance == null){
//           instance = new Singleton();
//       }
//        return instance;
//    }
//}
//
//// 4.懒汉式 double check
//public class Singleton{
//    private Singleton(){}
//    private static volatile Singleton instance;
//    public static Singleton getInstance(){
//        if (instance == null){
//            synchronized (Singleton.class){
//                if (instance == null){
//                    instance = new Singleton();
//                }
//            }
//        }
//        return instance;
//    }
//}
//
//// 5. 内部类
//public class Singleton(){
//    private Singleton(){}
//    private static class SingletonHolder{
//        public static Singleton instance = new Singleton();
//    }
//    public static Singleton getInstance(){
//        return SingletonHolder.instance;
//    }
//}
//
//// 6.单例
//
//public enum Singleton{
//    INSTANCE;
//}
