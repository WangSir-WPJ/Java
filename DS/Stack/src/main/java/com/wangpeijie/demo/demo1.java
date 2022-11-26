package com.wangpeijie.demo;

import com.wangpeijie.MyStack;

/**
 * 测试模拟实现栈
 * @Author 王珮杰
 * @DateTime 2022/10/20
 */
public class demo1 {
    public static void main(String[] args) {
        MyStack myStack=new MyStack(4);
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        myStack.push(4);
        System.out.println(myStack.size());
    }
}
