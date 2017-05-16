package org.dalvin.test;

import java.util.HashSet;

/**
 * Created by qiudeyang on 14/05/17.
 */
class Person2 {
    private String name;
    private int age;
    public Person2(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o.getClass() == Person2.class) {
            Person2 per = (Person2) o;
            return this.name.equals(per.name);
        }
        return false;
    }
    public int hashCode(){
        return name.hashCode();
    }
}
public class HashSetTest3 {
    public static void main(String[] args) {
        HashSet<Person2> set=new HashSet<>();
        set.add(new Person2("wm",12));
        System.out.println(set.contains(new Person2("wm",123)));
    }
}
