package org.dalvin.test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by qiudeyang on 11/04/17.
 */
public class Test {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("qiudeyang", 1);
        map.put("wenbo", 2);
        map.put("linzheng", 3);
        Iterator iter = map.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry<String, Integer> entry = (Map.Entry) iter.next();
            System.out.println(entry.getKey() + "--" + entry.getValue());
        }
    }
}
