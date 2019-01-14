package com.dengzhili.leetcode;

/**
 * 你总共有 n 枚硬币，你需要将它们摆成一个阶梯形状，第 k 行就必须正好有 k 枚硬币。
 *
 * 给定一个数字 n，找出可形成完整阶梯行的总行数。
 *
 * n 是一个非负整数，并且在32位有符号整型的范围内。
 *
 * 示例 1:
 *
 * n = 5
 *
 * 硬币可排列成以下几行:
 * ¤
 * ¤ ¤
 * ¤ ¤
 *
 * 因为第三行不完整，所以返回2.
 */
public class Demo441 {

    /**
     * 简单思路 不断增加硬币行数，判断总硬币数是哦服用小于n(超时)
     * @param n
     * @return
     */
//    public int arrangeCoins(int n) {
//        int sum=0;
//        int row=1;
//        while (sum<=n){
//            row++;
//            sum=sum+row;
//        }
//        return sum==n?row:row-1;
//    }

    /**
     * 数学方法
     * @param n
     * @return
     */
    public int arrangeCoins(int n) {
        return (int) (Math.sqrt((long) n * 2 + 0.25) - 0.5);
    }
}
