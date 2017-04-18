package org.dalvin.condition;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by qiudeyang on 16/04/17.
 */

public class PrintABC {
    Lock lock = new ReentrantLock();
    Condition conditionA = lock.newCondition();
    Condition conditionB = lock.newCondition();
    Condition conditionC = lock.newCondition();
    char currentThreadName = 'A';

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(3);
        PrintABC printABC = new PrintABC();
        service.execute(printABC.new ThreadA());
        service.execute(printABC.new ThreadB());
        service.execute(printABC.new ThreadC());
        service.shutdown();
    }
    private class ThreadA implements Runnable{
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                lock.lock();
                try{
                    while (currentThreadName != 'A'){
                        try{
                            conditionA.await();
                        }catch (InterruptedException e){
                            e.printStackTrace();
                        }
                    }
                    System.out.println(i+"\t"+currentThreadName);
                    currentThreadName = 'B';
                    conditionB.signal();
                }finally {
                    lock.unlock();
                }
                }
        }
    }
    private class ThreadB implements Runnable{
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                lock.lock();
                try{
                    while (currentThreadName != 'B'){
                        try{
                            conditionB.await();
                        }catch (InterruptedException e){
                            e.printStackTrace();
                        }
                    }
                    System.out.println(i+"\t"+currentThreadName);
                    currentThreadName = 'C';
                    conditionC.signal();
                }finally {
                    lock.unlock();
                }
            }
        }
    }
    private class ThreadC implements Runnable{
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                lock.lock();
                try{
                    while (currentThreadName != 'C'){
                        try{
                            conditionC.await();
                        }catch (InterruptedException e){
                            e.printStackTrace();
                        }
                    }
                    System.out.println(i+"\t"+currentThreadName);
                    currentThreadName = 'A';
                    conditionA.signal();
                }finally {
                    lock.unlock();
                }
            }
        }
    }
}
