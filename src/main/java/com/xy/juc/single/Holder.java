package com.xy.juc.single;

public class Holder {

    private Holder(){

    }
    public static Holder getInstance(){
        return InnerClass.HOLDER;
    }

    public static class InnerClass{
        private static final Holder HOLDER = new Holder();
    }
}
