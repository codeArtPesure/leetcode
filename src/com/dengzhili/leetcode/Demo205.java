package com.dengzhili.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定两个字符串 s 和 t，判断它们是否是同构的。
 *
 * 如果 s 中的字符可以被替换得到 t ，那么这两个字符串是同构的。
 *
 * 所有出现的字符都必须用另一个字符替换，同时保留字符的顺序。两个字符不能映射到同一个字符上，但字符可以映射自己本身。
 *
 * 示例 1:
 *
 * 输入: s = "egg", t = "add"
 * 输出: true
 * 示例 2:
 *
 * 输入: s = "foo", t = "bar"
 * 输出: false
 *
 * 说明:
 * 你可以假设 s 和 t 具有相同的长度。
 */
public class Demo205 {

    public static void main(String[] args) {
        String s1="aba";
        String s2="baa";
        System.out.println(isIsomorphic(s1,s2));

    }
    public static boolean isIsomorphic(String s, String t) {
        Map<Character,Character> map=new HashMap<Character, Character>(s.length());
        char[] arr1=s.toCharArray();
        char[] arr2=t.toCharArray();
        for (int i = 0; i <arr1.length ; i++) {
            boolean containsKey=map.containsKey(arr1[i]);
            boolean containsVal=map.containsValue(arr2[i]);
            if(!containsKey && !containsVal){
                map.put(arr1[i],arr2[i]);
            }else if(containsKey && !containsVal){
                return false;
            }else if(!containsKey && containsVal){
                return false;
            }else if(containsKey && !(map.get(arr1[i]).equals(arr2[i]))){
                return false;
            }
        }
        return true;
    }
}
