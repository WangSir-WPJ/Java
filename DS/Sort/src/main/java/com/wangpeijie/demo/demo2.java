package com.wangpeijie.demo;

import com.wangpeijie.Sort;

import java.util.Random;

/**
 * 测试耗时
 * @Author 王珮杰
 * @DateTime 2022/11/10
 */
public class demo2 {

    public static void main(String[] args) {
        Sort sort=new Sort();
        int []array;
        array=sort.initOrderArray();
        System.out.println("有序数组");
        //sort.testInsertSort(array);
        //sort.testShellSort(array);
        //sort.testSelectSort(array);
        //sort.testSelect1Sort(array);
        //sort.testHeadSort(array);
        sort.testQuickSort(array);
        System.out.println("无序数组");
        array=sort.initUnderArray();
        //sort.testInsertSort(array);
        //sort.testShellSort(array);
        //sort.testSelectSort(array);
        //sort.testSelect1Sort(array);
        //sort.testHeadSort(array);
        sort.testQuickSort(array);

    }




}
