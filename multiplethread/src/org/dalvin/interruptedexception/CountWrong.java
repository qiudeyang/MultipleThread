package org.dalvin.interruptedexception;

/**
 * Created by qiudeyang on 01/03/17.
 */
public class CountWrong {
    public static void main(String[] args) throws InterruptedException {
        Thread counter = new Thread(() -> {
            int i = 0;
            while (true) {
                System.out.println(i);
                i++;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) { // WRONG!!!
                    e.printStackTrace();
                }
            }
        });

        counter.start();
        Thread.sleep(3500);
        counter.interrupt();
        counter.join();
    }
}
