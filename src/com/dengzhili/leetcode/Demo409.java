package com.dengzhili.leetcode;

/**
 * 给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。
 *
 * 在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。
 *
 * 注意:
 * 假设字符串的长度不会超过 1010。
 *
 * 示例 1:
 *
 * 输入:
 * "abccccdd"
 *
 * 输出:
 * 7
 *
 * 解释:
 * 我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
 */
public class Demo409 {

    /**
     * 思路：统计每个字符出现个数count，若为偶数个，则len+=count 若为奇数个，则len+=count-1; 最后len=len+1
     * @param s
     * @return
     */
    public int longestPalindrome(String s) {
        int[]  arr=new int[123];
        char[] charArr=s.toCharArray();
        for(char c:charArr){
            arr[c]++;
        }
        int len=0;
        boolean flag=false;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==0){
                continue;
            }
            if(arr[i]%2==0){
                len+=arr[i];
            }else {
                len+=arr[i]-1;
                flag=true;
            }
        }
        return flag?len+1:len;
    }
}
