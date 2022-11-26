package com.wangpeijie.demo;

import com.wangpeijie.arraylist.arrayList1;

public class demo1 {
    public static void main(String[] args) {
        arrayList1 arrayList1 =new arrayList1();
        arrayList1.setArray(0,10);
        arrayList1.setArray(1,"王");
        arrayList1.setArray(2,12.34);
        arrayList1.setArray(3,new Object());
        //打印没有问题
        System.out.println(arrayList1.getArray(0));
        System.out.println(arrayList1.getArray(1));
        System.out.println(arrayList1.getArray(2));
        System.out.println(arrayList1.getArray(3));
        System.out.println("==========================");
        //String val1=arrayList.getArray(1);报错
        //Integer val1=arrayList.getArray(1);报错
        String val1= (String) arrayList1.getArray(1);//强转
        Integer val2= (Integer) arrayList1.getArray(0);
        //int val3= (int) arrayList.getArray(0);
        System.out.println(val1);
        System.out.println(val2);
        //System.out.println(val3);
    }
}
