package org.dalvin.cyclicbarrier;

/**
 * Created by qiudeyang on 05/03/17.
 */

import java.util.Date;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by qiudeyang on 05/03/17.
 */
class Writer2 extends Thread{
    private CyclicBarrier barrier;
    public Writer2(CyclicBarrier barrier){
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
public class TestReusing {
    public static void main(String[] args) {
        int N = 4;
        CyclicBarrier barrier = new CyclicBarrier(N);
        for (int i = 0; i < N; i++) {
            new Writer2(barrier).start();
        }
        try {
            Thread.sleep(25000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("prefour thread done");
        for (int i = 0; i < N; i++) {
            new Writer2(barrier).start();
        }
    }
}

