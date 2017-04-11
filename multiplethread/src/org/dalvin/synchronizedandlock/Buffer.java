package org.dalvin.synchronizedandlock;

/**
 * Created by qiudeyang on 07/04/17.
 */
class Buffer implements Runnable {
    private Object lock;
    public Buffer(){
        lock = this;
    }
    public void write(){
        synchronized (lock){
            long startTime = System.currentTimeMillis();
            for (;;){
                if (System.currentTimeMillis()-startTime>Integer.MAX_VALUE){
                    break;
                }
            }
            System.out.println("终于写完了");
        }
    }

    public void read(){
        synchronized (lock){
            System.out.println("从buffer读数据");
        }
    }

    public void run(){

    }
}
