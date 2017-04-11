package org.dalvin.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by qiudeyang on 11/04/17.
 */
class Business{
    boolean bool = true;
    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();
    public void main(int loop) throws InterruptedException{
        lock.lock();
        try {
            while (bool){
                condition.await();
            }
            for (int i = 0; i < 10; i++) {
                System.out.println("main thread seq of "+i+" ,loop of "+loop);
            }
            bool = true;
            condition.signal();
        }finally {
            lock.unlock();
        }
    }

    public void sub(int loop) throws InterruptedException{
        lock.lock();
        try {
            while (!bool){
                condition.await();
            }
            for (int i = 0; i < 10; i++) {
                System.out.println("sub thread seq of "+i+" ,loop of "+loop);
            }
            bool = false;
            condition.signal();
        }finally {
            lock.unlock();
        }
    }
}
public class TestCondition {
    public static void threadExecute(Business business,String threadType){
        for (int i = 0; i < 10; i++) {
            try{
                if (threadType.equals("main")){
                    business.main(i);
                }else{
                    business.sub(i);
                }
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        Business business = new Business();
        new Thread(new Runnable() {
            @Override
            public void run() {
                threadExecute(business,"sub");
            }
        }).start();
        threadExecute(business,"main");
    }
}
