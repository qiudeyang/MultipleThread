package org.dalvin.test;

import java.util.HashSet;

/**
 * Created by qiudeyang on 14/05/17.
 */
class Person {
    private String name;
    private int age;
    public Person(String name, int age){
        this.name=name;
        this.age=age;
    }
}
public class HashSetTest1 {
    public static void main(String[] args) {
        HashSet<Person> set=new HashSet<>();
        set.add(new Person("wm",12));
        System.out.println(set.contains(new Person("wm",123)));
    }
}
