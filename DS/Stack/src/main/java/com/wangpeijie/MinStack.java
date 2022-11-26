package com.wangpeijie;

import java.util.Stack;

/**
 * 在常数时间内检索到最小元素的栈
 */
public class MinStack {
    //定义2个栈一个用来组织数据，一个用来存放当前栈中最小元素
    Stack<Integer>stack;
    Stack<Integer>miniStack;

    public MinStack() {
        stack=new Stack<>();
        miniStack=new Stack<>();
    }


    public void push(int val) {
        stack.push(val);
        //如果栈为空或者当前元素小于等于栈顶元素
        if (miniStack.isEmpty()||val<=miniStack.peek()){
            miniStack.push(val);
        }
    }
    
    public void pop() {
        if (stack.isEmpty()){
            return;
        }
        //1、用数据栈的出栈元素与最小栈的栈顶元素比较
        int topVal=stack.pop();
        //2、如果topVal等于最小栈的栈顶元素，最小栈也出栈一个元素
        if (!miniStack.isEmpty()&&topVal==miniStack.peek()){
            miniStack.pop();
        }


    }
    
    public int top() {
        if (stack.isEmpty()){
            return -1;
        }

        return stack.peek();
    }
    
    public int getMin() {
        if (stack.isEmpty()){
            return -1;
        }
        return miniStack.peek();
    }
}