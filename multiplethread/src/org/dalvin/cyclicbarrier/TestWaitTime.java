package org.dalvin.cyclicbarrier;

import java.util.Date;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * Created by qiudeyang on 05/03/17.
 */
class Writer1 extends Thread{
    private CyclicBarrier barrier;
    public Writer1(CyclicBarrier barrier){
        this.barrier = barrier;
    }
    public void run(){
        System.out.println(new Date()+" thread "+Thread.currentThread().getName()+" is writing data");
        try {
            Thread.sleep(5000);
            System.out.println(new Date()+" thread "+Thread.currentThread().getName()+" writing done");
            try{
                barrier.await(2000, TimeUnit.MILLISECONDS);
            }catch (TimeoutException e){
                e.printStackTrace();
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }catch (BrokenBarrierException e){
            e.printStackTrace();
        }
        System.out.println(new Date()+" all thread write done");
    }
}
public class TestWaitTime {
    public static void main(String[] args) {
        int N = 4;
        CyclicBarrier barrier = new CyclicBarrier(N);
        for (int i = 0; i < N; i++) {
            if (i < N-1){
                new Writer1(barrier).start();
            }else{
                try {
                    Thread.sleep(5000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                new Writer1(barrier).start();
            }
        }
    }
}

