package com.sun.leetcode.No51_100;

import com.sun.common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class No94_InOrderTraversal_Simple {
    /**
     * 题目：给定一个二叉树的根节点 root ，返回 它的 中序 遍历 。
     *
     * @param root 树的根节点
     * @return 遍历结果
     */
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
//        inorderRecurse(root, result);
        inorderLoop(root, result);
        return result;
    }

    /**
     * 递归
     *
     * @param root   树的根节点
     * @param result 遍历结果
     */
    private static void inorderRecurse(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        inorderRecurse(root.left, result);
        result.add(root.val);
        inorderRecurse(root.right, result);
    }

    /**
     * 循环
     *
     * @param root   树的根节点
     * @param result 遍历结果
     */
    private static void inorderLoop(TreeNode root, List<Integer> result) {
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            result.add(root.val);
            root = root.right;
        }
    }

    public static void main(String[] args) {

    }

}
