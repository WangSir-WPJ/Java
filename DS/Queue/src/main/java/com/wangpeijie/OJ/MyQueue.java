package com.wangpeijie.OJ;

import java.util.Stack;

/**
 * 用栈实现队列
 * @Author 王珮杰
 * @DateTime 2022/10/25
 */
public class MyQueue {
    Stack<Integer>inStack;
    Stack<Integer>outStack;

    /**
     * 初始化
     */
    public MyQueue() {
        inStack=new Stack<>();
        outStack=new Stack<>();
    }

    /**
     * 入队
     * @param x
     */
    public void push(int x) {
        inStack.push(x);
    }

    /**
     * 出队
     * @return
     */
    public int pop() {
        if (empty()){
            return -1;
        }
        if (outStack.empty()){
            while(!inStack.isEmpty()){
                outStack.push(inStack.pop());
            }
        }

        return outStack.pop();
    }

    public int peek() {
        if (empty()){
            return -1;
        }
        if (outStack.empty()){
            while(!inStack.isEmpty()){
                outStack.push(inStack.pop());
            }
        }

        return outStack.peek();
    }

    public boolean empty() {
        return inStack.isEmpty()&& outStack.empty();
    }
}
