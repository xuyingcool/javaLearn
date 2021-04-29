package com.xy.集合.set;

import java.util.HashSet;
import java.util.Set;

public class HashSetTest {
    public static void main(String[] args) {
        Set set = new HashSet();

        set.add("java");
        set.add("php");
        set.add("java");
        set.add("java");
        System.out.println(set);
    }
}
