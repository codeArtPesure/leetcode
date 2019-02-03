package com.dengzhili.leetcode;

import java.util.*;

/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 */
public class Demo17 {

    public static void main(String[] args) {
        new Demo17().letterCombinations("23");
    }

    public   Map<Character,String> digitMap=new HashMap<Character,String>();

    public List<String> letterCombinations(String digits) {
        digitMap.put('2',"abc");
        digitMap.put('3',"def");
        digitMap.put('4',"ghi");
        digitMap.put('5',"jkl");
        digitMap.put('6',"mno");
        digitMap.put('7',"pqrs");
        digitMap.put('8',"tuv");
        digitMap.put('9',"wxyz");
        List<String> list=new ArrayList<>();
        if(digits==null || digits.length()==0){
            return list;
        }else {
            letterCombination(list,"",digits);
            return list;
        }
    }


    private void letterCombination(List<String> list,String str,String leaveDigit){
        if(leaveDigit==null || leaveDigit.length()==0){
            System.out.println(str);
            list.add(str);
            return;
        }
        char digit=leaveDigit.charAt(0);
        String letter=digitMap.get(digit);
        for (int i = 0; i < letter.length(); i++) {
             letterCombination(list,str+letter.charAt(i),leaveDigit.substring(1));
        }
        return ;
    }
}
