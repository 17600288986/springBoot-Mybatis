package com.forezp.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Ticket implements Runnable {
    private int ticketNum = 100;

    Object obj = new Object();
    //true 代表公平锁，任何线程都能抢占资源，拥有执行权，false代表独占锁，只有一个线程可以拿到执行权，除非该线程自己主动释放或者线程执行完毕。
    private Lock lock = new ReentrantLock(true);

    public void run() {
        //模拟多个窗口同时售卖电影票的环节
        //1使用同步代码块达到线程安全。
//        synchronized (obj){
//            while (true){
//                //判断是否有票ticketNum>0
//                if (ticketNum>0){
//                    try {
//                        Thread.sleep(100);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    String name = Thread.currentThread().getName();
//                    System.out.println("线程"+name+"销售电影票:"+ticketNum--);
//                }
//            }
//        }

//        //使用同步方法同步
//        while (true){
//            this.saleTicket();
//        }

        while (true) {
//            this.saleTicket();
//        }
        }


//    private synchronized void saleTicket(){
//
//                //判断是否有票ticketNum>0
//                if (ticketNum>0){
//                    try {
//                        Thread.sleep(100);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    String name = Thread.currentThread().getName();
//                    System.out.println("线程"+name+"销售电影票:"+ticketNum--);
//                }
//
//    }

    }

    public static void main(String[] args) {
        //会出现线程安全问题
        Ticket ticket = new Ticket();
        Thread thread1 = new Thread(ticket, "窗口1");
        Thread thread2 = new Thread(ticket, "窗口2");
        Thread thread3 = new Thread(ticket, "窗口3");
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
