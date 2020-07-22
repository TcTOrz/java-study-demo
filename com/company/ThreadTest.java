package com.company;

public class ThreadTest extends Thread {
    public void run() {
        for (int i=0; i <= 5; ++i) {
            System.out.println("TestThread线程正在运行。。。");
            try {
                Thread.sleep(1000);
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
