package com.forezp.thread;

import java.util.concurrent.CountDownLatch;


/**
 * 模拟教练等待运动员到来训练，运动员到不全不开始训练
 */
public class CoachRacerDemo {
    //CountDownLatch 作用是等待其他线程全部执行完成后再执行，初始化时需要设置需要等待的线程数
    private CountDownLatch countDownLatch = new CountDownLatch(3);

    /**
     * 运动员方法，供运动员调用
     */
    public void racer() {
        //1.获取运动云名称
        String name = Thread.currentThread().getName();
        //2.运动员开始准备，打印准备信息
        System.out.println(name + "正在准备。。。。");
        //3.线程睡眠1000毫秒表示运动员在准备
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //4.运动员准备完毕，打印准备完毕信息，同时计数-1
        System.out.println(name + "准备完毕!");
        countDownLatch.countDown();//对运动员线程数量进行减1
    }

    /**
     * 教练方法，供教练调用
     */
    public void coach() {
        //1.获取教练线程名称
        String name = Thread.currentThread().getName();

        //2.打印教练线程准备执行
        System.out.println(name + "等待运动员准备。。。。");

        //3.调用CountDowlatch方法等待其他线程执行完毕
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //4.打印教练线程准备完毕
        System.out.println("所有运动员准备完毕！" + name);
    }

    public static void main(String[] args) {
        //1.创建coachRacerDemo实例
        CoachRacerDemo coachRacerDemo = new CoachRacerDemo();
        //创建三个线程调用运动员方法
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                coachRacerDemo.racer();
            }
        }, "运动员1");
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                coachRacerDemo.racer();
            }
        }, "运动员2");
        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                coachRacerDemo.racer();
            }
        }, "运动员3");

        //创建一个线程执行教练方法
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                coachRacerDemo.coach();
            }
        }, "教练");
        thread.start();
        thread2.start();
        thread3.start();
        thread1.start();


    }

}
