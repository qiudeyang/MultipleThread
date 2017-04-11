package org.dalvin.threadcommunicate;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by qiudeyang on 30/03/17.
 */
class MyList{
    private List<String> list = new LinkedList<String>();
    public void add(){
        list.add("element");
    }
    public int size(){
        return list.size();
    }
}
class ThreadC extends Thread{
    private MyList list;

    public ThreadC(MyList list){
        this.list = list;
    }
    public void run(){
        try {
            for (int i = 0; i < 10; i++) {
                list.add();
                System.out.println("添加了"+(i+1)+"个元素");
                Thread.sleep(1000);
            }
            System.out.println("A done");
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
class ThreadD extends Thread{
    private MyList list;

    public ThreadD(MyList list){
        this.list = list;
    }

    public void run(){
        try{
            while (true){
                if (list.size()==5){
                    System.out.println("线程b准备退出了");
                    throw new InterruptedException();
                }
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

}

public class TestWhile {
    public static void main(String[] args) {
        MyList myList = new MyList();

        ThreadC a = new ThreadC(myList);
        a.setName("A");
        a.start();

        ThreadD b  = new ThreadD(myList);
        b.setName("B");
//        b.start();
    }
}
