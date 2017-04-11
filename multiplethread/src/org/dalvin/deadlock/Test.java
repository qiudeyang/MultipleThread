package org.dalvin.deadlock;

import java.util.Hashtable;

/**
 * Created by qiudeyang on 01/03/17.
 */
//以下是死锁的例子
class DeadLock {
    Object left = new Object();
    Object right = new Object();

    //    抛异常是因为Thread.sleep可能抛InterruptedException。
    public void leftRight() throws Exception {
        synchronized (left) {
//            这里必须有一个暂停线程的命令，防止一下子获得多个对象的锁。
//            Thread.sleep(2000);
            synchronized (right) {
                System.out.println("leftRight");
            }
        }
    }

    public void rightLeft() throws Exception {
        synchronized (right) {
//            Thread.sleep(2000);
            synchronized (left) {
                System.out.println("rightLeft");
            }
        }
    }
}

class Thread0 extends Thread {
    private DeadLock d1;

    public Thread0(DeadLock d1) {
        this.d1 = d1;
    }

    public void run() {
        try {
            d1.leftRight();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class Thread1 extends Thread {
    private DeadLock d1;

    public Thread1(DeadLock d1) {
        this.d1 = d1;
    }
    public void run() {
        try {
            d1.rightLeft();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

public class Test {
    public static void main(String[] args) {
        DeadLock d1 = new DeadLock();
        Thread0 thread0 = new Thread0(d1);
        Thread1 thread1 = new Thread1(d1);

        thread0.start();
        thread1.start();


    }
}
