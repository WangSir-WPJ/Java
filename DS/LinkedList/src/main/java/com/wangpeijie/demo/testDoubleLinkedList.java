package com.wangpeijie.demo;

import com.wangpeijie.DoubleLinkedList;

/**
 * 双向链表的测试
 *
 * @Author 王珮杰
 * @DateTime 2022/10/18
 */
public class testDoubleLinkedList {
    public static void main(String[] args) {
        DoubleLinkedList doubleLinkedList1 = new DoubleLinkedList();
        doubleLinkedList1.addLast(12);
        doubleLinkedList1.addLast(23);
        doubleLinkedList1.addLast(34);
        doubleLinkedList1.addLast(45);
        doubleLinkedList1.addLast(56);
        System.out.println("测试尾插");
        doubleLinkedList1.display();
        //添加元素至某个位置
        System.out.println("测试添加元素至某个位置");
        doubleLinkedList1.addIndex(2, 25);
        doubleLinkedList1.display();
        //查找某个元素
        System.out.println("测试查找某个元素");

        System.out.println(doubleLinkedList1.contains(23));
        System.out.println(doubleLinkedList1.contains(66));
        //删除元素
        //doubleLinkedList1.addFirst(12);
        //doubleLinkedList1.remove(12);
        doubleLinkedList1.display();
        System.out.println("====================");
        System.out.println("删除元素");
        doubleLinkedList1.addLast(67);
        doubleLinkedList1.addLast(12);
        doubleLinkedList1.addLast(12);
        /*doubleLinkedList1.remove(67);
        doubleLinkedList1.display();
        doubleLinkedList1.remove(12);
        doubleLinkedList1.display();
        doubleLinkedList1.remove(12);
        doubleLinkedList1.display();

        doubleLinkedList1.remove(12);
        doubleLinkedList1.display();*/

        doubleLinkedList1.removeAllKey(12);
        doubleLinkedList1.display();
        doubleLinkedList1.clear();
        doubleLinkedList1.display();

    }
}
