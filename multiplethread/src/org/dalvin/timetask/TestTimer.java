package org.dalvin.timetask;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by qiudeyang on 05/04/17.
 */
public class TestTimer implements Runnable {

    public static void main(String[] args) {
        new TestTimer();
    }

    /**
     * 时间调度器
     */
    private final static ScheduledThreadPoolExecutor schedual = new ScheduledThreadPoolExecutor(2, new ThreadFactory() {
        private AtomicInteger atoInteger = new AtomicInteger(0);
        public Thread newThread(Runnable r) {
            Thread t = new Thread(r);
            t.setName("xxx-Thread "+ atoInteger.getAndIncrement());
            return t;
        }
    });

    /**
     * 设置调度shutdown后停止执行任务
     */
    static{
        schedual.setExecuteExistingDelayedTasksAfterShutdownPolicy(false);
        schedual.setContinueExistingPeriodicTasksAfterShutdownPolicy(false);
    }

    /**
     * 执行结果
     */
    private ScheduledFuture<?> scheduledFuture;
    static int count;
    public TestTimer() {
        // scheduledFuture = schedual.schedule(this, 20, TimeUnit.SECONDS); // 20秒后执行
        System.out.println("调度时间："+ timeFormater.format(new Date()));
        schedual.scheduleAtFixedRate(this, 5, 2, TimeUnit.SECONDS); // 5秒后每隔2秒执行一次（不论上次是否执行完毕）

//        try {
//           Thread.sleep(1000);
//         } catch (InterruptedException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//         }
//        schedual.scheduleAtFixedRate(this, 5, 2, TimeUnit.SECONDS); // 5秒后每隔2秒执行一次（不论上次是否执行完毕）

        //scheduledFuture = schedual.scheduleWithFixedDelay(this, 5, 2, TimeUnit.SECONDS); // 5秒后每隔2秒执行一次（在上次执行完毕后开始）
    }

    private final static SimpleDateFormat timeFormater = new SimpleDateFormat("HH:mm:ss:SSS");

    public void run() {
        if(count++ > 5) {
            System.out.println("执行已经满足5次，本次任务取消！");
            //scheduledFuture.cancel(false);  //关闭指定的线程
            schedual.shutdown(); //关闭所有定时任务
            return;
        }
        System.out.println("运行时间："+ timeFormater.format(new Date()));
        System.out.println("当前线程名称："+ Thread.currentThread().getName());
        try{
            TimeUnit.SECONDS.sleep(4);
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("完成时间："+ timeFormater.format(new Date()));
        System.out.println("---------------------------");
    }
}
