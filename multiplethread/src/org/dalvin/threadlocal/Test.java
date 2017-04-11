package org.dalvin.threadlocal;

/**
 * Created by qiudeyang on 29/03/17.
 */

public class Test {
    public static class MyRunnable implements Runnable {
        ThreadLocal threadLocal = new ThreadLocal();

        public void run() {
            threadLocal.set((int) (Math.random() * 100));
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread() + "\t" + threadLocal.get());
        }
    }

    public static void main(String[] args) {
        MyRunnable instance = new MyRunnable();
        Thread thread1 = new Thread(instance);
        Thread thread2 = new Thread(instance);
        thread1.start();
        thread2.start();
        System.out.println(Thread.currentThread().getThreadGroup().getName());
        System.out.println(Thread.currentThread().getName());
        System.out.println(Thread.currentThread().getState());
        System.out.println(Thread.currentThread().getThreadGroup().getParent().getName());
    }
}
