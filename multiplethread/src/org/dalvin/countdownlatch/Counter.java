package org.dalvin.countdownlatch;

import java.util.concurrent.CountDownLatch;

/**
 * Created by qiudeyang on 05/03/17.
 */
public class Counter{
    public static int count = 0;
    public static synchronized void increase(){
        count++;
    }
    public static void main(String[] args) throws InterruptedException{
        CountDownLatch latch = new CountDownLatch(1000);
        for (int i = 0; i < 1000; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    increase();
                    latch.countDown();
                }
            }).start();
        }
        latch.await();
        System.out.println(count);
    }
}