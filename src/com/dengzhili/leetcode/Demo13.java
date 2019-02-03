package com.dengzhili.leetcode;

import java.util.*;

/**
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * <p>
 * 满足要求的三元组集合为：
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 */
public class Demo13 {

    public static void main(String[] args) {
        int[] arr = new int[]{-1, 0, 1, 2, -1, -4};
        threeSum(arr);
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < len; i++) {
            int opposite = -nums[i];
            if (i == 0 || nums[i] != nums[i - 1]) {
                int left = i + 1, right = len - 1;
                while (left < right) {
                    int twoSum = nums[left] + nums[right];
                    if (twoSum == opposite) {
                        List<Integer> ans = new ArrayList<>();
                        ans.add(nums[i]);
                        ans.add(nums[left]);
                        ans.add(nums[right]);
                        res.add(ans);
                        left = moveLeft(nums, left, right);
                        right = moveRight(nums, left, right);
                    } else if (twoSum < opposite) {
                        left = moveLeft(nums, left, right);
                    } else {
                        right = moveRight(nums, left, right);
                    }
                }
            }
        }
        return res;
    }

    private static int moveLeft(int[] nums, int left, int right) {
        int num = nums[left++];
        while (left <= right) {
            if (nums[left] != num)
                break;
            left++;
        }
        return left;
    }

    private static int moveRight(int[] nums, int left, int right) {
        int num = nums[right--];
        while (left <= right) {
            if (nums[right] != num)
                break;
            right--;
        }
        return right;
    }

}
