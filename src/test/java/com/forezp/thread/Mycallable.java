package com.forezp.thread;

import java.util.Date;
import java.util.concurrent.Callable;

public class Mycallable implements Callable<String> {


    @Override
    public String call() throws Exception {
        for (int i = 1; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + "执行时间是:" + new Date().getTime() + "循环次数是：" + i);
        }
        return "Mycallable接口执行完成";
    }
}
