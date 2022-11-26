package com.wangpeijie.Array.demo;

import com.wangpeijie.Array.EX_OJ;

/**
 * OJ
 * @Author 王珮杰
 * @DateTime 2022/10/26
 */
public class demo1 {
    public static void main1(String[] args) {
        EX_OJ ex_oj=new EX_OJ();
        int []nums={1,3,5,6};
        System.out.println(ex_oj.searchInsert(nums, 7));
    }

    public static void main(String[] args) {
        EX_OJ ex_oj=new EX_OJ();
        String s="Hello World";
        System.out.println(ex_oj.lengthOfLastWord(s));

    }
}
