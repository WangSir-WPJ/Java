package com.wangpeijie;

import java.util.Arrays;

/**
 * 优先级队列(堆)-完全二叉树
 * @Author 王珮杰
 * @DateTime 2022/11/3
 */
public class Head {
    //用一个数组存放数据
    private int[] elementData;
    //数组元素个数
    private int size;
    //数组大小
    private int DEFAULT_CAPACITY=10;

    public Head() {
        this.elementData=new int [DEFAULT_CAPACITY];
        this.size=0;
    }
    //通过一个数组创建堆
    public Head(int []array) {
        //复制数组，防 止array的修改影响elementData
        this.elementData = Arrays.copyOf(array, array.length);
        this.size = elementData.length;
        //向下调整为堆结构
        int parent=(size-1-1)/2;
        for (int i = parent; i >=0 ; i--) {
            shiftDown(i);
        }
    }
// 向下调整的核心逻辑
    private void shiftDown (int parent) {
        if (parent < 0) {
            return;
        }
        // 1. 先去找到左孩子节点
        int child = parent * 2 + 1;
        while (child < size) {
            // 2. 判断有没有右孩子
            if (child + 1 < size) {
                // 有右孩子节点，如右孩子节点的值比左孩子节点的值大，那么child就设置成右孩子节点的下标
                if (elementData[child + 1] > elementData[child]) {
                    child++; // 这时child下标对应的值是左右孩子节点中最大的那个
                }
            }
            // 3. 用孩子节点中最大的值与父节点去比较
            if (elementData[parent] >= elementData[child]) {
                break;
            }
            // 4. 交换父子节点的值
            swap(elementData, parent, child);
            // 5. 向下调整，重置父子下标
            parent = child;
            child = (parent * 2) + 1;
        }

    }
    private void swap(int[] elementData, int parent, int child) {
        int tmp=elementData[parent];
        elementData[parent]=elementData[child];
        elementData[child]=tmp;
    }

    /**
     * 堆的插入
     * @param val
     */
     public void offer(int val){
        //判断数组是否满了
        if (isFull()){
            //2倍扩容
            elementData=Arrays.copyOf(elementData,DEFAULT_CAPACITY*2);
        }
        //新元素插入到最后一个位置
        elementData[size]=val;
        size++;
        shiftUp(size-1);
     }
     //向上调整
    private void shiftUp(int child) {
        //判断是否越界
        if (child>=size){
            return;
        }
        int parent=(child-1)/2;
        //向上调整
        while (child>0&&parent>=0){
            //和父节点的值比较大小
            if(elementData[child]<=elementData[parent]){
                break;
            }
            //此时孩子节点的值比父节点的值大，交换
            swap(elementData,parent,child);
            //重置父子下标
            child=parent;
            parent=(child-1)/2;
        }
    }

    private boolean isFull() {
        return size==elementData.length;
    }

    /**
     * 堆的删除
     * @return
     */
    public int poll(){
         //判断数组是否为空
        if (isEmpty()){
            throw new RuntimeException("数组为空");
        }
        int val=elementData[0];
        swap(elementData,0,size-1);
        size--;
        shiftDown(0);
        return val;
    }


    private boolean isEmpty() {
         return size==0;
    }
    public int peek(){
        return elementData[0];
    }


    public void display(){
        StringBuilder sb=new StringBuilder();
        sb.append("[");
        for (int i = 0; i < size; i++) {
            sb.append(elementData[i]);
            if (i<size-1){
                sb.append(",");
            }

        }
        sb.append("]");
        sb.toString();
        System.out.println(sb);
    }

}
