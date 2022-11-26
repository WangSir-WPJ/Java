package com.wangpeijie.demo;

import com.wangpeijie.model.Student;
import com.wangpeijie.model.StudentCompareWithName;

import java.util.PriorityQueue;

/**
 * @Author 王珮杰
 * @DateTime 2022/11/17
 */
public class demo6 {
    public static void main(String[] args) {
        //queue的构造
        PriorityQueue<Integer>queue=new PriorityQueue<>();//不带容量的queue
        PriorityQueue<Integer>queue1=new PriorityQueue<>(14);//带容量
        PriorityQueue<Student>queue2=new PriorityQueue<>(new StudentCompareWithName());//带比较器
    }
}
