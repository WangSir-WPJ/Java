package com.wangpeijie.arraylist;

public class ArrayList2<T>{
    //泛型语法
    //泛型目的：在编译阶段，让编译器给我们做检查
    //<T>类型形参列表


    private T[] Array= (T[]) new Object[10];
    public void setArray(int pos,T val){
        this.Array[pos]=val;
    }
    public T getArray(int pos){
        return Array[pos];
    }
    public T[] retArray(){
        return Array;
    }
}
