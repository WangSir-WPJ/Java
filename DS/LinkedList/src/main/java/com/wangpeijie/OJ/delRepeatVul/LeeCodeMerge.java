package com.wangpeijie.OJ.delRepeatVul;

import java.util.Arrays;

/**
 *
 */
public class LeeCodeMerge {
    public static void main(String[] args) {
        int[]m={1,2,3,0,0,0};
        int[]n={2,5,6};
        merge(m,3,n,3);
        System.out.println(Arrays.toString(m));
    }
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
//设置p为从尾部开始寻找
        int p=m+n-1;
        while (m>=0&&n>=0){
            nums1[p--]=(nums1[m-1]>nums2[n-1]?nums1[--m] :nums2[--n]);
        }
        while (m>=0){
            nums1[--p]=nums1[--m];
        }
        while (n>=0){
            nums1[--p]=nums2[--n];
        }
    }
}
