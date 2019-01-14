package com.dengzhili.leetcode;

/**
 * 给定两个字符串 s 和 t，它们只包含小写字母。
 *
 * 字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。
 *
 * 请找出在 t 中被添加的字母。
 *
 *
 *
 * 示例:
 *
 * 输入：
 * s = "abcd"
 * t = "abcde"
 *
 * 输出：
 * e
 */
public class Demo389 {

    /**
     * 思路一：记录字符串t的字符和个数
     * @param s
     * @param t
     * @return
     */
//    public char findTheDifference(String s, String t) {
//        int[] flags=new int[26];
//        char result=' ';
//        char[] arr1=t.toCharArray();
//        char[] arr2=s.toCharArray();
//        for (int i = 0; i < arr1.length; i++) {
//            int index=arr1[i]-'a';
//            flags[index]=flags[index]+1;
//        }
//        for (int i = 0; i < arr2.length; i++) {
//            int index=arr1[i]-'a';
//            flags[index]=flags[index]-1;
//        }
//        for (int i = 0; i < flags.length; i++) {
//            if(flags[i]==1){
//                result= (char)('a'+i);
//            }
//        }
//        return result;
//    }


    /**
     * 思路2 异或
     * @param s
     * @param t
     * @return
     */
    public char findTheDifference(String s, String t) {
        char[] arr1=s.toCharArray();
        char[] arr2=t.toCharArray();

        int c=arr2[0];
        for (int i = 0; i <arr1.length; i++) {
            c^=arr1[i];
            c^=arr2[i+1];
        }
        return (char)c;
    }

}
