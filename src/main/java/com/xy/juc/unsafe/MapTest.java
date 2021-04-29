package com.xy.juc.unsafe;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MapTest {

    public static void main(String[] args) {
        // map 是这样用的吗
        Map<String, String> map = new ConcurrentHashMap();
    }
}
