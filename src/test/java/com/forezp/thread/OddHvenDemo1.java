package com.forezp.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 使用condition 实现线程的等待和唤醒，condition是和LOCK配合使用，不是OBJ
 */
public class OddHvenDemo1 {
    private int i = 0;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    /**
     * 奇数线程开启
     */

    public void Odd() {
        while (i < 10) {
            try {
                lock.lock();
                if (i % 2 == 1) {
                    System.out.println("奇数" + i);
                    i++;
                    condition.signal();
                } else {
                    try {
                        condition.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } finally {
                lock.unlock();
            }
        }
    }

    /**
     * 偶数线程开启
     */
    public void even() {
        while (i < 10) {
            try {
                lock.lock();
                if (i % 2 == 0) {
                    System.out.println("偶数" + i);
                    i++;
                    condition.signal();//唤醒偶数线程
                } else {
                    try {
                        condition.await();//等待
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        final OddHvenDemo oddHvenDemo = new OddHvenDemo();
        //1.开启奇数线程打印
        Thread th = new Thread(new Runnable() {
            public void run() {
                oddHvenDemo.odd();
            }
        });

        //2.开启偶数线程
        Thread th1 = new Thread(new Runnable() {
            public void run() {
                oddHvenDemo.even();
            }
        });
        th.start();
        th1.start();
    }
}
