package com.dengzhili.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 集合 S 包含从1到 n 的整数。不幸的是，因为数据错误，导致集合里面某一个元素复制了成了集合里面的另外一个元素的值，导致集合丢失了一个整数并且有一个元素重复。
 *
 * 给定一个数组 nums 代表了集合 S 发生错误后的结果。你的任务是首先寻找到重复出现的整数，再找到丢失的整数，将它们以数组的形式返回。
 *
 * 示例 1:
 *
 * 输入: nums = [1,2,2,4]
 * 输出: [2,3]
 * 注意:
 *
 * 给定数组的长度范围是 [2, 10000]。
 * 给定的数组是无序的。
 */
public class Demo645 {

    /**
     * Set 操作
     * @param nums
     * @return
     */
//    public int[] findErrorNums(int[] nums) {
//        Set<Integer> set=new HashSet<Integer>();
//        int sum=0;
//        int repeatNum=0;
//        int exceptSum=(1+nums.length)*nums.length/2;
//        boolean finded=false;   //标示是否查到重复元素
//        for (int i = 0; i < nums.length; i++) {
//            if(!finded){
//                if(set.contains(nums[i])){
//                    finded=true;
//                    repeatNum=nums[i];
//                }else {
//                    set.add(nums[i]);
//                }
//            }
//            sum =sum+nums[i];
//        }
//        return new int[]{repeatNum,exceptSum-sum+repeatNum};
//    }

    public int[] findErrorNums(int[] nums) {
        int exceptSum=(1+nums.length)*nums.length/2;
        int actualSum=0;
        int repeatNum=0;
        boolean[] flags=new boolean[nums.length+1];
        for (int i = 0; i < nums.length; i++) {
            actualSum=actualSum+nums[i];
            if(flags[nums[i]]==true){
                repeatNum=nums[i];
            }else {
                flags[nums[i]]=true;
            }
        }
        return new int[]{repeatNum,exceptSum-actualSum+repeatNum};
    }


    }
