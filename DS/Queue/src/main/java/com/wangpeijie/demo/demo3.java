package com.wangpeijie.demo;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 队列的实现
 * @Author 王珮杰
 * @DateTime 2022/10/26
 */
public class demo3 {
    public static void main(String[] args) {
        //Queue是个接口，在实例化时必须实例化LinkedList的对象，因为LinkedList实现了Queue接口
        Queue<Integer>queue=new LinkedList<>();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);
        queue.offer(5);
        System.out.println(queue.size());
        System.out.println("队头元素"+queue.peek());
        System.out.println("出队"+queue.poll());
        if (queue.isEmpty()){
            System.out.println("队空");
        }else {
            System.out.println(queue.size());
        }
    }
}
