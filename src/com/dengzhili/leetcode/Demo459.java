package com.dengzhili.leetcode;

/**
 * 给定一个非空的字符串，判断它是否可以由它的一个子串重复多次构成。给定的字符串只含有小写英文字母，并且长度不超过10000
 *
 * 示例 1:
 *
 * 输入: "abab"
 *
 * 输出: True
 *
 * 解释: 可由子字符串 "ab" 重复两次构成。
 * 示例 2:
 *
 * 输入: "aba"
 *
 * 输出: False
 * 示例 3:
 *
 * 输入: "abcabcabcabc"
 *
 * 输出: True
 *
 * 解释: 可由子字符串 "abc" 重复四次构成。 (或者子字符串 "abcabc" 重复两次构成。)
 */
public class Demo459 {

    /**
     * 方法：暴力破解法 子字符串的长度从1一直取到 s.length()/2，依次匹配，匹配成功返回true,否则返回false
     * @param s
     * @return
     */
    public boolean repeatedSubstringPattern(String s) {
        if(s.length() < 1)
            return false;
        int len = 1;
        int strLen = s.length();
        int i = 0;
        while(len <= strLen/2){
            if(strLen%len != 0){
                len++;
                continue;
            }
            String subStr = s.substring(0,len);
            i = 0;
            for(i = len;i < strLen;i += len){
                if(!subStr.equals(s.substring(i, i+len))){
                    break;
                }
            }
            if(i >= strLen)
                return true;
            len++;
        }
        return false;
    }

}
