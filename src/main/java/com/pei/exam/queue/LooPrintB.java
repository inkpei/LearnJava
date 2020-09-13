package com.pei.exam.queue;

public class LooPrintB {

    public static void main(String[] args) throws InterruptedException {
        String lock = "lock";
        new Thread(() -> new Print(lock, 10, "A").print()).start();
        Thread.sleep(50);
        new Thread(() -> new Print(lock, 10, "B").print()).start();
        Thread.sleep(50);
        new Thread(() -> new Print(lock, 10, "C").print()).start();
    }


}

class Print {
    final String lock;
    int num;
    String str;

    public Print(String lock, int num, String str) {
        this.lock = lock;
        this.num = num;
        this.str = str;
    }

    public void print() {
        for (int i = 0; i < num; i++) {
            synchronized (lock) {
                System.out.println(str);
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
