package com.sun.common;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

//    public TreeNode(int[] nums) {
//        if (nums == null || nums.length == 0) {
//            return;
//        }
//        TreeNode root = new TreeNode(nums[0]);
//        createRecurse(nums, root, 0);
//    }
//
//    private void createRecurse(int[] nums, TreeNode root, int parent) {
//        if (parent > nums.length) {
//            return;
//        }
//        int left = parent * 2 + 1;
//        int right = parent * 2 + 2;
//        root.left = new TreeNode(nums[left]);
//        root.right = new TreeNode(nums[right]);
//        createRecurse(nums, root.left, left);
//        createRecurse(nums, root.right, right);
//    }
}
