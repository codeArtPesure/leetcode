package com.dengzhili.leetcode;

/**
 * 假设你有一个很长的花坛，一部分地块种植了花，另一部分却没有。可是，花卉不能种植在相邻的地块上，它们会争夺水源，两者都会死去。
 *
 * 给定一个花坛（表示为一个数组包含0和1，其中0表示没种植花，1表示种植了花），和一个数 n 。能否在不打破种植规则的情况下种入 n 朵花？能则返回True，不能则返回False。
 *
 * 示例 1:
 *
 * 输入: flowerbed = [1,0,0,0,1], n = 1
 * 输出: True
 * 示例 2:
 *
 * 输入: flowerbed = [1,0,0,0,1], n = 2
 * 输出: False
 */
public class Demo605 {

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if(n==0){
            return true;
        }
        if(n>(flowerbed.length/2+1)){
            return false;
        }
        boolean preAllow=true;
        boolean nextAllow=false;
        int count=0;
        int i=0;
        for (; i < flowerbed.length-1; i++) {
            if(flowerbed[i]==1){
                preAllow=false;
            }else {
                if(preAllow && flowerbed[i+1]==0){
                    count++;
                    preAllow=false;
                }else {
                    preAllow=true;
                }
            }
        }
        if(preAllow && flowerbed[i]==0){
            count++;
        }
        return count>=n;
    }
}