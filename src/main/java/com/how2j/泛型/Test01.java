package com.how2j.泛型;

import java.util.ArrayList;
import java.util.List;

public class Test01 {
    public static void main(String[] args) {

      test1();

    }
    // 测试?super
    static void test1(){
        ArrayList<? super Hero> heroList = new ArrayList<Object>();

        //? super Hero 表示 heroList的泛型是Hero或者其父类泛型

        //heroList 的泛型可以是Hero
        //heroList 的泛型可以是Object

        //所以就可以插入Hero
        heroList.add(new Hero());
        //也可以插入Hero的子类
        heroList.add(new APHero());
        heroList.add(new ADHero());

        //但是，不能从里面取数据出来,因为其泛型可能是Object,而Object是强转Hero会失败
        Hero h= (Hero) heroList.get(0);
    }

    static void test2(){
        ArrayList<APHero> apHeroList = new ArrayList<APHero>();

        //?泛型通配符，表示任意泛型
        ArrayList<?> generalList = apHeroList;

        //?的缺陷1： 既然?代表任意泛型，那么换句话说，你就不知道这个容器里面是什么类型
        //所以只能以Object的形式取出来
        Object o = generalList.get(0);

        //?的缺陷2： 既然?代表任意泛型，那么既有可能是Hero,也有可能是Item
        //所以，放哪种对象进去，都有风险，结果就什么什么类型的对象，都不能放进去
//        generalList.add(new Item()); //编译错误 因为?代表任意泛型，很有可能不是Item
//        generalList.add(new Hero()); //编译错误 因为?代表任意泛型，很有可能不是Hero
//        generalList.add(new APHero()); //编译错误  因为?代表任意泛型，很有可能不是APHero
    }
}

class Hero{
    public Hero() {
    }
}

class APHero extends Hero{

}
class ADHero extends Hero{

}
class Item{

}