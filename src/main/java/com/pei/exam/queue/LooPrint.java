package com.pei.exam.queue;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class LooPrint {

    public static void main(String[] args) throws InterruptedException {
        ReentrantLock lock = new ReentrantLock();
        Condition conditionA = lock.newCondition();
        Condition conditionB = lock.newCondition();
        Condition conditionC = lock.newCondition();
        new Thread(() -> new PrintThread(lock, conditionA, conditionB, "A", 10).print()).start();
        new Thread(() -> new PrintThread(lock, conditionB, conditionC, "B", 10).print()).start();
        new Thread(() -> new PrintThread(lock, conditionC, conditionA, "C", 10).print()).start();
        // 休眠保证唤醒首个打印线程
        Thread.sleep(1000);
        lock.lock();
        try {
            // 唤醒首个打印线程
            conditionA.signal();
        } finally {
            lock.unlock();
        }
        //等待打印完毕
        Thread.sleep(10000);
    }
}

class PrintThread {

    private final ReentrantLock lock;
    private final Condition cur;
    private final Condition next;
    private final String str;
    private final int num;

    public PrintThread(ReentrantLock lock, Condition cur, Condition next, String str, int num) {
        this.lock = lock;
        this.cur = cur;
        this.next = next;
        this.str = str;
        this.num = num;
    }

    public void print() {
        lock.lock();
        try {
            for (int i = 0; i < num; i++) {
                // 阻塞当前线程
                cur.await();
                System.out.println(str);
                // 唤醒下一个打印线程
                next.signal();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
