package org.dalvin.volatiletest;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by qiudeyang on 01/03/17.
 */
//atomicInteger为啥也不对
public class TestVolatile {
    static AtomicInteger ai = new AtomicInteger(0);

    public void increase1() {
        ai.incrementAndGet();
    }

    public static int i;

    public static synchronized void increase() {
        i++;
    }

    public static void main(String[] args) throws Exception {
        Thread[] threads = new Thread[20];
        for (int j = 0; j < threads.length; j++) {
            threads[j] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int k = 0; k < 10000; k++) {
                        increase();
//                        new TestVolatile().increase1();
                    }
                }
            });
            threads[j].start();
        }
        Thread.sleep(2000);
//        System.out.println(ai);
        System.out.println(i);
    }
}
