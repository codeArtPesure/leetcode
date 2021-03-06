package com.dengzhili.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。假设只有一个重复的整数，找出这个重复的数。
 *
 * 示例 1:
 *
 * 输入: [1,3,4,2,2]
 * 输出: 2
 * 示例 2:
 *
 * 输入: [3,1,3,4,2]
 * 输出: 3
 * 说明：
 *
 * 不能更改原数组（假设数组是只读的）。
 * 只能使用额外的 O(1) 的空间。
 * 时间复杂度小于 O(n2) 。
 * 数组中只有一个重复的数字，但它可能不止重复出现一次。
 */
public class Demo287 {

    /**
     * 最简单思路（set实现，复杂度O(n),空间O(n),不符合要求）
     * @param nums
     * @return
     */
//    public int findDuplicate(int[] nums) {
//        Set<Integer> set=new HashSet<>();
//        int repeatNum=0;
//        for (int i = 0; i < nums.length; i++) {
//            if(set.contains(nums[i])){
//                repeatNum=nums[i];
//                break;
//            }else {
//                set.add(nums[i]);
//            }
//        }
//        return repeatNum;
//    }

        public int findDuplicate(int[] nums) {
            /**
             快慢指针思想, fast 和 slow 是指针, nums[slow] 表示取指针对应的元素
             注意 nums 数组中的数字都是在 1 到 n 之间的(在数组中进行游走不会越界),
             因为有重复数字的出现, 所以这个游走必然是成环的, 环的入口就是重复的元素,
             即按照寻找链表环入口的思路来做
             **/
            int fast = 0, slow = 0;
            while(true) {
                fast = nums[nums[fast]];
                slow = nums[slow];
                if(slow == fast) {      //从环中找环入口
                    fast = 0;
                    while(nums[slow] != nums[fast]) {
                        fast = nums[fast];
                        slow = nums[slow];
                    }
                    return nums[slow];
                }
            }
        }
    }
