package com.xy.集合.map;

import java.util.*;

public class MapFor {
    public static void main(String[] args) {
        Map map = new HashMap();
        map.put("xy","xuying");
        map.put("xy1","xuying1");
        map.put("xy2","xuying2");

        key_for(map);
    }


    // 取出所有的key，通过key取出value
    static void key_for(Map map){
        Set keySet = map.keySet();
        //1、增强for
        for (Object key : keySet) {
            System.out.println(key+"-"+map.get(key));
        }

        System.out.println("--------迭代器");
        Iterator iterator = keySet.iterator();
        //2、迭代器
        while (iterator.hasNext()) {
            Object key =  iterator.next();
            System.out.println(key+"-"+map.get(key));
        }
    }

    // 直接取出所有的value
    static void value_for(Map map){
        Collection values = map.values();
        // 这里可以使用Collection的遍历方式,增强for循环和迭代器

        // 3、
        for (Object value : values) {
            System.out.println(value);
        }

        // 4、
        Iterator iterator = values.iterator();
        while (iterator.hasNext()) {
            Object value =  iterator.next();
            System.out.println(value);
        }
    }


    static void entry_for(Map map){
        // 5、
        System.out.println("---entrySet的增强for方法");
        Set entrySet = map.entrySet();
        for (Object entry : entrySet) {
            Map.Entry m = (Map.Entry) entry;
            System.out.println(m.getKey()+"-"+m.getValue());
        }

        // 6、
        System.out.println("---entrySet的迭代器");
        Iterator iterator = entrySet.iterator();
        while (iterator.hasNext()) {
            // 这个节点的类型是HashMap$Node，可以向下转型成Map.Entry，因为这个有getKey 和getValue的方法
            Map.Entry entry = (Map.Entry) iterator.next();
            System.out.println(entry.getKey()+"-"+entry.getValue());
        }
    }
}
