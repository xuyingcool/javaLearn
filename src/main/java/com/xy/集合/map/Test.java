package com.xy.集合.map;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Test {
    public static void main(String[] args) {
        Map map = new HashMap<>();
        map.put("1","xy");
        map.put(new N(),new P());
        map.put("3","xy2");
        Set set = map.keySet();
        Collection value = map.values();
        System.out.println(set);
        System.out.println(map);

        /**
         * 1.key - value 实际上是HashMap$Node节点里的元素
         * 2.k-v为了方便程序员遍历，还创建了EntrySet集合，这个集合存放的元素类型为Entry
         * 一个Entry对象就有 k,v   transient Set<Map.Entry<K,V>> entrySet;
         * 3.entrySet中，定义的类型是Map.Entry。但是实际存放的还是HashMap$Node，因为这个node实现了Entry
         * 4.把HashMap$Node对象存放到entrySet 方便我们遍历，因为Map.Entry 提供了重要方法 getKey()，getValue
         */
    }
}
class N{

}
class P{

}
