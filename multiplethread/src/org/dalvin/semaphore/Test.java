package org.dalvin.semaphore;

import java.util.Date;
import java.util.concurrent.Semaphore;

/**
 * Created by qiudeyang on 05/03/17.
 */
class Worker extends Thread{
    private int num;

    private Semaphore semaphore;

    public Worker(int num,Semaphore semaphore){
        this.num = num;
        this.semaphore = semaphore;
    }
    public void run(){
        try {
            semaphore.acquire();
            System.out.println(new Date()+" worker "+num+" acquire");
            Thread.sleep(2000);
            System.out.println(new Date()+" worker "+num+" release");
            semaphore.release();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
public class Test {

    public static void main(String[] args) {
        int N = 8;
        Semaphore semaphore = new Semaphore(5);
        System.out.println(semaphore.availablePermits());
        for (int i = 0; i < N; i++) {
            new Worker(i,semaphore).start();
        }
    }
}
