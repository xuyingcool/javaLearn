package com.xy.集合.map;

import java.util.TreeMap;

public class TreeMapTest {
    public static void main(String[] args) {
        TreeMap treeMap = new TreeMap();
        treeMap.put(null,"null");
        treeMap.put("jack","杰克");
        treeMap.put("tom","汤姆");
        treeMap.put("tom","汤姆_test");

        System.out.println(treeMap);
    }
}
