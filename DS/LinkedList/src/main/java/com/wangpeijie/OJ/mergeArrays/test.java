package com.wangpeijie.OJ.mergeArrays;


import java.util.Arrays;

public class test {


    public static void main(String[] args) {
        int []num1={0};
        int []num2={2};
        System.out.println(Arrays.toString(num1));
        merge(num1,0,num2,1);
        System.out.println(Arrays.toString(num1));

    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int len=m+n-1;//num1数组大小-1
        int len1=m-1;
        int len2=n-1;
        while(len1>=0&&len2>=0){
            nums1[len--]=nums1[len1]>nums2[len2]?nums1[len1--]:nums2[len2--];
        }
        while(len2>=0){
            nums1[len--]=nums2[len2--];
        }

    }
}