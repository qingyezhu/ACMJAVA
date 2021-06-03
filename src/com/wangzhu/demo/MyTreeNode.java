package com.wangzhu.demo;

/**
 * Created by wang.zhu on 2021-05-13 18:54.
 **/
public class MyTreeNode {
    static class TreeNode {
        int val;
        TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    static boolean handler(TreeNode root, int targetSum) {
        if(root == null){
            return false;
        }
        targetSum -= root.val;
        if(root.left == null && root.right == null){
            return targetSum == 0;
        }
        boolean left = handler(root.left, targetSum);
        boolean right = handler(root.right, targetSum);
        return left || right;
    }

    static void init() {
        TreeNode root = new TreeNode(5, new TreeNode(4), new TreeNode(8));
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);

        root.right.left = new TreeNode(8);
        root.right.left.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(1);
        boolean ret = handler(root, 22);
        System.out.println(ret);
    }

    public static void main(String[] args) {
        init();
    }
}
