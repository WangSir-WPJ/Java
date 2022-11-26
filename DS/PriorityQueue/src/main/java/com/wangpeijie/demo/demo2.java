package com.wangpeijie.demo;

import java.util.PriorityQueue;

/**
 * @Author 王珮杰
 * @DateTime 2022/11/5
 */
public class demo2 {
    public static void main(String[] args) {
        PriorityQueue<Integer>queue=new PriorityQueue<>();
        //添加数据
        queue.add(12);
        queue.add(23);
        queue.add(8);
        queue.add(108);
        queue.add(86);
        //默认小根堆
        System.out.println(queue);


    }
}
