package com.xy.集合.set;

import java.util.HashSet;
import java.util.Objects;

/**
 * 所有元素的hashcode都相同，但是元素内容不同的情况
 */
public class HashSetEqHash {
    public static void main(String[] args) {
        HashSet set = new HashSet();

        for (int i = 0; i < 120; i++) {
            set.add(new A(i));
        }
        System.out.println();
    }
}

class A{
    private int n;

    public A(int n) {
        this.n = n;
    }


    @Override
    public int hashCode() {
        return 100;
    }
}