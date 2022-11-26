package com.wangpeijie.demo;

import com.wangpeijie.arraylist.ArrayList2;

public class Demo2 {
    public static void main(String[] args) {
        ArrayList2<Integer> arrayList2=new ArrayList2<>();
        //指定的类型为Integer
        arrayList2.setArray(0,10);

        //arrayList2.setArray(1,"wang");
        Integer[]temp=arrayList2.retArray();
        //父类型转换为子类型时，可能会抛出类型转换异常

    }
}
