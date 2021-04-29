package com.xy.juc.stream;

import java.util.Arrays;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        User user1 = new User(1, "a", 21);
        User user2 = new User(2, "b", 22);
        User user3 = new User(3, "c", 23);
        User user4 = new User(4, "d", 24);
        User user5 = new User(6, "e", 25);

        List<User> list = Arrays.asList(user1, user2, user3, user4, user5);
        list.stream()
                .filter((user)->{return user.getId()%2==0; })  // 过滤,
                .filter(u->{return u.getAge()>23;})         // filter(Predicate<? super T> predicate);
                .map((u)->{u.setName(u.getName().toUpperCase());return u;}) //map匹配  map(Function<? super T, ? extends R> mapper);
                .sorted((uu1,uu2)->{return uu2.getName().compareTo(uu1.getName());}) // 排序sorted(Comparator<? super T> comparator);
                .limit(1)  //输出数量
                .forEach(System.out::println);
    }
}
