package com.dengzhili.leetcode;

/**
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 *
 * 本题中，一棵高度平衡二叉树定义为：
 *
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
 */
public class Demo110 {

    /**
     * 思路：先判断根结点是否是平衡树，若是，则递归判断左右子树。如果不是，返回false
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {
        if(root==null){
            return true;
        }
        int leftLength=treelength(root.left);
        int rightLength=treelength(root.right);
        if(Math.abs(leftLength-rightLength)<=1){
            return isBalanced(root.left)&&isBalanced(root.right);
        }else{
            return false;
        }
    }
    public int treelength(TreeNode node){
        if(node==null){
            return 0;
        }
        int leftLength=treelength(node.left);
        int rightLength=treelength(node.right);
        return leftLength>rightLength?leftLength+1:rightLength+1;
    }

}
