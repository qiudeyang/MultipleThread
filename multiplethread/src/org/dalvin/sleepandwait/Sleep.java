package org.dalvin.sleepandwait;

import java.util.Date;

/**
 * Created by qiudeyang on 01/03/17.
 */
//sleep不释放锁，只有当该线程执行完，其它线程才能拿到对象的锁去执行代码。
public class Sleep {
    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            synchronized (Sleep.class) {
                try {
                    System.out.println(new Date() + " Thread1 is running");
                    Thread.sleep(2000);
                    System.out.println(new Date() + " Thread1 ended");
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        thread1.start();

        Thread thread2 = new Thread(() -> {
            synchronized (Sleep.class) {
                try {
                    System.out.println(new Date() + " Thread2 is running");
                    Thread.sleep(2000);
                    System.out.println(new Date() + " Thread2 ended");
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }

            for (long i = 0; i < 200000; i++) {
                for (long j = 0; j < 100000; j++) {
                }
            }
        });

        // Don't use sleep method to avoid confusing
        for (long i = 0; i < 200000; i++) {
            for (long j = 0; j < 100000; j++) {
            }
        }
        thread2.start();
    }
}
