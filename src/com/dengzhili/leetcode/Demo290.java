package com.dengzhili.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一种 pattern(模式) 和一个字符串 str ，判断 str 是否遵循相同的模式。
 *
 * 这里的遵循指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应模式。
 *
 * 示例1:
 *
 * 输入: pattern = "abba", str = "dog cat cat dog"
 * 输出: true
 * 示例 2:
 *
 * 输入:pattern = "abba", str = "dog cat cat fish"
 * 输出: false
 * 示例 3:
 *
 * 输入: pattern = "aaaa", str = "dog cat cat dog"
 * 输出: false
 */
public class Demo290 {

    public boolean wordPattern(String pattern, String str) {
        char[] petternLetters=pattern.toCharArray();
        String[] patterWords=str.split(" ");

        if(petternLetters.length != patterWords.length){
            return false;
        }
        Map<Character,String> map=new HashMap<Character,String>();

        for (int i = 0; i <petternLetters.length; i++) {
            //key存在的情况
            if(map.containsKey(petternLetters[i])){
                String word=map.get(petternLetters[i]);
                if(! word.equals(patterWords[i])){
                    return false;
                }
            }else {
                //key 不存在的情况
                if(map.containsValue(patterWords[i])){
                    return false;
                }
                map.put(petternLetters[i],patterWords[i]);
            }
        }
        return true;
    }
}
