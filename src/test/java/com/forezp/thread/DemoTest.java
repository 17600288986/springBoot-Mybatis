package com.forezp.thread;

import com.forezp.dao.ClassNameMapper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

@SpringBootTest
public class DemoTest {

    private static Object obj = new Object();
    private static Object obj1 = new Object();

    //(1)实现接口callable去创建线程
    @Test
    public void test1() {

        FutureTask<String> task = new FutureTask<String>(new Mycallable());
        //要启动的线程，线程的别名
        Thread thread = new Thread(task, "Mycallable");
        thread.start();
        //在主线程打印信息
        for (int i = 1; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + "执行时间是:" + new Date().getTime() + "循环次数是：" + i);
        }
        //获取并打印Mycallable结果
        try {
            String result = task.get();
            System.out.println("Mycallable:" + result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    //(2)实现接口Runnable去创建线程
    @Test
    public void test2() {
        Thread thread = new Thread(new MyRunnable());
        thread.start();
        //在主线程打印信息
        for (int i = 1; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + "执行时间是:" + new Date().getTime() + "循环次数是：" + i);
        }

    }

    //(3)继承Thread去创建线程
    @Test
    public void test3() {
        MyThread myThread = new MyThread();
        myThread.start();
        //在主线程打印信息
        for (int i = 1; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + "执行时间是:" + new Date().getTime() + "循环次数是：" + i);
        }
    }

    @Test
    public void test4() {
        String s = "1234567890";
        String substring = s.substring(s.length() - 8);
        System.out.println(substring);
    }

    @Test

    public void test5() {
        //多个窗口同时出售电影票
        Thread thread1 = new Thread(new Ticket(), "窗口1");
//        Thread thread2 = new Thread(ticket,"窗口2");
//        Thread thread3 = new Thread(ticket,"窗口3");
        thread1.start();
//        thread2.start();
//        thread3.start();
    }

    //判断Object对象是否为空
    @Test
    public void test6() {
        Object a = null;
        boolean empty = StringUtils.isEmpty(a);
        System.out.println(empty);
    }

    @Test
    public void test7() {
        if (obj == obj1) {
            System.out.println("相同");
        } else {
            System.out.println("不同");
        }
    }

    @Test
    public void test8() {
        for (int i = 0; i < 15; i++) {
            System.out.println(i);
        }
    }


    @Test
    public void dropFrameDebug() {
        int i = 98;
        System.out.println(i);
        i++;
        method1(i);

    }

    public void method1(int i) {
        System.out.println("method1:" + i);
        method2(i);
    }

    public void method2(int j) {
        j++;
        System.out.println("method2:" + j);
    }

    @Test
    public void test() {
        String[] str = {"1", "2", "bilibili", "of", "codesheep", "5", "at", "BILIBILI", "codesheep", "23", "CHEERS", "6"};
        String[] str1 = {"张三", "李四", "王二", "麻子"};
        List<String> list = Arrays.asList(str);
        System.out.println(list);

        List<String> testData = new ArrayList<String>();
        testData.add("张三");
        testData.add("李四");
        testData.add("王二");
        testData.add("麻子");
        System.out.println(testData);
        list.stream()
                .filter(x -> x.startsWith("张"))
                .filter(x -> x.length() >= 5);


    }


}
