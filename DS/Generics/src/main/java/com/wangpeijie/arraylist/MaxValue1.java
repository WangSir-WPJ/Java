package com.wangpeijie.arraylist;

public class MaxValue1 {
    //泛型方法定义
    //方法限定符 <类型形参列表>        返回值 方法名       (形参列表)  {..}
    //实例泛型方法
    public <E extends Comparable<E>> E findMaxValue(E[]arrays){
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
    //静态泛型方法
    public static  <E extends Comparable<E>> E findMaxValue1(E[]arrays){
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
}
