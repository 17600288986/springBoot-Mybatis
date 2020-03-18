package com.forezp.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockTest implements Runnable {

    private int ticketNum = 100;
    //使用同步锁 上锁和解锁是两个相互配合使用的，只有上锁没有解锁就会出现死锁的情况
    private Lock lock = new ReentrantLock(true);//true代表公平锁，false代表非公平锁

    @Override
    public void run() {
        try {
            while (true) {
                //上锁
                lock.lock();
                if (ticketNum > 0) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    //打印当前票数字和线程名，票数减1
                    String name = Thread.currentThread().getName();
                    System.out.println("线程" + name + "销售电影票" + ticketNum--);
                }
            }
        } finally {
            //解锁
            lock.unlock();
        }

    }

    public static void main(String[] args) {
        //会出现线程安全问题
        LockTest lock = new LockTest();
        Thread thread1 = new Thread(lock, "窗口1");
        Thread thread2 = new Thread(lock, "窗口2");
        Thread thread3 = new Thread(lock, "窗口3");
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
