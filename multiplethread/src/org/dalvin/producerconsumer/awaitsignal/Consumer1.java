package org.dalvin.producerconsumer.awaitsignal;

/**
 * Created by qiudeyang on 03/03/17.
 */


/**
 * 消费者类Consumer继承线程类Thread
 * <p>
 * Email:530025983@qq.com
 *
 * @author MONKEY.D.MENG 2011-03-15
 */
class Consumer1 extends Thread {
    // 每次消费的产品数量
    private int num;

    // 所在放置的仓库
    private Storage1 storage1;

    // 构造函数，设置仓库
    public Consumer1(Storage1 storage1) {
        this.storage1 = storage1;
    }

    // 线程run函数
    public void run() {
        consume(num);
    }

    // 调用仓库Storage的生产函数
    public void consume(int num) {
        storage1.consume(num);
    }

    // get/set方法
    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public Storage1 getStorage() {
        return storage1;
    }

    public void setStorage(Storage1 storage1) {
        this.storage1 = storage1;
    }
}
