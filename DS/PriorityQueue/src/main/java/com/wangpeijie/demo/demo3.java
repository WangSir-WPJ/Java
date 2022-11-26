package com.wangpeijie.demo;

import com.wangpeijie.model.Student;

import java.util.PriorityQueue;

/**
 * @Author 王珮杰
 * @DateTime 2022/11/5
 */
public class demo3 {
    public static void main(String[] args) {
        PriorityQueue<Student>queue=new PriorityQueue<Student>();
        queue.add(new Student("张三",1,18,90));
        //queue.add(new Student("李四",2,19,100));
        System.out.println(queue);
        int i=-200;
        Integer j = new Integer(-200);
        System.out.println(i==j);
        System.out.println(j.equals(i));
        System.out.println("++++++++");
        Object o=new Object(){
            public boolean equals(Object obj){
                return true;
            }
        };
        System.out.println(o.equals("Fred"));
    }

}
