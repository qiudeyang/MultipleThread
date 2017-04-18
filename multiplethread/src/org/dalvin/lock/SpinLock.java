package org.dalvin.lock;

import java.util.concurrent.atomic.AtomicReference;

/**
 * Created by qiudeyang on 17/04/17.
 */
public class SpinLock {
    private AtomicReference<Thread> sign = new AtomicReference<>();

    public void lock(){
        Thread current = Thread.currentThread();
        while (!sign.compareAndSet(null,current)){

        }
    }

    public void unlock(){
        Thread current = Thread.currentThread();
        sign.accumulateAndGet(current,null);
    }
    public static void main(String[] args) {

    }
}
