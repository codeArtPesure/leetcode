package com.dengzhili.leetcode;

/**
 * 给定一个整数 (32 位有符号整数)，请编写一个函数来判断它是否是 4 的幂次方。
 *
 * 示例 1:
 *
 * 输入: 16
 * 输出: true
 * 示例 2:
 *
 * 输入: 5
 * 输出: false
 */
public class Demo342 {

    public static void main(String[] args) {
        int max1=1<<30;
        int max2=(int)Math.pow(2,30);
        System.out.println(max1==max2);
    }

    /**
     * 简单思路（不断除于4）
     * @param num
     * @return
     */
//    public boolean isPowerOfFour(int num) {
//        if(num==0)
//            return false;
//        while(num%4==0)
//            num/=4;
//        return num==1;
//    }

    /**
     * 理论上数字4幂的二进制类似于100，10000，1000000，etc...形式。可以有如下结论：
     *
     * 4的幂一定是2的。
     * 4的幂和2的幂一样，只会出现一位1。但是，4的1总是出现在奇数位。
     * 0x5 = 0101b可以用来校验奇数位上的1。
     * 那么，
     * @param num
     * @return
     */
    public boolean isPowerOfFour(int num) {

        int power2=(num&(num-1));
        if (num < 0 || power2!=0){//check(is or not) a power of 2.
            return false;
        }
        return (num & 0x55555555)==0?true:false;//check 1 on odd bits
    }

}
