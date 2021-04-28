package 集合.set;

import java.util.HashSet;

public class HashSetStructure {
    public static void main(String[] args) {
        //模拟一个HashSet的底层，其实也就是HashMap的底层

        //1.创建一个数组，数组的类型是Node[]
        Node[] table = new Node[16];
        Node jop = new Node("jop", null);
        Node jso = new Node("jso", null);
        table[2] =jop ;
        jop.next = jso;

        HashSet
        System.out.println(table);

    }
}

class Node{
    //存储数据，可以指向下一个节点
    Object item;
    Node next;

    public Node(Object item, Node next) {
        this.item = item;
        this.next = next;
    }
}
