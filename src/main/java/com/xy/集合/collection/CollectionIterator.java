package com.xy.集合.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CollectionIterator {
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add(new Book("caiji",11));
        list.add(new Book("xuih",981));
        list.add(new Book("caioashoiiji",12));
        list.add("javc");
        Iterator iterator = list.iterator();
        iterablePrint(iterator);

        System.out.println("======");
        forPrint(list);

        // itit快捷生成迭代器模板
        // ctrl+j 可以查看快捷键
    }
    public static void forPrint(List list){
        for (Object book : list) {
            System.out.println(book);
        }
    }

    public static void iterablePrint(Iterator iterator){
        while (iterator.hasNext()){
            Object obj = iterator.next(); //返回的元素类型是Object
            System.out.println(obj);
        }
    }
}
class Book{
    private String name;
    private int price;

    public Book(String name, int price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}

