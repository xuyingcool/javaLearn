package 集合.set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetMethod {
    public static void main(String[] args) {
        Set set = new HashSet();
        set.add("jopn");
        set.add("jopn");
        set.add(null);
        set.add(null);
        set.add("xuying");

        System.out.println(set);

        for (Object o : set) {
            System.out.println(o);
        }
    }
}
