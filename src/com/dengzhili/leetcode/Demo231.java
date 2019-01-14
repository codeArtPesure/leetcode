package com.dengzhili.leetcode;

/**
 * 给定一个整数，编写一个函数来判断它是否是 2 的幂次方。
 */
public class Demo231 {

    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(8));
    }
    public static boolean isPowerOfTwo(int n) {
        if(n==1){
            return true;
        }
        while (n!=1){
            if(n%2!=0){
                return false;
            }
            n=n/2;
        }
        return true;
    }
}
