package com.wangpeijie.Array;

/**
 * @Author 王珮杰
 * @DateTime 2022/10/26
 */
public class EX_OJ {
    /**
     * 搜索插入位置
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert(int[] nums, int target) {
        int left=0;
        int right=nums.length-1;
        while (left<=right){
            int mid=left+(right-left)/2;
            if (nums[mid]<target){
                left=mid+1;
            }else {
                right=mid-1;
            }
        }
        return left;
    }

    /**
     * 回文数
     * 将数字反转
     * @param x
     * @return
     */
    public boolean isPalindrome(int x) {
        if (x<0){
            return false;
        }


        return false;
    }

    /**
     * 最后一个单词的长度
     * @param s
     * @return
     */
    public int lengthOfLastWord(String s) {
        int index=s.length()-1;
        //去掉结尾的空格
        while(s.charAt(index)==' '){
            index--;
        }
        int length=0;
        while(index>=0&&s.charAt(index)!=' '){
            length++;
            index--;
        }
        return length;

    }

    /**
     * 罗马数字转整数
     * I             1
     * V             5
     * X             10
     * L             50
     * C             100
     * D             500
     * M             1000
     * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
     * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
     * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
     * @param s
     * @return
     */
    public int romanToInt(String s) {
        int sum=0;
        int preNum=getVal(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            int num=getVal(s.charAt(i));
            if (preNum<num){
                sum-=preNum;
            }else {
                sum+=preNum;
            }
            preNum=num;
        }
        sum+=preNum;
        return sum;
    }

    private int getVal(char ch) {
        switch (ch){
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default:return 0;
        }
    }
}
