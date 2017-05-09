package org.dalvin.threadlocal;

/**
 * Created by qiudeyang on 09/05/17.
 */
public class TestThreadLocal {
    ThreadLocal<Long> longLocal = new ThreadLocal<Long>(){
        protected Long initialValue(){
            return Thread.currentThread().getId();
        }
    };
    ThreadLocal<String> stringLocal = new ThreadLocal<String>(){
        protected String initialValue(){
            return Thread.currentThread().getName();
        }
    };

    public void set() {
        longLocal.set(Thread.currentThread().getId());
        stringLocal.set(Thread.currentThread().getName());
    }

    public long getLong() {
        return longLocal.get();
    }

    public String getString() {
        return stringLocal.get();
    }

    public static void main(String[] args) throws InterruptedException {
        TestThreadLocal test = new TestThreadLocal();
//        test.set();
        System.out.println(test.getLong());
        System.out.println(test.getString());

        Thread thread = new Thread() {
            public void run() {
                test.set();
                System.out.println(test.getLong());
                System.out.println(test.getString());
            }
        };
        thread.start();
        thread.join();
        System.out.println(test.getLong());
        System.out.println(test.getString());
    }
}
