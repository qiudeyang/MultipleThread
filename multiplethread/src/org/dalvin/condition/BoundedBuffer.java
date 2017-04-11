package org.dalvin.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//jdk的官方例子
/**
 * Created by qiudeyang on 11/04/17.
 */
public class BoundedBuffer {
    Lock lock = new ReentrantLock();
    Condition notFull = lock.newCondition(); //写线程条件
    Condition notempty = lock.newCondition(); //读线程条件

    Object[] items = new Object[100];
    int putptr;
    int takeptr;
    int count;

    public void put(Object x) throws InterruptedException{
        lock.lock();
        try{
            while (count==items.length){
                notFull.await();
            }
            items[putptr]=x;
            if (++putptr==items.length){
                putptr = 0;
            }
            count++;
            notempty.signal();
        }finally {
            lock.unlock();
        }
    }

    public Object take() throws InterruptedException{
        lock.lock();
        try {
            while (count==0){
                notempty.await();
            }
            Object obj = items[takeptr];
            if (++takeptr==items.length){
                takeptr=0;
            }
            --count;
            notFull.signal();
            return obj;
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        BoundedBuffer boundedBuffer = new BoundedBuffer();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("t1 run");
                for (int i = 0; i < 1000; i++) {
                    try{
                        System.out.println("putting.. "+i);
                        boundedBuffer.put(Integer.valueOf(i));
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("taking..");
                for (int i = 0; i < 1000; i++) {
                    try {
                        Object val = boundedBuffer.take();
                        System.out.println(val);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }


                }
            }
        });
        t1.start();
        t2.start();
    }
}
