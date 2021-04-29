package com.xy.集合.collection;

import java.util.ArrayList;
import java.util.List;

public class CollectionMethod {
    public static void main(String[] args) {
         List list = new ArrayList<>();
         //add 添加单个元素


         list.add("jack");
         list.add(176); // 自动装箱了，Integer对象
         list.add(true);
         list.add(2);
         //remove
        list.remove(new Integer(2));
        //contains查找元素是否存在
        System.out.println(list.contains("jack"));

        //size :获取元素的个数
        System.out.println(list.size());

        // isEmpty()
        System.out.println(list.isEmpty());

        //clear 清空
//        list.clear();
//        System.out.println(list);

        //addAll 添加多个与元素
        List list2 = new ArrayList();
        list2.addAll(list);
        System.out.println(list2);

        //containsAll 看一个集合是否包含于另一个集合
        System.out.println(list.containsAll(list2));


        //删除和另一个集合重合的所有元素
        list.add("test");
        list2.add("nihao");
        list.removeAll(list2);
        System.out.println(list);
    }
}
