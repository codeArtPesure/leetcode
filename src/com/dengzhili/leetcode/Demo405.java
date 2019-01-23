package com.dengzhili.leetcode;

/**
 * 给定一个整数，编写一个算法将这个数转换为十六进制数。对于负整数，我们通常使用 补码运算 方法。
 */
public class Demo405 {

    public String toHex(int num) {
        if (num == 0) return "0";
        String hex = "0123456789abcdef";
        String ans = "";
        while(num!=0 && ans.length() < 8){
            ans = hex.charAt(num & 0xf) + ans;
            num >>=  4;
        }
        return ans;
    }
}
