package com.dengzhili.leetcode;

/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * <p>
 * 示例 1：
 * <p>
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 * <p>
 * 输入: "cbbd"
 * 输出: "bb"
 */
public class Demo5 {


    public static void main(String[] args) {
        System.out.println(longestPalindrome2("adda"));
    }

    /**
     * 方法1：暴力法将选出所有子字符串可能的开始和结束位置，并检验它是不是回文。
     *
     * @param s
     * @return
     */
    public static String longestPalindrome1(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }
        int len = s.length();
        for (int i = len - 1; i > 1; i--) {
            for (int k = 0; (k + i) <= len; k++) {
                String subStr = s.substring(k, k + i);
                if (palindorme(subStr)) {
                    return subStr;
                }
            }
        }
        return s.substring(0, 1);
    }

    private static boolean palindorme(String str) {
        if (str == null || str.length() < 0) {
            return false;
        }
        int len = str.length();
        for (int i = 0; i < str.length() / 2; i++) {
            if (str.charAt(i) != str.charAt(len - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 方法2：动态规划
     * 令d[i][j]表示s[i]到s[j]所表示的子串是否为字符串，是则为1，不是则为0.
     * 如此根据s[i]是否等于s[j]，可以把问题分为两类:
     * (1) s[i]==s[j],那么只要s[i+1][j-1]是会文串，s[i]到s[j]就是会文串;
     * 如果s[i+1][j-1]不是会文串，那么s[i]到s[j]就不是会文串
     * (2) s[i]!=s[j] 那么s[i]到s[j]一定不是会文子串
     *
     * @param s
     * @return
     */
    public static String longestPalindrome2(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }
        int len = s.length();
        if (len == 1) {
            return s;
        }
        char[] arr = s.toCharArray();
        int maxLength = 1;
        int start = 0;
        byte[][] dp = new byte[len + 1][len + 1];
        for (int i = 0; i < len; i++) {
            dp[i][i] = 1;
            if (i+1<len && arr[i] == arr[i + 1]) {
                dp[i][i + 1] = 1;
                maxLength = 2;
                start = i;
            }
        }

        for (int subLen=3;subLen<=len;subLen++){     //子串长度
            for (int i = 0; i <=len-subLen ; i++) {     //子串起始地址
                int j=i+subLen-1;   //子串串结束地址
                if(dp[i+1][j-1]==1 && arr[i]==arr[j]){
                    dp[i][j]=1;
                    maxLength=subLen;
                    start=i;
                }
            }
        }
        return s.substring(start,start+maxLength);
    }

    }
