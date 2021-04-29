package com.xy.集合.set;

import java.util.LinkedHashSet;

public class LinkedHashSetTest {
    public static void main(String[] args) {
        LinkedHashSet set = new LinkedHashSet();
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(3);
        System.out.println(set);
    }
    /**
     * 第一次添加时，直接将数组table扩容到16，存放的节点类型是LinkedHashMap&Entry
     */
}
