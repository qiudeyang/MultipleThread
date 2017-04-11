package org.dalvin.synchronizedandlock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by qiudeyang on 07/04/17.
 */
public class TestLock {
    public static void main(String[] args) {
        System.out.println(new TestLock().increase());
    }
    public int increase(){
        int count = 0;
        Lock lock = new ReentrantLock();
        lock.lock();
        int result = ++count;
        lock.unlock();
        return result;
    }
}
