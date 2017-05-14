package org.dalvin.test;

/**
 * Created by qiudeyang on 10/05/17.
 */
public class TestStringHashCode {
    public static void main(String[] args) {
        String str = "";
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            str += i;
        }
        System.out.println(System.currentTimeMillis()-start);
        System.out.println(str);
        StringBuilder sb = new StringBuilder();
        long start1 = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            sb.append(i);
        }
        System.out.println(System.currentTimeMillis()-start1);
        System.out.println(sb.toString());
    }
}
