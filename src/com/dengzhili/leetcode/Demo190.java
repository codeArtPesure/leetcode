package com.dengzhili.leetcode;

/**
 * 颠倒给定的 32 位无符号整数的二进制位。
 * 示例:
 *
 * 输入: 43261596
 * 输出: 964176192
 * 解释: 43261596 的二进制表示形式为 00000010100101000001111010011100 ，
 *      返回 964176192，其二进制表示形式为 00111001011110000010100101000000 。
 */
public class Demo190 {

    public static void main(String[] args) {
        int i=13;
        i = i - ((i >>> 1) & 0x55555555);

        System.out.println(i);
        System.out.println(reverseBits(43261596));
    }
    public static int reverseBits(int n) {
      return Integer.reverse(n);
    }
}
