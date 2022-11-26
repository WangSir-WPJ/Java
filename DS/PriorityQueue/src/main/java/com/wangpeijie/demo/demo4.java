package com.wangpeijie.demo;

import com.wangpeijie.model.Student;
import com.wangpeijie.model.StudentCompareWithAge;
import com.wangpeijie.model.StudentCompareWithName;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Author 王珮杰
 * @DateTime 2022/11/7
 */
public class demo4 {
    public static void main(String[] args) {
        Student s1=new Student("王五",1,20,90);
        Student s2=new Student("张三",1,20,90);
        System.out.println(s1==s2);//比较地址
        System.out.println(s1.equals(s2));
        System.out.println(s1.compareTo(s2));


        //String类型实现了comparable接口，可以直接放入PriorityQueue中
        PriorityQueue<Student>queue=new PriorityQueue<>(new StudentCompareWithName());
        queue.offer(s1);
        queue.offer(s2);
        System.out.println(queue);
    }
}
