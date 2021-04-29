package com.xy.集合.map;

import java.util.HashMap;
import java.util.Map;

public class MapMethod {
    public static void main(String[] args) {
        Map map = new HashMap();
        map.put("no1","xy");
        map.put("no2","xy2");
        map.put("no3","xy2");
        //移除
        map.remove("no1");
        //获取key对应的value
        Object no2 = map.get("no2");
        System.out.println(no2);
        // map里的元素个数
        System.out.println(map.size());
        //判断个数是否为0
        System.out.println(map.isEmpty());
        // 查看是否有指定的key
        System.out.println(map.containsKey("no2"));
        // 清空
        map.clear();
        System.out.println(map);
    }
}
