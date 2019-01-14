package com.dengzhili.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 *
 * 输入:
 *
 *    1
 *  /   \
 * 2     3
 *  \
 *   5
 *
 * 输出: ["1->2->5", "1->3"]
 *
 * 解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
 */
public class Demo257 {

    //先序遍历树，先处理当前节点，然后遍历左右子树，依次处理，加入list中
    //而且左右子树需要分开加入
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        String s = "";
        paths(root, list, s);
        return list;
    }

    private void paths(TreeNode root, List<String> list, String s) {
        if (root == null) {
            return;
        }
        s += root.val + " ";
        if (root.left == null && root.right == null) {
            list.add(s.trim().replace(" ", "->"));
        }
        if (root.left != null) {
            paths(root.left, list, s);
        }
        if (root.right != null) {
            paths(root.right, list, s);
        }
    }
}
