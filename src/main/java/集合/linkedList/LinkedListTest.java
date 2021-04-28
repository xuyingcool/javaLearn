package 集合.linkedList;

import java.util.LinkedList;

public class LinkedListTest {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        // 有三种remove，这里是删除第一个

        linkedList.remove();
        linkedList.set(1,4);

        linkedList.get(1);
        linkedList.getFirst();
        linkedList.getLast();
        System.out.println(linkedList);
    }
}
