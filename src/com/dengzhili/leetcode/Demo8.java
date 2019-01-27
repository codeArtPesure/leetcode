package com.dengzhili.leetcode;

/**
 * 请你来实现一个 atoi 函数，使其能将字符串转换成整数。
 *
 * 首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。
 * 示例 1:
 *
 * 输入: "42"
 * 输出: 42
 * 示例 2:
 *
 * 输入: "   -42"
 * 输出: -42
 * 解释: 第一个非空白字符为 '-', 它是一个负号。
 *      我们尽可能将负号与后面所有连续出现的数字组合起来，最后得到 -42 。
 * 示例 3:
 *
 * 输入: "4193 with words"
 * 输出: 4193
 * 解释: 转换截止于数字 '3' ，因为它的下一个字符不为数字。
 * 示例 4:
 *
 * 输入: "words and 987"
 * 输出: 0
 * 解释: 第一个非空字符是 'w', 但它不是数字或正、负号。
 *      因此无法执行有效的转换。
 * 示例 5:
 *
 * 输入: "-91283472332"
 * 输出: -2147483648
 * 解释: 数字 "-91283472332" 超过 32 位有符号整数范围。
 *      因此返回 INT_MIN (−231) 。
 */
public class Demo8 {

    public static void main(String[] args) {
        System.out.println(myAtoi("   +1"));
    }
    public static int myAtoi(String str) {
        if(str==null){
            return 0;
        }
        str=str.trim();
        if(str.length()==0){
            return 0;
        }
        long result=0;
        char c=str.charAt(0);
        int i=0;
        boolean flag=false;     //判断是否为负数
        if(c=='-'){     //判断是否-号开头
            i++;
            flag=true;
        }else if(c=='+'){       //判断是否非数字
            i++;
        }else if(!(c>='0'&&c<='9')){
            return 0;
        }
        if(i==str.length()){
            return 0;
        }
        while (true){
            c=str.charAt(i);
            if(c<='9'&&c>='0'){
                result=result*10+c-'0';
                if(!flag && result>Integer.MAX_VALUE){
                    return Integer.MAX_VALUE;
                }else if(flag && -1*result<Integer.MIN_VALUE){
                    return Integer.MIN_VALUE;
                }
                i++;
                if(i==str.length()){
                    break;
                }
            }else {
                break;
            }
        }
        return (int)(flag?-result:result);
    }

}
