package 集合.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class HashMapTest {
    public static void main(String[] args) {
        Map map = new HashMap();
        for (int i = 0; i < 12; i++) {
            map.put(new A(i), i);
        }

        System.out.println(map);

    }
}

class A{
    private int num;

    public A(int num) {
        this.num = num;
    }

    @Override
    public int hashCode() {
        return 100;
    }

    @Override
    public String toString() {
        return "A{" +
                "num=" + num +
                '}';
    }
}
