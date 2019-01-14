package com.dengzhili.leetcode;

import java.util.ArrayList;

/**
 * 给定两个数组，编写一个函数来计算它们的交集。
 *
 * 示例 1:
 *
 * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出: [2,2]
 * 示例 2:
 *
 * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出: [4,9]
 * 说明：
 *
 * 输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。
 * 我们可以不考虑输出结果的顺序。
 */
public class Demo350 {

    public int[] intersect(int[] nums1, int[] nums2) {
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> res = new ArrayList<>();
        for (int n : nums1) {
            list.add(n);
        }
        for (int n : nums2) {
            int i = list.indexOf(n);
            if (i != -1) {
                list.remove(i);
                res.add(n);
            }
        }
        int[] d = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            d[i] = res.get(i);
        }
        return d;
    }
}
