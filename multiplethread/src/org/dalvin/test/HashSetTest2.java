package org.dalvin.test;

import java.util.HashSet;

/**
 * Created by qiudeyang on 14/05/17.
 */
class Person1 {
    private String name;
    private int age;
    public Person1(String name, int age){
        this.name=name;
        this.age=age;
    }
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o.getClass() == Person1.class) {
            Person1 per = (Person1) o;
            return this.age == per.age && this.name.equals(per.name);
        }
        return false;
    }
}
public class HashSetTest2 {
    public static void main(String[] args) {
        HashSet<Person1> set=new HashSet<>();
        set.add(new Person1("wm",12));
        System.out.println(set.contains(new Person1("wm",123)));
    }
}
