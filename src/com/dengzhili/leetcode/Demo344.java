package com.dengzhili.leetcode;

/**
 * 编写一个函数，其作用是将输入的字符串反转过来。
 *
 * 示例 1:
 *
 * 输入: "hello"
 * 输出: "olleh"
 */
public class Demo344 {


    public String reverseString(String s) {
        int length=s.length();
        char[] arr=new char[length];
        char[] chars=s.toCharArray();

        s.indexOf('a');
        for (int i = 0; i <arr.length; i++) {
            arr[i]=chars[length-i-1];
        }
        return new String(arr);
    }
}
