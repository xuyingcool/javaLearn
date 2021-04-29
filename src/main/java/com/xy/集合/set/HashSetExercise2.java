package com.xy.集合.set;

import java.util.HashSet;
import java.util.Objects;

public class HashSetExercise2 {
    public static void main(String[] args) {
        HashSet set = new HashSet();
        set.add(new Employee2("xy",12,new MyDate(2011,12,3)));
        set.add(new Employee2("xy",12,new MyDate(2011,12,3)));
        set.add(new Employee2("xy3",12,new MyDate(2011,12,3)));
        System.out.println(set);
        }

}

class Employee2{
    private String name;
    private int sal;
    private MyDate birthday;

    @Override
    public String toString() {
        return "Employee2{" +
                "name='" + name + '\'' +
                ", sal=" + sal +
                ", birthday=" + birthday +
                '}';
    }

    public Employee2(String name, int sal, MyDate birthday) {
        this.name = name;
        this.sal = sal;
        this.birthday = birthday;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee2 employee2 = (Employee2) o;
        return Objects.equals(name, employee2.name) &&
                Objects.equals(birthday, employee2.birthday);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, birthday);
    }
}

class MyDate{
    private int year;
    private int month;
    private int day;

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyDate myDate = (MyDate) o;
        return year == myDate.year &&
                month == myDate.month &&
                day == myDate.day;
    }

    @Override
    public String toString() {
        return  year +"_"
                + month +"_"
               + day
                ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, month, day);
    }
}