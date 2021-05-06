package com.xy.集合.set;

import sun.reflect.generics.tree.Tree;

import java.util.TreeSet;

public class TreeSetTest {
    public static void main(String[] args) {
//        TreeSet set=  new TreeSet();
//        set.add("jack");
//        set.add("ack");
//        set.add("back");
//        set.add("qick");
//        System.out.println(set);

        // 自定义排序规则
        /**
         * 传入Compare这个匿名内部类
         * 比较方式由这个类里的compare(object 01,object 02)方法进行确定
         */

        TreeSet set2 = new TreeSet((o1,o2)->{
            return ((String) o2).compareTo((String) o1);
        });
        set2.add(null);
        set2.add("jack");
        set2.add("ack");
        set2.add("back");
        set2.add("qick");
        System.out.println(set2);
        }
}
