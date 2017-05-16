package org.dalvin.test;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by qiudeyang on 14/05/17.
 */
public class TreeSetTest {
    public static void main(String[] args) {
        Set<String> set = new TreeSet<>();
        set.add("qiudeyang0");
        set.add("qiudeyang1");
        set.add("dalvin0");
        set.add("dalvin1");
        System.out.println("treeset默认顺序");
        Iterator iterator1 = set.iterator();
        while (iterator1.hasNext()){
            System.out.println(iterator1.next());
        }
        Set<String> set1 = new TreeSet<>(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                String temp1 = (String)o1;
                String temp2 = (String)o2;
                return temp2.compareTo(temp1);
            }
        });
        set1.add("qiudeyang0");
        set1.add("qiudeyang1");
        set1.add("dalvin0");
        set1.add("dalvin1");
        System.out.println();
        System.out.println("treeset逆序排列");
        Iterator iterator2 = set1.iterator();
        while (iterator2.hasNext()){
            System.out.println(iterator2.next());
        }

    }
}
