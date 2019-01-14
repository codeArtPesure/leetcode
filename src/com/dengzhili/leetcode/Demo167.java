package com.dengzhili.leetcode;

/**
 * 给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
 *
 * 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
 * 说明:
 *
 * 返回的下标值（index1 和 index2）不是从零开始的。
 * 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
 * 示例:
 *
 * 输入: numbers = [2, 7, 11, 15], target = 9
 * 输出: [1,2]
 * 解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
 */
public class Demo167 {

    /**
     * 思路一：暴力破解 时间复杂度(n^2)  空间复杂度(1)
     * 思路二：hash映射  时间复杂度(n)  空间复杂度(n)
     * 思路三：双指针移动（仅适用于有序数组） 时间复杂度(n) 空间复杂度(1)
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum(int[] numbers, int target) {

        int startIndex=0;
        int endIndex=numbers.length-1;
        int[] result=new int[2];
        while (startIndex<=endIndex){
            int sum=numbers[startIndex]+numbers[endIndex];
            if(sum==target){
                result[0]=startIndex+1;
                result[1]=endIndex+1;
                return result;
            }else if(sum<target){
                startIndex++;
            }else {
                endIndex--;
            }
        }
        return result;
    }

}
