package 集合.set;

import java.util.HashSet;
import java.util.Set;

public class HashSetTest {
    public static void main(String[] args) {
        Set set= new HashSet();
        set.add("tom");
        set.add(new Dog("tom")); //true
        set.add(new Dog("tom")); // true
        System.out.println(set);

        //留一个悬念
        set.add(new String("hs"));//true
        set.add(new String("hs"));//false
        System.out.println(set);
    }
}

class Dog{
    private String name;

    public Dog(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                '}';
    }
}
