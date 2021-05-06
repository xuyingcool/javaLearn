package com.xy.集合.map;

import java.util.Properties;

public class PropertiesTest {
    public static void main(String[] args) {
        Properties properties = new Properties();
        // 增加和修改
        properties.put("jopn",100);
        properties.put("jopn",10);  // 有相同的key，值就是替换
        properties.put("jopn2",10);
        System.out.println(properties);

        // 如何获取对应的值,查找
        properties.get("jopn");
        //删除
        properties.remove("jopn2");
        System.out.println(properties);
    }
}
