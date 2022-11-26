package com.wangpeijie.demo;

import com.wangpeijie.arraylist.ArrayList3;

public class Demo3 {
    public static void main(String[] args) {
        ArrayList3<Integer> arrayList3=new ArrayList3<>(Integer.class,10);
        arrayList3.setArray(0,10);
        Integer[]temp1=arrayList3.retArray();
        System.out.println(temp1[0]);


        ArrayList3<String>arrayList31=new ArrayList3<>(String.class,10);
        arrayList31.setArray(0,"wang");
        String[]temp2=arrayList31.retArray();
        System.out.println(temp2[0]);
        //解决类型转换时
        //1、容器的类型时否需要确定
        //2、设置与获取要统一数据类型
    }
}
