package com.company;

public class TestRunnableThread implements Runnable {
    public void run() {
        for (int i=0; i<5; i++) {
            System.out.println("TestThread...");
            try {
                Thread.sleep(1000);
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
