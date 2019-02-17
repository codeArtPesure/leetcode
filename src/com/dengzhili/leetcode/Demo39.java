package com.dengzhili.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的数字可以无限制重复被选取。
 *
 * 说明：
 *
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。
 * 示例 1:
 *
 * 输入: candidates = [2,3,6,7], target = 7,
 * 所求解集为:
 * [
 *   [7],
 *   [2,2,3]
 * ]
 */
public class Demo39 {

    public static void main(String[] args) {
        int[] arr=new int[]{2,3,5,7};
        List<List<Integer>> result=combinationSum(arr,10);
        for(List list :result){
            System.out.println(list.toString());
        }
    }

    /**
     * 使用递归法，以及深拷贝List
     * @param candidates
     * @param target
     * @return
     */
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> listAll=new ArrayList<List<Integer>>();
    //先排序
        Arrays.sort(candidates);
    List<Integer> list=new ArrayList<Integer>();
    find(listAll,list,candidates,target,0);
        return listAll;
}

    private static void find(List<List<Integer>> listAll, List<Integer> list, int[] candidates, int target, int num) {
        //递归终点
        if(target==0){
            System.out.println(list);
            listAll.add(list);
        }
        //若target小于数组中最小的，直接返回
        if(target<candidates[0]){
            return;
        }
        for (int i = num; i <candidates.length && candidates[i]<=target ; i++) {
            List<Integer> tmp=new ArrayList<>(list);
            tmp.add(candidates[i]);
            //递归运算，将i传递至下一次运算是为了避免结果重复。
            find(listAll,tmp,candidates,target-candidates[i],i);
        }
    }
}
