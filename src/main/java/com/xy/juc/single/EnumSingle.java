package com.xy.juc.single;

import java.lang.reflect.Constructor;

// enum 本身也是一个class类
public enum  EnumSingle {
    INSTANCE;
    public EnumSingle getInstance(){
        return INSTANCE;
    }
}

//反射不能破坏枚举
class Test{
    public static void main(String[] args) throws Exception {
        EnumSingle instance1 = EnumSingle.INSTANCE;
        Constructor<EnumSingle> declaredConstructor = EnumSingle.class.getDeclaredConstructor(null);
        declaredConstructor.setAccessible(true);
        EnumSingle instance2 = declaredConstructor.newInstance();
        //报错 NoSuchMethodException: com.xy.juc.single.EnumSingle.<init>()
        System.out.println(instance1);
        System.out.println(instance2);
    }
}