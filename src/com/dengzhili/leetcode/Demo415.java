package com.dengzhili.leetcode;

import java.sql.SQLOutput;

/**
 * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
 *
 * 注意：
 *
 * num1 和num2 的长度都小于 5100.
 * num1 和num2 都只包含数字 0-9.
 * num1 和num2 都不包含任何前导零。
 * 你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式。
 */
public class Demo415 {

    public static void main(String[] args) {
        Demo415 demo=new Demo415();
        String num1="7234";
        String num2="33218";
        System.out.println(demo.addStrings(num1,num2));
    }
    public String addStrings(String num1, String num2) {

        if(num1==null || num1.length()==0){
            return num2;
        }
        if(num2==null || num2.length()==0){
            return num1;
        }
        int num1Len=num1.length();
        int num2Len=num2.length();
        int maxLen=0;
        if(num1Len>num2Len){
            maxLen=num1Len;
            num2=appendZero(num2,num1Len-num2Len);
        }else {
            maxLen=num2Len;
            num1=appendZero(num1,num2Len-num1Len);
        }
        char[] resultArr=new char[maxLen+1];
        boolean flag=false;     //判断是否产生进位
        for (int i = maxLen-1; i >= 0; i--) {
            int sum=0;
            if(flag){
                sum=1+num1.charAt(i)+num2.charAt(i)-2*'0';
            }else {
                sum=num1.charAt(i)+num2.charAt(i)-2*'0';
            }
            if(sum>=10){
                flag=true;
                sum=sum%10;
            }else {
                flag=false;
            }
            resultArr[i+1]=(char) (sum+'0');
        }
        if(flag){
            resultArr[0]='1';
            return new String(resultArr);
        }else {
            return new String(resultArr,1,maxLen);
        }

    }

    private String appendZero(String num,int zeroCount){
        if(zeroCount==0){
            return num;
        }
        StringBuilder stringBuilder=new StringBuilder();
        for (int i = 0; i < zeroCount; i++) {
            stringBuilder.append(0);
        }
        stringBuilder.append(num);
        return stringBuilder.toString();
    }

}
