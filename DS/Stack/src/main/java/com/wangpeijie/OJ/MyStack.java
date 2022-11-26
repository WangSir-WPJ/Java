package com.wangpeijie.OJ;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 用两个队列实现栈
 * @Author 王珮杰
 * @DateTime 2022/10/25
 */
public class MyStack {
    //定义2个队列
    Queue<Integer>inQueue;
    Queue<Integer>outQueue;
    public MyStack() {
        inQueue=new LinkedList<>();
        outQueue=new LinkedList<>();
    }

    public void push(int x) {
        //入队
        inQueue.offer(x);
        //两个队列，一个入一个出
        //判断outQueue是否为空
        while(!outQueue.isEmpty()){
            inQueue.offer(outQueue.poll());
        }
        Queue<Integer>temp=outQueue;
        outQueue=inQueue;
        inQueue=temp;
    }

    public int pop() {
        return outQueue.poll();
    }

    public int top() {
        return outQueue.peek();
    }

    public boolean empty() {
        return inQueue.isEmpty()&&outQueue.isEmpty();
    }
}
