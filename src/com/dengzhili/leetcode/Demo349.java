package com.dengzhili.leetcode;

import java.util.*;

/**
 * 给定两个数组，编写一个函数来计算它们的交集。
 *
 * 示例 1:
 *
 * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出: [2]
 * 示例 2:
 *
 * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出: [9,4]
 * 说明:
 *
 * 输出结果中的每个元素一定是唯一的。
 * 我们可以不考虑输出结果的顺序。
 */
public class Demo349 {

    public static void main(String[] args) {
        Map<Integer,Integer>map=new HashMap<>();
    }
    public int[] intersection(int[] nums1, int[] nums2) {

        Set<Integer> set=new HashSet<Integer>();
        for (int i=0;i<nums1.length;i++){
            if(set.contains(nums1[i])){
            }
            set.add(nums1[i]);
        }
        List<Integer> list=new ArrayList<Integer>();
        for (int i = 0; i < nums2.length; i++) {
            if(set.contains(nums2[i])){
                list.add(nums2[i]);
                set.remove(nums2[i]);
            }
        }
        int[] result=new int[list.size()];
        for (int i=0;i<list.size();i++){
            result[i]=list.get(i);
        }
        return result;
    }

}
