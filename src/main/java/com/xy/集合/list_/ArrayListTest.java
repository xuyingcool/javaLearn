package com.xy.集合.list_;

import java.util.ArrayList;
import java.util.List;

public class ArrayListTest {
    public static void main(String[] args) {

        List list = new ArrayList(4);
        list.add(1);
        for (int i = 0; i < 4; i++) {
            list.add(i);
        }
        list.add(1);
        System.out.println(list);
    }
}
