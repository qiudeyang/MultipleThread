package org.dalvin.deadlock;

/**
 * Created by qiudeyang on 19/04/17.
 */
public class TestDeadLock {
    Object left = new Object();
    Object right = new Object();

    class Thread1 implements Runnable {
        @Override
        public void run() {
            try {
                synchronized (left) {
                    Thread.sleep(2000);
                    synchronized (right) {
                        System.out.println("leftright");
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    class Thread2 implements Runnable {
        @Override
        public void run() {
            try {
                synchronized (right) {
                    Thread.sleep(2000);
                    synchronized (left) {
                        System.out.println("rightleft");
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    public static void main(String[] args) {
        new TestDeadLock().helper();
    }

    public void helper() {
        Thread thread1 = new Thread(new Thread1());
        Thread thread2 = new Thread(new Thread2());
        thread1.start();
        thread2.start();
    }
}
