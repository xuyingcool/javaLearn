package com.xy.集合.Collecitions_;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionsMethod {
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("tom");
        list.add("tom");
        list.add("simit");
        list.add("king");
        list.add("milan");
        System.out.println(list);

        // 反转
        System.out.println("反转");
        Collections.reverse(list);
        System.out.println(list);

        // 打乱顺序
        System.out.println("随机打乱顺序");
        Collections.shuffle(list);
        System.out.println(list);

        // 排序
        System.out.println("排序之后");
        Collections.sort(list);
        System.out.println(list);
        // 这个可以放一个比较器控制sort
//        Collections.sort(list,(o1,o2)->{
//            return 1;
//        });

        // 交换
        System.out.println("交换0、1出的元素");
        Collections.swap(list,0,1);
        System.out.println(list);

        //自然顺序的最大元素
        System.out.println(Collections.max(list));
        // 也可以放一个比较器进去，控制比较
        // 长度最大的
        Collections.max(list,(o1,o2)->{
            return ((String)o1).length() - ((String)o2).length();
        });

        //最小,和上面一样
        Collections.min(list);

        //出现的次数
        System.out.println("tom 出现的次数"+Collections.frequency(list, "tom"));

        // 拷贝
        ArrayList newList = new ArrayList();
        // 这里的newLIst不能直接拷贝list，因为copy源码里面要比较两个list的size
        // 如果newList里面存的元素小于list，就抛出异常
        // 这里copy的话需要先往newLIst里面填充list长度的元素
//        Collections.copy(newList,list);
//        System.out.println(newList);

        // 替换,将原来的值查看有没有，如果有的话就替换成tom
        Collections.replaceAll(list,"tom","汤姆");
    }
}
