package org.dalvin.sleepandwait;

import java.util.Date;

/**
 * Created by qiudeyang on 01/03/17.
 */
//wait是在当前线程持有wait对象锁的情况下，暂时放弃锁，并让出CPU资源，并积极等待其它线程调用同一对象的notify或者notifyAll方法。
// 注意，即使只有一个线程在等待，并且有其它线程调用了notify或者notifyAll方法，等待的线程只是被激活，但是它必须得再次获得锁才能继续往下执行。
// 换言之，即使notify被调用，但只要锁没有被释放，原等待线程因为未获得锁仍然无法继续执行。
// 重点在于Thread2 release lock在Thread1 ended前面。
public class Wait {
    public static void main(String[] args) {
        //jdk1.8新增lambda表达式
        Thread thread1 = new Thread(() -> {
            synchronized (Wait.class) {
                try {
                    System.out.println(new Date() + " Thread1 is running");
                    Wait.class.wait();
                    System.out.println(new Date() + " Thread1 ended");
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        thread1.start();

        Thread thread2 = new Thread(() -> {
            synchronized (Wait.class) {
                try {
                    System.out.println(new Date() + " Thread2 is running");
                    Wait.class.notify();
                    // Don't use sleep method to avoid confusing
                    for (long i = 0; i < 200000; i++) {
                        for (long j = 0; j < 100000; j++) {
                        }
                    }
                    System.out.println(new Date() + " Thread2 release lock");
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }

            for (long i = 0; i < 200000; i++) {
                for (long j = 0; j < 100000; j++) {
                }
            }
            System.out.println(new Date() + " Thread2 ended");
        });

        // Don't use sleep method to avoid confusing
        for (long i = 0; i < 200000; i++) {
            for (long j = 0; j < 100000; j++) {
            }
        }
        thread2.start();
    }
}
