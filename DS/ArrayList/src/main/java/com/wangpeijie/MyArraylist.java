package com.wangpeijie;

import java.util.Arrays;

/**
 * @Author wpj
 * @DateTime 2022/10/18
 */
public class MyArraylist {

    public int[] elem;
    public int usedSize;//0
    //默认容量
    private static final int DEFAULT_SIZE = 10;

    public MyArraylist() {
        this.elem = new int[DEFAULT_SIZE];
    }

    /**
     * 打印顺序表:
     * 根据usedSize判断即可
     */
    public void display() {
        //1、数组为空打印[];
        if (usedSize == 0) {
            System.out.println("[]");
            return;
        }
        //数组不为空[1,2,3,4]
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < usedSize; i++) {
            sb.append(this.elem[i]);
            if (i < usedSize - 1) {
                sb.append(",");
            }
        }
        sb.append("]");
        System.out.println(sb.toString());
    }

    //扩容
    public void grow() {
        this.elem = Arrays.copyOf(this.elem, 2 * this.elem.length);

    }

    // 新增元素,默认在数组最后新增
    public void add(int data) {
        //1、先判断数组是否需要扩容
        if (isFull()) {
            grow();
        }
        //2、增加元素
        this.elem[usedSize] = data;
        usedSize++;
    }

    /**
     * 判断当前的顺序表是不是满的！
     *
     * @return true:满   false代表空
     */
    public boolean isFull() {
        return usedSize == this.elem.length;
    }

    //检查数据合法性
    private boolean checkPosInAdd(int pos) {
        //throw new IndexOutOfBoundsException("传入的下标非法，pos="+pos);
        return pos >= 0 && pos < usedSize;//合法
    }

    // 在 pos 位置新增元素
    public void add(int pos, int data) {
        //1、判断下标是否合法
        if (!checkPosInAdd(pos)) {
            throw new IndexOutOfBoundsException("传入的下标非法，pos=" + pos);
        }
        //整体往后移一位
        //判断是否需要扩容
        if (isFull()) {
            grow();
        }
        for (int i = usedSize; i > pos; i--) {
            this.elem[i] = this.elem[i - 1];
        }
        this.elem[pos] = data;
        usedSize++;
    }

    // 判定是否包含某个元素
    public boolean contains(int toFind) {
        for (int i = 0; i < usedSize; i++) {
            if (this.elem[i] == toFind) {
                return true;
            }
        }
        return false;
    }

    // 查找某个元素对应的位置
    public int indexOf(int toFind) {
        for (int i = 0; i < usedSize; i++) {
            if (this.elem[i] == toFind) {
                return i;
            }
        }
        return -1;
    }

    // 获取 pos 位置的元素
    public int get(int pos) {
        if (!checkPosInAdd(pos)) {
            throw new IndexOutOfBoundsException("传入的下标非法，pos=" + pos);
        }
        return this.elem[pos];
    }

    private boolean isEmpty() {
        return this.usedSize == 0;
    }

    // 给 pos 位置的元素设为【更新为】 value
    public void set(int pos, int value) {
        if (!checkPosInAdd(pos)) {
            throw new IndexOutOfBoundsException("传入的下标非法，pos=" + pos);
        }
        this.elem[pos] = value;
    }

    /**
     * 删除第一次出现的关键字key
     *
     * @param key
     */
    public void remove(int key) {
        //查找元素的位置
        int index = indexOf(key);
        //没找到
        if (index == -1) {
            return;
        }
        //找到了，后面元素向前移
        for (int i = index; i < usedSize; i++) {
            this.elem[i] = this.elem[i + 1];
        }
        usedSize--;
    }

    // 获取顺序表长度
    public int size() {
        return usedSize;
    }

    // 清空顺序表
    public void clear() {
        //如果数据类型为引用类型，将每个元素置为null
        /*for (int i = 0; i < usedSize; i++) {
            this.elem[i]=null;
        }*/
        usedSize = 0;
    }

}
