package com.zhangbin.jpa.interrupt;

import java.util.concurrent.TimeUnit;

public class InterruptTest {
    //这里用来打印消耗的时间
    private static long time = 0;

    private static void resetTime() {
        time = System.currentTimeMillis();
    }

    private static void printContent(String content) {
        System.out.println(content + "     时间：" + (System.currentTimeMillis() - time));
    }

    public static void main(String[] args) {
        System.out.println(TimeUnit.SECONDS.toNanos(1));
        test1();
    }

    private static void test1() {

        Thread1 thread1 = new Thread1();
        thread1.start();
        //主线程延时3秒后interrupt中断
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //调用执行线程的interrupt
        thread1.interrupt();
        printContent("执行中断");
    }

    private static class Thread1 extends Thread {
        @Override
        public void run() {
            resetTime();
            int num = 0;
//            之前的while
//            while (true) {
//                if (isInterrupted()) {
//                    printContent("当前线程 isInterrupted");
//                    break;
//                }
//                num++;
//                if (num % 100 == 0) {
//                    printContent("num : " + num);
//                }
//            }
//            while (true){
//                if(isInterrupted()){
//                    printContent("当前线程 isInterrupted");
//                    break;
//                }
//                num++;
//                //sleep一下
//                try {
//                    Thread.sleep(1);
//                } catch (InterruptedException e) {
//                    //抛出异常后并不会设置中断标识位
//                    e.printStackTrace();
//                    System.out.println("线程中断了 中断的状态:"+isInterrupted());
//                }
//
//                if(num % 100 == 0){
//                    printContent("num : " + num);
//                }
//            }

            while (true) {
//                if (interrupted()) {
//                    System.out.println("线程被终端 查看中断标志位" + isInterrupted());
//                    break;
//                }
                if(isInterrupted()){
                    System.out.println("线程被中断 查看中断标志位" + isInterrupted());
                    printContent("当前线程 isInterrupted");
                    break;
                }
                num++;
                //sleep一下
//                try {
//                    Thread.sleep(1);
//                } catch (InterruptedException e) {
//                    //抛出异常后并不会设置中断标识位
//                    e.printStackTrace();
//                    System.out.println("线程中断了 中断的状态:"+isInterrupted());
//                }

                if (num % 100 == 0) {
                    printContent("num : " + num);
                }
            }
        }
    }
}