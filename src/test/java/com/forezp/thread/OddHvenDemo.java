package com.forezp.thread;

public class OddHvenDemo {

    private int i = 0;
    private Object obj = new Object();

    /**
     * 奇数打印方法由奇数线程调用
     */
    public void odd() {
        //1.判断是否小于10
        while (i < 10) {
            //notify方法和wait方法需要用synchronized代码块，或者放到synchronized修饰的方法中
            synchronized (obj) {
                //2.<10打印奇数
                if (i % 2 == 1) {
                    System.out.println("奇数" + i);
                    i++;
                    obj.notify();//唤醒偶数线程打印
                } else {
                    try {
                        obj.wait();//等待偶数线程打印完毕
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    /**
     * 偶数打印的方法由偶数线程调用
     */
    public void even() {
        //判断是否小于10
        while (i < 10) {
            synchronized (obj) {
                //判断是不是偶数
                if (i % 2 == 0) {
                    System.out.println("偶数" + i);
                    i++;
                    obj.notify();
                } else {
                    try {
                        obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
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
