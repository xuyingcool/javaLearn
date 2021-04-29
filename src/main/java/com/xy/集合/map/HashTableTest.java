package com.xy.集合.map;

import java.util.Hashtable;
import java.util.Map;

public class HashTableTest {
    public static void main(String[] args) {
        Map map = new Hashtable();
        for (int i = 0; i < 9; i++) {
            map.put(""+i, i);
        }
    }
}
