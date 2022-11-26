package com.wangpeijie.arraylist;
import java.lang.reflect.Array;

public class ArrayList3<T>{

    private T[] arrays;

    public ArrayList3(Class<T> clazz, int capacity){
        this.arrays=(T[])Array.newInstance(clazz,capacity);
    }
    public void setArray(int pos,T val){
        this.arrays[pos]=val;
    }
    public T getArray(int pos){
        return arrays[pos];
    }
    public T[] retArray(){
        return arrays;
    }
}
