package org.dalvin.test;

/**
 * Created by qiudeyang on 15/05/17.
 */
public class ToString {
    public static void main(String[] args) {
        int loopTime = 50000;
        Integer i = 0;
        long startTime = System.currentTimeMillis();
        for (int j = 0; j < loopTime; j++) {
            String str = i.toString();
        }
        System.out.println("Integer.toString(): "+(System.currentTimeMillis()-startTime)+" ms");

        startTime = System.currentTimeMillis();
        for (int j = 0; j < loopTime; j++) {
            String str = String.valueOf(j);
        }
        System.out.println("String.valueOf(): "+(System.currentTimeMillis()-startTime)+" ms");

        startTime = System.currentTimeMillis();
        for (int j = 0; j < loopTime; j++) {
            String str = j+"";
        }
        System.out.println("i+\"\": "+(System.currentTimeMillis()-startTime)+" ms");
    }
}
