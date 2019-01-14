package com.dengzhili.leetcode;

/**
 * 给定一个二叉树，找出其最小深度。
 * <p>
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 * 示例:
 * <p>
 * 给定二叉树 [3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回它的最小深度  2.
 */
public class Demo111 {

    public int minDepth (TreeNode root){
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {  //叶节点
            return 1;
        } else if (root.left != null && root.right == null) {    //只有左子树
            return 1 + minDepth(root.left);
        } else if (root.left == null && root.right != null) {    //只有右子树
            return 1 + minDepth(root.right);
        } else {
            int leftDepth = minDepth(root.left);
            int rightDepth = minDepth(root.right);
            return leftDepth < rightDepth ? leftDepth + 1 : rightDepth + 1;
        }
    }

}
