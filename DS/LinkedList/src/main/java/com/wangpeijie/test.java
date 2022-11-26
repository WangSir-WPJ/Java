package com.wangpeijie;


public class test {

    public static void main(String[] args) {

        SingleLinkedList singleLinkedList=new SingleLinkedList();
        singleLinkedList.addFirst(12);
        singleLinkedList.addFirst(23);
        singleLinkedList.addFirst(34);
        singleLinkedList.addFirst(45);
        singleLinkedList.addFirst(56);
        System.out.println("===========测试头插=============");
        singleLinkedList.display();
        System.out.println("===========计算长度=============");
        System.out.println(singleLinkedList.size());
        System.out.println("===========寻找关键字=============");
        System.out.println(singleLinkedList.contains(34));
        System.out.println(singleLinkedList.contains(66));
        System.out.println("===========测试删除第一次出现的关键字=============");
        singleLinkedList.remove(12);
        singleLinkedList.display();
        System.out.println("===========测试在中间插入=============");
        singleLinkedList.addIndex(0,45);
        singleLinkedList.addIndex(2,45);
        singleLinkedList.addIndex(6,45);
        singleLinkedList.display();
        System.out.println(singleLinkedList.size());
        System.out.println("===========测试删除出现的所有关键字=============");
        singleLinkedList.removeAllKey(45);
        singleLinkedList.display();
        System.out.println(singleLinkedList.size());
        System.out.println("===========测试清除链表=============");
        //singleLinkedList.clear();
        singleLinkedList.display();
        System.out.println(singleLinkedList.size());
        singleLinkedList.printList();

    }
}
