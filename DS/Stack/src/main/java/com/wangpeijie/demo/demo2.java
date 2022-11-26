package com.wangpeijie.demo;

import java.util.Stack;

/**
 * 栈的使用
 * @Author 王珮杰
 * @DateTime 2022/10/25
 */
public class demo2 {
    public static void main(String[] args) {
        Stack<Integer>stack=new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        System.out.println("栈中元素个数"+stack.size());
        System.out.println("栈顶元素"+stack.peek());
        System.out.println(stack.pop());//出栈
        if (stack.isEmpty()){
            System.out.println("栈为空");
        }else {
            System.out.println(stack.size());
        }
    }
}
