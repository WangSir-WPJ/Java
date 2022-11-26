package com.wangpeijie.demo;

/**
 * @Author 王珮杰
 * @DateTime 2022/11/19
 */
public class demo2 {
    public static void main(String[] args) {
        int []letterArr=new int[26];
        String s="leetcode";
        for(int i=0;i<s.length();i++){
            int index=(int)(s.charAt(i)-'a');
            System.out.println(index);
        }

        System.out.println(fun(10));
    }
    static int s=0;
    private static int fun(int n) {

        if (n<=1){
            s=1;
        }else {
            s=fun(n-1)+n;
        }
        return s;
        //字母
    }
}
