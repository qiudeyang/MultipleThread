package org.dalvin.interruptedexception;

/**
 * Created by qiudeyang on 01/03/17.
 */
class SleepJob implements Runnable {
    @Override
    public void run() {
        try {
            System.out.println("Started sleeping.");
            Thread.sleep(1000);
            System.out.println("Finished sleeping.");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // Re-set the interrupted flag.
        }
    }
}

public class MultipleSleep {

    public static void main(String[] args) throws InterruptedException {
        Thread sleeperThread = new Thread(() -> {
            Runnable job1 = new SleepJob();
            Runnable job2 = new SleepJob();
            Runnable job3 = new SleepJob();

            job1.run();
            if (Thread.interrupted()) {
                System.out.println("Interrupted in job1. Stop.");
                return;
            }
            job2.run();
            if (Thread.interrupted()) {
                System.out.println("Interrupted in job2. Stop.");
                return;
            }
            job3.run();
            if (Thread.interrupted()) {
                System.out.println("Interrupted in job3. Stop.");
                return;
            }
        });

        sleeperThread.start();
        Thread.sleep(1500);
        sleeperThread.interrupt();
        sleeperThread.join();
    }

}