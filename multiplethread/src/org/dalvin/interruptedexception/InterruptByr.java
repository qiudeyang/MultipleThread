package org.dalvin.interruptedexception;

/**
 * Created by qiudeyang on 20/04/17.
 */
public class InterruptByr {
    public static void main(String[] args) {
        try{
            Thread thread = new Thread(){
                public void run(){
                    System.out.println(System.currentTimeMillis()+"\t"+Thread.currentThread()+"开始自旋");
                    while (!isInterrupted()){

                    }
                    System.out.println(System.currentTimeMillis()+"\t"+Thread.currentThread()+"被中断，结束自旋");
                }
            };
            thread.start();
//            Thread.sleep(1000);
            thread.interrupt();
            System.out.println(System.currentTimeMillis()+"\t"+thread.isInterrupted());

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
