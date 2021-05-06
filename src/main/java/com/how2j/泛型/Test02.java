package com.how2j.泛型;

import java.util.ArrayList;

public class Test02 {
    public static void main(String[] args) {
        ArrayList<Hero> hs = new ArrayList<>();
        ArrayList<APHero> aphs = new ArrayList<>();
        ArrayList<ADHero> adhs = new ArrayList<>();
        iterate();
    }
    static void iterate(ArrayList<? extends Hero> list){
        for (Hero hero : list) {
            System.out.println(hero);
        }
    }
}
