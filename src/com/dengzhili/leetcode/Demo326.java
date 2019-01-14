package com.dengzhili.leetcode;

/**
 * 给定一个整数，写一个函数来判断它是否是 3 的幂次方。
 *
 * 示例 1:
 *
 * 输入: 27
 * 输出: true
 * 示例 2:
 *
 * 输入: 0
 * 输出: false
 * 示例 3:
 *
 * 输入: 9
 * 输出: true
 */
public class Demo326 {

    /**
     * 个人思路 不断除于3 判断最终结果是否为1
     * @param n
     * @return
     */
//    public boolean isPowerOfThree(int n) {
//        if(n<1){
//            return false;
//        }
//        while (n%3==0){
//            n=n/3;
//        }
//        return n==1;
//    }

    /**
     *  通过查看相关解析，发现了这个解法，用到了数论的知识，
     *  3的幂次的质因子只有3，而所给出的n如果也是3的幂次，
     *  故而题目中所给整数范围内最大的3的幂次的因子只能是3的幂次，
     *  1162261467是3的19次幂，是整数范围内最大的3的幂次
     */

    public boolean isPowerOfThree(int n) {
        return n > 0 && 1162261467%n == 0;
    }


}
