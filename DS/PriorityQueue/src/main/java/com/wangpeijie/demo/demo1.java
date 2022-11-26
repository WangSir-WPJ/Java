package com.wangpeijie.demo;

import com.wangpeijie.Head;

/**
 * @Author 王珮杰
 * @DateTime 2022/11/3
 */
public class demo1 {
    public static void main(String[] args) {
        int []array={ 27,15,19,18,28,34,65,49,25,37 };
        Head head=new Head(array);
        head.offer(100);
        System.out.println(head.poll());
        System.out.println(head.poll());
        head.display();
        System.out.println(head.peek());
    }
}
