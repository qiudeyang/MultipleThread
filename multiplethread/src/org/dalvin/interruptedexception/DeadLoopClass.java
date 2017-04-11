package org.dalvin.interruptedexception;

/**
 * Created by qiudeyang on 01/03/17.
 */
//执行结果很不能理解
public class DeadLoopClass {
    static {
        if (true) {
            System.out.println(Thread.currentThread() + " init deadloopclass");
            while (true) {

            }
        }
    }

    public static void main(String[] args) {
        Runnable script = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread() + "start");
//                DeadLoopClass dlc = new DeadLoopClass();
                System.out.println(Thread.currentThread() + "end");
            }
        };
        Thread thread1 = new Thread(script);
        Thread thread2 = new Thread(script);
        thread1.start();
        thread2.start();
    }
}
