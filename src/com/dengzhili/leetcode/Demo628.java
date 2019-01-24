package com.dengzhili.leetcode;

import java.util.Arrays;

/**
 * 给定一个整型数组，在数组中找出由三个数组成的最大乘积，并输出这个乘积。
 *
 * 示例 1:
 *
 * 输入: [1,2,3]
 * 输出: 6
 * 示例 2:
 *
 * 输入: [1,2,3,4]
 * 输出: 24
 * 注意:
 *
 * 给定的整型数组长度范围是[3,104]，数组中所有的元素范围是[-1000, 1000]。
 * 输入的数组中任意三个数的乘积不会超出32位有符号整数的范围。
 */
public class Demo628 {

    /**
     * 积是整数最大有两种情况：正*正*正 或者 正*负*负
     * 积是负数最大只有一种情况
     * @param nums
     * @return
     */
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int length=nums.length;
        if(nums[length-1]<0){
            return nums[length-1]*nums[length-2]*nums[length-3];
        }else {
            int max1=nums[length-1]*nums[length-2]*nums[length-3];
            int max2=nums[0]*nums[1]*nums[length-1];
            return max1>max2?max1:max2;
        }
    }
}
