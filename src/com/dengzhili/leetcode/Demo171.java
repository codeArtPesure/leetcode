package com.dengzhili.leetcode;

/**
 * 给定一个Excel表格中的列名称，返回其相应的列序号。
 * 例如，
 *
 *     A -> 1
 *     B -> 2
 *     C -> 3
 *     ...
 *     Z -> 26
 *     AA -> 27
 *     AB -> 28
 */
public class Demo171 {

    public static void main(String[] args) {
        System.out.println(titleToNumber("Z"));
        System.out.println(titleToNumber("A"));
    }
    public static int titleToNumber(String s) {
        char[] letters=s.toCharArray();
        int length=letters.length;
        int sum=0;
        for (int i=0;i<length;i++){
            int tmp=letters[i]-'A'+1;
            sum=sum*26;
            sum+=tmp;
        }
        return sum;
    }
}
