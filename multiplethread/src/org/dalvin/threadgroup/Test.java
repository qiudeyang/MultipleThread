package org.dalvin.threadgroup;

/**
 * Created by qiudeyang on 29/03/17.
 */
public class Test {
    public static void main(String[] args) {
        ThreadGroup threadGroup = new ThreadGroup("group1"){
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println(t.getName()+"\t"+e.getMessage());
            }
        };
        Thread thread1 = new Thread(threadGroup, new Runnable() {
            @Override
            public void run() {
                throw new RuntimeException("测试异常");
            }
        });
        thread1.start();
        System.out.println(Thread.currentThread().getThreadGroup().activeCount());
    }
}
