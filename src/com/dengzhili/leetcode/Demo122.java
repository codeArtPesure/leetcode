package com.dengzhili.leetcode;

/**
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 *
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 *
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *
 * 输入: [7,1,5,3,6,4]
 * 输出: 7
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
 *      随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
 *
 */
public class Demo122 {

    public int maxProfit(int[] prices) {
        if(prices==null|| prices.length==0){
            return 0;
        }
        int min=prices[0];
        int max=prices[0];
        int totalProfit=0;
        int profit=0;
        /**
         * 遍历prices，若i<max,则计算出当前利润
         */
        for(int i=1;i<prices.length;i++){
            if(prices[i]<max){
                profit=max-min;
                min=prices[i];
                max=prices[i];
                totalProfit+=profit;
            }else if(prices[i]>max){
                max=prices[i];
            }
        }

        totalProfit+=max-min;

        return  totalProfit;
    }

}
