package com.wangpeijie.demo;

import com.wangpeijie.MyQueue;

/**
 * 测试模拟队列
 * @Author 王珮杰
 * @DateTime 2022/10/21
 */
public class demo2 {
    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        System.out.println("是否为空： "+queue.isEmpty());
        System.out.println("size = "+queue.size);
        queue.offer(12);
        queue.offer(23);
        queue.offer(34);
        queue.offer(45);
        queue.offer(56);
        System.out.println("是否为空： "+queue.isEmpty());
        System.out.println("size = "+queue.size);
        queue.display();
        System.out.println("出队");
        System.out.println("size = "+queue.size);
        queue.display();
        System.out.println("poll "+queue.poll());
        System.out.println("size = "+queue.size);
        queue.display();
        System.out.println("peek "+queue.peek());
        System.out.println("size = "+queue.size);
        queue.display();
    }
}
