package com.dengzhili.leetcode;

/**
 * 统计所有小于非负整数 n 的质数的数量。
 *
 * 示例:
 *
 * 输入: 10
 * 输出: 4
 * 解释: 小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7
 */
public class Demo204 {

    /**
     * 思路：先排除掉2的倍数，再排除掉3的倍数。。。直到排除掉n-1的倍数。然后统计剩余元素的个数。其实a到sqrt(n)就可以了
     * @param n
     * @return
     */
    public int countPrimes(int n) {

        if(n <= 1) return 0;

        int[] index = new int[n];
        index[0] = index[1] = 1;
        int a = 2;
        int limit=(int)Math.sqrt(n)+1;
        while(a < limit){
            while( a < limit && index[a] == 1 ) a++;    //依次找出最小质数
            for(int temp = a * 2 ; temp < n ;temp = temp + a  ){
                index[temp] = 1;
            }
            a++;
        }
        int result = 0;
        for(int i = 2;i < n;i++){
            if(index[i] == 0) {
                result++;
            }
        }
        return result;

    }
}
