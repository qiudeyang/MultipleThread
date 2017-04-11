package org.dalvin.countdownlatch;

import java.util.Date;
import java.util.concurrent.CountDownLatch;

/**
 * Created by qiudeyang on 05/03/17.
 */
class Worker extends Thread {
    String workName;
    int workTime;
    CountDownLatch latch;

    public Worker(String workName, int workTime, CountDownLatch latch) {
        this.workName = workName;
        this.workTime = workTime;
        this.latch = latch;
    }

    public void run() {
        System.out.println("worker " + workName + " do work begin at " + new Date());
        doWork();
        System.out.println("worker " + workName + " do work complete at " + new Date());
        latch.countDown();
    }

    public void doWork() {
        try {
            Thread.sleep(workTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(3);
        Worker worker1 = new Worker("zhang san", 5000, latch);
        Worker worker2 = new Worker("li si", 8000, latch);
        worker1.start();
        worker2.start();
        latch.await();
        System.out.println("all work done at " + new Date());
    }
}
