package com.xy.集合.list_;

import java.util.ArrayList;
import java.util.List;

public class List_ {
    public static void main(String[] args) {
        List list = new ArrayList();
        //1.list集合类中元素有序（添加和取出的顺序一致），且可以重复
        list.add("jav");
        list.add("das");
        list.add("das");
        list.add("daoj");
        System.out.println(list);
        //2、list里的元素是有索引的
        System.out.println(list.get(3)); // das

        //3.List接口的实现类很多
    }
}
