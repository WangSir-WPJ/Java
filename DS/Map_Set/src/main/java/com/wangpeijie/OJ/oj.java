package com.wangpeijie.OJ;

/**
 * @Author 王珮杰
 * @DateTime 2022/11/20
 */
public class oj {

    /**
     * 字符串中的第一个唯一字符(https://leetcode.cn/problems/first-unique-character-in-a-string/description/)
     * @param s
     * @return
     */
        public int firstUniqChar(String s) {
            //非空校验
            if(s==null||s.isEmpty()){
                return -1;
            }
            int []letterArr=new int[26];
            for(int i=0;i<s.length();i++){
                int index=(int)(s.charAt(i)-'a');
                letterArr[index]++;
            }
            //int index=0;
            for(int i=0;i<s.length();i++){
                int index=(int)(s.charAt(i)-'a');
                if(letterArr[index]==1){
                    return i;
                }
            }
            return -1;
        }


}
