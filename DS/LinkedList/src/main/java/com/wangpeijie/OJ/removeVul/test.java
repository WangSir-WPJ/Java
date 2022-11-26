package com.wangpeijie.OJ.removeVul;

class Solution {
    public int removeElement(int[] nums, int val) {
        int left=0;
        for (int i = 0; i <nums.length ; i++) {
            if(nums[i]!=val){
                nums[left]=nums[i];
                left++;
            }
        }
        return left;
    }
}
public class test {
    public static void main(String[] args) {
        Solution solution=new Solution();
        int []num={3,2,2,3};
        System.out.println(solution.removeElement(num,3));

    }
    
    
}
