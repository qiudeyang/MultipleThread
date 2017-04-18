package org.dalvin.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by qiudeyang on 17/04/17.
 */
public class TestReentrantLock {
    public static void main(String[] args) {
        new TestReentrantLock().testReentrantLock();
        new TestReentrantLock().testSynchronized();
    }

    public void testReentrantLock(){
        for (int i = 0; i < 3; i++) {
            new Thread(new Runnable() {
                Lock lock = new ReentrantLock();
                @Override

                public void run() {
                    get();
                }

                public void get(){
                    lock.lock();
                    System.out.println("ReentrantLockGet"+"\t"+Thread.currentThread().getId());
                    set();
                    lock.unlock();
                }

                public void set(){
                    lock.lock();
                    System.out.println("ReentrantLockSet"+"\t"+Thread.currentThread().getId());
                    lock.unlock();
                }
            }).start();
        }
    }

    public void testSynchronized(){
        for (int i = 0; i < 3; i++) {
            new Thread(new Runnable() {
                @Override

                public void run() {
                    get();
                }

                public synchronized void get(){
                    System.out.println("SynchronizedGet"+"\t"+Thread.currentThread().getId());
                    set();
                }

                public synchronized void set(){
                    System.out.println("SynchronizedSet"+"\t"+Thread.currentThread().getId());
                }
            }).start();
        }
    }
}
