package org.dalvin.readwrite;

import java.util.Date;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by qiudeyang on 03/03/17.
 */
public class ReadWriteLockDemo {
    public static void main(String[] args) {
        ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
        new Thread(() -> {
            readWriteLock.readLock().lock();
            try {
                System.out.println(new Date() + " thread1 started with read lock");
                try {
                    Thread.sleep(2000);
                } catch (Exception e) {

                }
                System.out.println(new Date() + " thread1 ended");
            } finally {
                readWriteLock.readLock().unlock();  //finally中记得释放锁。
            }
        }).start();
        new Thread(() -> {
            readWriteLock.readLock().lock();
            try {
                System.out.println(new Date() + " thread2 started with read lock");
                try {
                    Thread.sleep(2000);
                } catch (Exception e) {

                }
                System.out.println(new Date() + " thread2 ended");
            } finally {
                readWriteLock.readLock().unlock();
            }
        }).start();
        new Thread(() -> {
            readWriteLock.writeLock().lock();
            try {
                System.out.println(new Date() + " thread3 started with write lock");
                try {
                    Thread.sleep(2000);
                } catch (Exception e) {

                }
                System.out.println(new Date() + " thread3 ended");
            } finally {
                readWriteLock.writeLock().unlock();
            }
        }).start();
    }
}
