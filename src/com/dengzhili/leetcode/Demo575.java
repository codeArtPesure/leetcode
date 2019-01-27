package com.dengzhili.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个偶数长度的数组，其中不同的数字代表着不同种类的糖果，每一个数字代表一个糖果。
 * 你需要把这些糖果平均分给一个弟弟和一个妹妹。返回妹妹可以获得的最大糖果的种类数。
 *
 * 示例 1:
 *
 * 输入: candies = [1,1,2,2,3,3]
 * 输出: 3
 * 解析: 一共有三种种类的糖果，每一种都有两个。
 *      最优分配方案：妹妹获得[1,2,3],弟弟也获得[1,2,3]。这样使妹妹获得糖果的种类数最多。
 * 示例 2 :
 *
 * 输入: candies = [1,1,2,3]
 * 输出: 2
 * 解析: 妹妹获得糖果[2,3],弟弟获得糖果[1,1]，妹妹有两种不同的糖果，弟弟只有一种。这样使得妹妹可以获得的糖果种类数最多。
 */
public class Demo575 {

    public int distributeCandies(int[] candies) {
        Set<Integer> set=new HashSet<Integer>(candies.length/2);
        for (int i = 0; i < candies.length; i++) {
            if(set.contains(candies[i])){
                continue;
            }
            set.add(candies[i]);
        }
        return candies.length/2<set.size()?candies.length/2:set.size();
    }

}
