package com.forezp.thread;


import java.util.Date;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * cyclicBarrie用来阻塞一组线程直到某个事件的发生
 */
public class ThreeThreadStarDemo {

    private CyclicBarrier cyclicBarrie = new CyclicBarrier(3); //参数表示cyclicBarrie的线程数

    public void startThread() {
        //打印线程准备启动
        String name = Thread.currentThread().getName();
        System.out.println(name + "正在准备");
        //调用cyclicBarrie的await方法，等线程全部准备完成
        try {
            cyclicBarrie.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
        //打印线程启动完毕信息
        System.out.println("已启动完毕：" + new Date().getTime());
    }

    public static void main(String[] args) {
        ThreeThreadStarDemo threeThreadStarDemo = new ThreeThreadStarDemo();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                threeThreadStarDemo.startThread();
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                threeThreadStarDemo.startThread();
            }
        });

        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                threeThreadStarDemo.startThread();
            }
        });

        thread1.start();
        thread2.start();
        thread3.start();
    }

}
