package com.company;

public class ThreadDemo {
    public static void main(String[] args) {
        new ThreadTest().start();
        for (int i=0; i <=5; ++i) {
            System.out.println("Demo线程正在运行。。。");
            try {
                Thread.sleep(1000);
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
