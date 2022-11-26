package com.wangpeijie;

/**
 * 循环队列
 */
class MyCircularQueue {
    // 定义下用来组织数据的数组
    private int[] elementData;
    // 队首的下标
    private int front;
    // 队尾的下标
    private int rear;

    public MyCircularQueue(int k) {
// 用冗余最后一个数组空间的方式去处理，这时要让k + 1，真实存储数据的大小不变
        elementData = new int[k + 1];

    }

    /**
     * 入队
     *
     * @param value
     * @return
     */
    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        // 开始处理数组元素与下标
        elementData[rear]=value;
        rear=(rear+1)%elementData.length;
        return true;
    }

    /**
     * 出队
     *
     * @return
     */
    public boolean deQueue() {
        if (isEmpty()){
            return false;
        }

        front=(front+1)%elementData.length;
        return true;
    }

    /**
     * 获取队首元素
     *
     * @return
     */
    public int Front() {
        if (isEmpty()){
            return -1;
        }
        return elementData[front];
    }

    /**
     * 获取队尾元素
     *
     * @return
     */
    public int Rear() {
        if (isEmpty()){
            return -1;
        }
        return elementData[(rear-1+elementData.length)%elementData.length];
    }

    /**
     * 队列是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return front==rear;
    }

    /**
     * 队列是否满
     *
     * @return
     */
    public boolean isFull() {
        return (rear + 1) % elementData.length == front;
    }
}