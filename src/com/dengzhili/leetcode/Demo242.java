package com.dengzhili.leetcode;

/**
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的一个字母异位词。
 *
 * 示例 1:
 *
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 *
 * 输入: s = "rat", t = "car"
 * 输出: false
 *
 * 你可以假设字符串只包含小写字母。
 */
public class Demo242 {

    public boolean isAnagram(String s, String t) {

        if(s.length()!=t.length()){
            return false;
        }

        int[] letters=new int[26];
        char[] arr1=s.toCharArray();
        char[] arr2=t.toCharArray();
        int index;
        for (int i = 0; i <arr1.length; i++) {
            index=arr1[i]-'a';
            letters[index]=letters[index]+1;
        }
        for (int i = 0; i <arr2.length; i++) {
            index=arr2[i]-'a';
            letters[index]=letters[index]-1;
        }

        for (int i = 0; i < letters.length; i++) {
            if(letters[i]!=0){
                return false;
            }
        }
        return true;

    }

}
