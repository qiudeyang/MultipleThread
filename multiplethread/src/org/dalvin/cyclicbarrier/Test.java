package org.dalvin.cyclicbarrier;

import java.util.Date;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by qiudeyang on 05/03/17.
 */
class Writer extends Thread{
    private CyclicBarrier barrier;
    public Writer(CyclicBarrier barrier){
        this.barrier = barrier;
    }
    public void run(){
        System.out.println(new Date()+" thread "+Thread.currentThread().getName()+" is writing data");
        try {
            Thread.sleep(5000);
            System.out.println(new Date()+" thread "+Thread.currentThread().getName()+" writing done");
            barrier.await();
        }catch (InterruptedException e){
            e.printStackTrace();
        }catch (BrokenBarrierException e){
            e.printStackTrace();
        }
        System.out.println(new Date()+" all thread write done");
    }
}
public class Test {
    public static void main(String[] args) {
        int N = 4;
        CyclicBarrier barrier = new CyclicBarrier(N, new Runnable() {
            @Override
            public void run() {
                System.out.println(new Date()+" current thread "+Thread.currentThread().getName());
            }
        });
        for (int i = 0; i < N; i++) {
            new Writer(barrier).start();
        }
    }
}
