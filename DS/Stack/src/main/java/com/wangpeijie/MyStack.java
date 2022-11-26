package com.wangpeijie;

import java.util.Arrays;

/**
 * 模拟实现栈
 *
 * @Author:wpj
 * @DateTime:2022/10/15
 */
public class MyStack {
    // 用一个数组去组织数据
    private int[] elementData;
    // 有效元素的个数
    private int size;
    // 定义一个数组默认的大小
    private final int DEFAULT_CAPACITY = 5;

    public MyStack() {
        this.elementData = new int[DEFAULT_CAPACITY];
    }

    public MyStack(int capacity) {
        if (capacity < 0) {
            throw new RuntimeException("数组容量不能小于0.");
        } else if (capacity > 0) {
            this.elementData = new int[capacity];
        } else {
            this.elementData = new int[DEFAULT_CAPACITY];
        }
    }

    public void push(int data) {
        // 数组是否需要扩容
        ensureCapacity();
        // 在size位置加入元素
        elementData[size++] = data;
        // size++
    }
    //取出栈顶元素
    public int pop(){
        int e = peek();
        size--;
        return e;
    }
    //获得栈顶元素
    public int peek(){
        if(empty()){
            throw new RuntimeException("栈为空，无法获取栈顶元素");
        }
        return elementData[size-1];
    }
    public int size(){
        return size;
    }
    //扩容
    private void ensureCapacity() {
        if (size == elementData.length) {
            this.elementData = Arrays.copyOf(elementData, elementData.length * 2);
        }
    }
    public boolean empty(){
        return 0 == size;
    }
}


