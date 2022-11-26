package com.wangpeijie.demo;

import com.wangpeijie.Sort;

import java.util.Arrays;

/**
 * @Author 王珮杰
 * @DateTime 2022/11/8
 */
public class demo1 {
    public static void main(String[] args) {
        int []array={ 27,15,19,18,28,34,65,49,25,37 };
        Sort sort=new Sort();
        //sort.shellSort(array);
        //sort.insertSort(array);
        //sort.selectSort(array);
        //sort.selectSort1(array);
        //sort.headSort(array);
        //sort.quickSort(array1);
        //sort.quickSourItr(array);
        //sort.mergeSort(array);
        //sort.mergeSortItr(array);
        sort.countSort(array);
        System.out.println(Arrays.toString(array));
        array= new int[]{4, 5, 6, 3, 2, 1};
        sort.bubbleSort(array);
    }
}
