package org.dalvin.producerconsumer.awaitsignal;

/**
 * Created by qiudeyang on 03/03/17.
 */
public class TestAwaitAndSignal {
    public static void main(String[] args) {
        Storage1 storage1 = new Storage1();

        // 生产者对象
        Producer1 p1 = new Producer1(storage1);
        Producer1 p2 = new Producer1(storage1);
        Producer1 p3 = new Producer1(storage1);
        Producer1 p4 = new Producer1(storage1);
        Producer1 p5 = new Producer1(storage1);
        Producer1 p6 = new Producer1(storage1);
        Producer1 p7 = new Producer1(storage1);

        // 消费者对象
        Consumer1 c1 = new Consumer1(storage1);
        Consumer1 c2 = new Consumer1(storage1);
        Consumer1 c3 = new Consumer1(storage1);

        // 设置生产者产品生产数量
        p1.setNum(10);
        p2.setNum(10);
        p3.setNum(10);
        p4.setNum(10);
        p5.setNum(10);
        p6.setNum(10);
        p7.setNum(80);

        // 设置消费者产品消费数量
        c1.setNum(50);
        c2.setNum(20);
        c3.setNum(30);

        // 线程开始执行
        c1.start();
        c2.start();
        c3.start();
        p1.start();
        p2.start();
        p3.start();
        p4.start();
        p5.start();
        p6.start();
        p7.start();
    }
}
