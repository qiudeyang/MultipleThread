package org.dalvin.interruptedexception;

/**
 * Created by qiudeyang on 01/03/17.
 */
public class TestIsInterrupted {
    public static void main(String[] args) throws InterruptedException {
        Thread sleeper = new Thread(() -> {
            try {
                Thread.sleep(1000);
                System.out.println("I woke up by myself.");
            } catch (InterruptedException e) {
                System.out.println("I was interrupted.");
//                System.out.println(Thread.currentThread().isInterrupted());
                Thread.currentThread().interrupt();
                System.out.println(Thread.currentThread().isInterrupted());
                e.printStackTrace();
            }
        });
        sleeper.start();
        Thread.sleep(500);
        System.out.println("Main thread woke up.");
        System.out.println("before interrupt " + sleeper.isInterrupted());
        sleeper.interrupt();
        System.out.println("after interrupt " + sleeper.isInterrupted());
//        sleeper.join();
        System.out.println("after join " + sleeper.isInterrupted());
//最后一个为什么是false，而不是true
    }
}
