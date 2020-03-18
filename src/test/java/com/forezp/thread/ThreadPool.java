package com.forezp.thread;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPool {

    public static void main(String[] args) {
        //使用线程池创建线程
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        executorService.execute(new MyRunnable());
        //主线程打印相关信息
        for (int i = 1; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + "执行时间是:" + new Date().getTime() + "循环次数是：" + i);
        }

    }
}
