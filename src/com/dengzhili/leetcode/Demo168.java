package com.dengzhili.leetcode;

/**
 * 给定一个正整数，返回它在 Excel 表中相对应的列名称。
 *
 * 例如，
 *
 *     1 -> A
 *     2 -> B
 *     3 -> C
 *     ...
 *     26 -> Z
 *     27 -> AA
 *     28 -> AB
 */
public class Demo168 {
    public static void main(String[] args) {
        System.out.println(convertToTitle(53));
    }

    public static String convertToTitle(int n) {
        String  str="";
        int tmp;
        while (n!=0){
            tmp=n%26;
            n=n/26;
            if(tmp==0){
                n=n-1;
                tmp=26;
            }
            str=getMapperLetter(tmp)+str;
        }
        return str;
    }

    private static char getMapperLetter(int number) {
        return (char)('A'+number-1);
    }

}
