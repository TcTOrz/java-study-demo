package com.company;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadStatus {

    public static void main(String[] args) {
        new Thread(new TimeWaiting(), "TimeWaiting").start();
        new Thread(new Waiting(), "WaitingThread").start();
        //使用两个Blocked线程，一个获取锁，一个被阻塞
        new Thread(new Blocked(), "BThread-1").start();
        new Thread(new Blocked(), "Bthread-2").start();
        new Thread(new Sync(), "Sync Thread-1").start();
        new Thread(new Sync(), "Sync Thread-2").start();
    }
}

// 改线程不断地进入睡眠
class TimeWaiting implements Runnable
{
    public void run() {
        while (true) {
            try {
                TimeUnit.SECONDS.sleep(10);
                System.out.println("I am TimeWaiting Thread:" + Thread.currentThread().getName());
            }catch (InterruptedException e) {}
        }
    }
}

//该进程在Waiting.class实例上等待
class Waiting implements Runnable
{
    public void run() {
        while (true) {
            synchronized (Waiting.class)
            {
                try {
                    System.out.println("I am Wating Thead:" + Thread.currentThread().getName());
                    Waiting.class.wait();
                }catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

//该线程在Blocked.class实例上加锁后，不会释放该锁
class Blocked implements Runnable
{
    public void run() {
        synchronized (Blocked.class) {
            while (true) {
                try {
                    System.out.println("I am Blocked Thread:" + Thread.currentThread().getName());
                    TimeUnit.SECONDS.sleep(10);
                }catch (InterruptedException e) {}
            }
        }
    }
}

//该线程用于同步锁
class Sync implements Runnable
{
    public static Lock lock = new ReentrantLock();
    public void run() {
        lock.lock();
        try {
            System.out.println("I am Sync Thread:" + Thread.currentThread().getName());
            TimeUnit.SECONDS.sleep(10);
        }catch (InterruptedException e) {}
        finally {
            lock.unlock();
        }
    }
}
