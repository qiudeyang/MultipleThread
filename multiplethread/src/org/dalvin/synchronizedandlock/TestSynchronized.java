package org.dalvin.synchronizedandlock;

/**
 * Created by qiudeyang on 07/04/17.
 */
public class TestSynchronized {
    public static void main(String[] args) {
        System.out.println(new TestSynchronized().increase());
    }
    public int increase(){
        int count = 0;
        synchronized (this){
            int result = ++ count;
            return result;
        }
    }
}
