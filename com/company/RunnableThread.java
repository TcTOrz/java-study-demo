package com.company;

public class RunnableThread {
    public static void main(String[] args) {
        TestRunnableThread th = new TestRunnableThread();
        new Thread(th).start();
        for (int i=0; i<5; i++) {
            System.out.println("main...");
            try {
                Thread.sleep(1000);
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
