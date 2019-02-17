package com.zhangbin.jpa.thread;

public class MyThread implements Runnable {

    @Override
    public void run() {
        System.out.println("开始执行run方法1");
        synchronized (this) {
            System.out.println("开始执行run方法2");
            for (int i = 0; i < 1; i--) {
                System.out.println(Thread.currentThread().getName() + " synchronized loop " + i);
            }
        }
    }

    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        Thread ta = new Thread(t1, "A");
        Thread tb = new Thread(t1, "B");
        ta.start();
        tb.start();
    }

}  