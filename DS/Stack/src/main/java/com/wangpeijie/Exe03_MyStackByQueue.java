package com.wangpeijie;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 队列实现栈
 * @Author 比特就业课
 * @Date 2022-10-19
 */
public class Exe03_MyStackByQueue {
    // 定义两个队列
    Queue<Integer> inQueue;
    Queue<Integer> outQueue;

    public Exe03_MyStackByQueue() {
// 把队列进行初始化
        inQueue = new LinkedList<>();
        outQueue = new LinkedList<>();
    }

    public void push(int x) {
    // 直接入队
        inQueue.offer(x);
    // 把outQueue中的元素出队并入队到inQueue里
        while(outQueue.isEmpty()){
            inQueue.offer(outQueue.poll());
        }
    // inQueue和outQueue互换
        Queue temp=inQueue;
        inQueue=outQueue;
        outQueue=temp;
    }

    public int pop() {
        return -1;
    }

    public int top() {
        return -1;
    }

    public boolean empty() {
        return false;
    }
}
