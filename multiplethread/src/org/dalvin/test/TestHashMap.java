package org.dalvin.test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by qiudeyang on 12/04/17.
 */
public class TestHashMap {
    public static void main(String[] args) {
        Map<String,Integer> map = new HashMap<String, Integer>();
        map.put("语文",1);
        map.put("数学",2);
        map.put("英语",3);
        map.put("历史",4);
        map.put("政治",5);
        map.put("地理",6);
        map.put("生物",7);
        map.put("化学",8);
        Iterator iter = map.entrySet().iterator();
        while (iter.hasNext()){
            Map.Entry<String,Integer> entry = (Map.Entry)iter.next();
            System.out.println(entry.getKey()+"--"+entry.getValue());
        }
    }
}
