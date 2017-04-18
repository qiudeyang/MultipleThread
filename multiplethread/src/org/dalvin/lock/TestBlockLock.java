package org.dalvin.lock;

import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.LockSupport;

/**
 * Created by qiudeyang on 17/04/17.
 */
public class TestBlockLock {
    private AtomicReference<Thread> sign = new AtomicReference<>();
    public void lock(){
        Thread current = Thread.currentThread();
        if (!sign.compareAndSet(null,current)){
            LockSupport.park();
        }
    }

    public void unlock(){
        Thread current = Thread.currentThread();
        sign.compareAndSet(current,null);
        LockSupport.unpark(current);
    }
}
