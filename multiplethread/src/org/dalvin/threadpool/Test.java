package org.dalvin.threadpool;

import java.util.Date;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by qiudeyang on 04/03/17.
 */
class MyTask implements Runnable {
    private int taskNum;

    public MyTask(int num) {
        this.taskNum = num;
    }

    public void run() {
        System.out.println(new Date()+" running task " + taskNum);
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(new Date()+" task "+taskNum+" done");
    }
}

public class Test {
    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(5,10,200, TimeUnit.MILLISECONDS,new ArrayBlockingQueue<Runnable>(5));
        for (int i = 0; i < 15; i++) {
            MyTask myTask = new MyTask(i);
            executor.execute(myTask);
            System.out.println("先线程池中线程数目: "+executor.getPoolSize()+" 队列中等待执行的任务数目: "+executor.getQueue().size()+" 已执行完的任务数目: "+executor.getCompletedTaskCount());
        }
        executor.shutdown();
    }
}
