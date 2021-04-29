package com.xy.集合.list_;

import java.util.ArrayList;
import java.util.List;

public class ListMethod {
    public static void main(String[] args) {
        // 左边是编译类型
        List list = new ArrayList();
        list.add("张三分");
        list.add("贾宝玉");
        // add(index,element)在索引位置添加元素
        list.add(1,"xy");

        //addAll(index,Collection)，在索引位置添加多个元素
        list.addAll(1,new ArrayList());
        //get(index)获取index位置的元素
        //indexOf(element) 返回元素第一次出现的index
        list.indexOf("贾宝玉");

        //lastIndexOf(element) 元素最后一次出现的index
        list.lastIndexOf("贾宝玉");


        // set(index,NewElement)  替换index位置的元素
        list.set(0,"替换");
        System.out.println(list);

        // subList(start,end) 返回index为[start,end)的元素集合
        List list1 = list.subList(0, 2);
        System.out.println(list1);
    }
}
