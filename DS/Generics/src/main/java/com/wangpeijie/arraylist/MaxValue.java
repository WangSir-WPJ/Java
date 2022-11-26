package com.wangpeijie.arraylist;

class MaxValue<E extends Comparable<E>>{
    //泛型数组
    public E findMaxValue1(E[]arrays){
        if (arrays.length==0){
            throw new RuntimeException("数组为空");
        }
        E max=arrays[0];
        for (int i = 0; i < arrays.length; i++) {
            if(max.compareTo(arrays[i])<0){
                max=arrays[i];
            }
        }
        return max;
    }
    //整型数组
    public int findMaxValue(int[]arrays){
        if (arrays.length==0){
            throw new RuntimeException("数组为空");
        }
        int max=arrays[0];
        for (int i = 0; i < arrays.length; i++) {
            if(arrays[i]>max){
                max=arrays[i];
            }
        }
        return max;
    }
}
