package com.wangpeijie.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;


/**
 * @Author 王珮杰
 * @DateTime 2022/11/17
 */
public class demo5 {
    public static void main(String[] args) {
        List<Integer> list=new ArrayList<>();
        list.add(12);
        list.add(23);
        list.add(34);
        list.add(45);
        list.add(56);
        PriorityQueue<Integer>queue=new PriorityQueue<>(list);
        System.out.println(queue);
    }

}
