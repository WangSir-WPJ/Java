package com.wangpeijie.OJ.delRepeatVul;

class Solution {
    public int removeDuplicates(int[] nums) {

        if (nums==null||nums.length==0){
            return 0;
        }
        int p=1;
        int q=1;
        while(q<nums.length){
            if (nums[q]!=nums[q-1]){
                nums[p]=nums[q];
                ++p;
            }
            ++q;
        }
        return p;
    }
}
public class test {
    public static void main(String[] args) {
        Solution solution=new Solution();
        int[]num={1,1,2,2,3,4};
        System.out.println(solution.removeDuplicates(num));
    }
}
