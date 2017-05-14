package org.dalvin.createthread;

import java.util.Date;

/**
 * Created by qiudeyang on 01/03/17.
 */
class ExtendsThread extends Thread {
    public void run() {
        System.out.println("thread "+new Date()+"\t"+Thread.currentThread().getName());
        for (int i = 0; i < 3; i++) {
            System.out.println(new Date() +" extends thread " + i);
        }
//        while (true){
//
//        }
    }
}

class ImplementRunnable extends Thread {
    public void run() {
        for (int i = 0; i < 300; i++) {
            System.out.println(new Date() +" implement runnable " + i);
        }
    }
}

public class Test {
    public static void main(String[] args) throws Exception {
//        thread1是继承thread类
//        Thread thread1 = new Thread() {
//            public void run() {
//                for (int i = 0; i < 300; i++) {
//                    System.out.println("extends thread " + i);
//                }
//            }
//        };
//        thread2是实现Runnable接口
//        Thread thread2 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for (int i = 0; i < 300; i++) {
//                    System.out.println("implement runnable " + i);
//                }
//            }
//        });
//        thread1.start();
//        thread2.start();

        ExtendsThread et = new ExtendsThread();
//        ImplementRunnable ir = new ImplementRunnable();
        et.start();
        System.out.println("main "+new Date()+"\t"+Thread.currentThread().getName());
//        et.join();
//        new Thread(ir).start();

//        et.run();
//        ir.run();
    }
}
