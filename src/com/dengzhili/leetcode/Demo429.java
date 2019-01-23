package com.dengzhili.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个 N 叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。
 */
public class Demo429 {

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        LinkedList<Node> nodeQueue = new LinkedList<>();
        if (root == null) {
            return list;
        }
        nodeQueue.offer(root);
        while (!nodeQueue.isEmpty()) {
            int size = nodeQueue.size();
            List<Integer> nodeList = new ArrayList<Integer>();
            for (int i = 0; i < size; i++) {
                Node popNode = nodeQueue.poll();
                nodeList.add(popNode.val);
                List<Node> childList = popNode.children;
                if (childList != null && childList.size() > 0) {
                    for (Node node : childList) {
                        nodeQueue.offer(node);
                    }
                }
            }
            list.add(nodeList);
        }
        return list;
    }
}


class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};