package com.dengzhili.leetcode;

import java.util.Iterator;
import java.util.TreeSet;

/**
 * 给定一个非空数组，返回此数组中第三大的数。如果不存在，则返回数组中最大的数。要求算法时间复杂度必须是O(n)。
 *
 * 示例 1:
 *
 * 输入: [3, 2, 1]
 *
 * 输出: 1
 *
 * 解释: 第三大的数是 1.
 * 示例 2:
 *
 * 输入: [1, 2]
 *
 * 输出: 2
 *
 * 解释: 第三大的数不存在, 所以返回最大的数 2 .
 */
public class Demo414 {

    public int thirdMax(int[] nums) {
        TreeSet<Integer> treeSet=new TreeSet<Integer>();
        for (int i=0;i<nums.length;i++){
            treeSet.add(nums[i]);
        }
        System.out.println(treeSet.size());
        if(treeSet.size()<3){
            return treeSet.first();
        }else {
            treeSet = (TreeSet) treeSet.descendingSet();
            Iterator<Integer> iterator = treeSet.iterator();
            int i=0;
            int result=0;
            while (iterator.hasNext()){
                i++;
                if(i==3){
                    result=iterator.next();
                    break;
                }
                iterator.next();
            }
            return result;
        }
    }
}
