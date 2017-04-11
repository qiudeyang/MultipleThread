package org.dalvin.interruptedexception;

/**
 * Created by qiudeyang on 01/03/17.
 */
public class TestIsInterrupted1 {
    public static void main(String[] args) throws InterruptedException {
        Thread sleeper = new Thread(() -> {
            try {
                Thread.sleep(400);
                System.out.println("I woke up by myself.");
            } catch (InterruptedException e) {
                System.out.println("I was interrupted.");
//                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
        });
        sleeper.start();
        Thread.sleep(500);
        System.out.println("Main thread woke up.");
        System.out.println("before interrupt " + sleeper.isInterrupted());
        sleeper.interrupt();
        System.out.println("after interrupt " + sleeper.isInterrupted());
        sleeper.join();
        System.out.println("after join " + sleeper.isInterrupted());
//最后两个为什么都是false
    }
}
