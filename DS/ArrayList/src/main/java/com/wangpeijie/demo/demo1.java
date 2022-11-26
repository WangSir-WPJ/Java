package com.wangpeijie.demo;
import com.wangpeijie.MyArraylist;

/**
 * @Author wpj
 * @DateTime 2022/10/18
 */
public class demo1 {
    public static void main(String[] args) {
        MyArraylist myArraylist=new MyArraylist();
        //数据的增加
        System.out.println("增加数据：");
        myArraylist.add(10);
        myArraylist.add(20);
        myArraylist.add(30);
        myArraylist.add(40);
        myArraylist.add(50);
        myArraylist.add(60);
        myArraylist.add(70);
        myArraylist.add(80);
        myArraylist.add(90);
        myArraylist.add(100);
        System.out.println("插入数据：");
        myArraylist.add(9,100);
        myArraylist.display();
        System.out.println("==============");
        System.out.println("获取某个下标的元素:");
        System.out.println(myArraylist.get(10));
        System.out.println(myArraylist.get(5));
        System.out.println("==============");
        System.out.println("查找某个元素的下标：");
        System.out.println(myArraylist.indexOf(10));
        System.out.println(myArraylist.indexOf(15));
        System.out.println("==============");
        System.out.println("更改某个位置的元素");
        myArraylist.set(4,500);
        myArraylist.display();
        System.out.println("==============");
        System.out.println("删除元素");
        myArraylist.remove(100);
        myArraylist.display();
        System.out.println("==============");
        System.out.println("获取顺序表长度");
        System.out.println(myArraylist.size());
        System.out.println("==============");
        System.out.println("清除顺序表");
        myArraylist.clear();
        myArraylist.display();
    }
}
