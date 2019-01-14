package com.dengzhili.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个赎金信 (ransom) 字符串和一个杂志(magazine)字符串，判断第一个字符串ransom能不能由第二个字符串magazines里面的字符构成。如果可以构成，返回 true ；否则返回 false。
 *
 * (题目说明：为了不暴露赎金信字迹，要从杂志上搜索各个需要的字母，组成单词来表达意思。)
 *
 * 注意：
 *
 * 你可以假设两个字符串均只含有小写字母。
 *
 * canConstruct("a", "b") -> false
 * canConstruct("aa", "ab") -> false
 * canConstruct("aa", "aab") -> true
 */
public class Demo383 {

    /**
     * 方法一：hashMap记录magazine出现的字符和个数
     * @param ransomNote
     * @param magazine
     * @return
     */
//    public boolean canConstruct(String ransomNote, String magazine) {
//        Map<Character,Integer> map=new HashMap<Character,Integer>();
//        char[] arr1=magazine.toCharArray();
//        char[] arr2=ransomNote.toCharArray();
//        if(arr2.length>arr1.length){
//            return false;
//        }
//        for (int i = 0; i <arr1.length; i++) {
//            Integer value=map.get(arr1[i]);
//            if(value==null){
//                map.put(arr1[i],1);
//            }else {
//                map.put(arr1[i],value+1);
//            }
//        }
//        for (int i = 0; i < arr2.length; i++) {
//            Integer value=map.get(arr2[i]);
//            if(value==null || value==0){
//                return false;
//            }else {
//                map.put(arr2[i],value-1);
//            }
//        }
//        return true;
//    }

    /**
     * 方法2 利用flag数组记录magazine字符串中每个字符的个数
     * @param ransomNote
     * @param magazine
     * @return
     */
    public boolean canConstruct(String ransomNote, String magazine) {
        if(ransomNote.length() == 0)
            return true;
        char[] ran = ransomNote.toCharArray();
        char[] mag = magazine.toCharArray();
        int[] flag = new int[256];
        for(int i = 0;i < mag.length;i++){
            flag[mag[i]-' ']++;
        }
        for(int j = 0;j < ran.length;j++){
            if(flag[ran[j]-' '] <= 0)
                return false;
            flag[ran[j] - ' ']--;
        }
        return true;
    }

}
