package org.dalvin.threadcommunicate;

/**
 * Created by qiudeyang on 30/03/17.
 */
class MyObject{
    public synchronized void methodA(){
        System.out.println(System.currentTimeMillis()+" methodA");
    }
    public synchronized void methodB(){
        System.out.println(System.currentTimeMillis()+" methodB");
    }
}
class ThreadA extends Thread{
    private MyObject object;

    public ThreadA(MyObject object){
        this.object = object;
    }
    public void run(){
        object.methodA();
    }
}
class ThreadB extends Thread{
    private MyObject object;

    public ThreadB(MyObject object){
        this.object = object;
    }
    public void run(){
        object.methodB();
    }
}
public class TestSynchronized {
    public static void main(String[] args) {
        MyObject myObject = new MyObject();
        ThreadA threadA = new ThreadA(myObject);
        ThreadB threadB = new ThreadB(myObject);
        threadA.start();
        threadB.start();
    }
}
