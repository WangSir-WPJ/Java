package com.wangpeijie.arraylist;

//传入的类型只能是Number的子类
public class MyArray<E extends Number>{
    private E[]arrays;
    public void setArray(E Tol,int pos){
        arrays[pos]=Tol;
    }

}
