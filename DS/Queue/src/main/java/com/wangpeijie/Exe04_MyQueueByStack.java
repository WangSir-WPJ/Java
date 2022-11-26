package com.wangpeijie;

import java.util.Stack;

/**
 * 用栈实现队列
 *
 * @Author 比特就业课
 * @Date 2022-10-19
 */
public class Exe04_MyQueueByStack {
    // 定义两个栈来实现队列
    Stack<Integer> inStack;
    Stack<Integer> outStack;

    public Exe04_MyQueueByStack() {
// 初始化操作
        inStack = new Stack<>();
        outStack = new Stack<>();
    }

    /**
     * 入队
     *
     * @param x
     */
    public void push(int x) {
// 直接入到inStack
        inStack.push(x);
    }

    /**
     * 出队操作
     *
     * @return
     */
    public int pop() {
// 这个队列是不是为空
        if (empty()) {
            return -1;
        }
// 出栈，检查一下outStack是不是为空
// 1. 如果不为空就从outStack中直接出栈
// 2. 如果为空那么就要把inStack中的元素全部依次出栈并入栈到outStack中
        if (outStack.empty()){
            while(!inStack.empty()){
                outStack.push(inStack.pop());
            }
        }
        return outStack.pop();

    }

    public int peek() {
        if (outStack.empty()){
            while(!inStack.empty()){
                outStack.push(inStack.pop());
            }
        }
        return outStack.peek();
    }

    public boolean empty() {
// 两个栈都为空的时候，队列为空
        return inStack.empty() && outStack.empty();
    }
}
