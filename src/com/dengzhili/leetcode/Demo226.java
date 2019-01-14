package com.dengzhili.leetcode;

/**
 * 翻转一棵二叉树。
 *
 * 示例：
 *
 * 输入：
 *
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * 输出：
 *
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 */
public class Demo226 {

    public TreeNode invertTree(TreeNode root) {
        if(root==null){
            return null;
        }
        if(root.left!=null){
            invertTree(root.left);
        }
        if(root.right!=null){
            invertTree(root.right);
        }
        TreeNode temp=root.left;
        root.left=root.right;
        root.right=temp;
        return root;
    }

}
