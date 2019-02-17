package com.dengzhili.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 *
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \    / \
 *         7    2  5   1
 * 返回:
 *
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
 */
public class Demo113 {

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> resultList=new ArrayList<List<Integer>>();
        if(root==null){
            return resultList;
        }
        findPath(resultList,new ArrayList<>(),root,sum);
        return resultList;
    }
    private void findPath(List<List<Integer>> resultList,List<Integer> list,TreeNode node,int sum){
        if (node==null){
            return;
        }
        List<Integer> tempList=new ArrayList<Integer>();
        tempList.addAll(list);
        tempList.add(node.val);
        if(node.val==sum && node.left==null && node.right==null){
            resultList.add(tempList);
        }
        if(node.left!=null){
            findPath(resultList,tempList,node.left,sum-node.val);
        }
        if(node.right!=null){
            findPath(resultList,tempList,node.right,sum-node.val);
        }
    }
}

