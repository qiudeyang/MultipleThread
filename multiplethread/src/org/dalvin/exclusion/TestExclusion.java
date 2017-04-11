package org.dalvin.exclusion;

/**
 * Created by qiudeyang on 03/03/17.
 */
class Father{
    public synchronized void doSomething(){
        System.out.println("Father");
    }
}
public class TestExclusion extends Father{
    @Override
    public synchronized void doSomething() {
        super.doSomething();
    }

    public static void main(String[] args) {
        new TestExclusion().doSomething();
    }
}
