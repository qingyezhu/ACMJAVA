package com.wangzhu.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树遍历<br/>
 * Created by wang.zhu on 2021-04-04 17:39.
 **/
public class TreeTraversal {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    /**
     * 层序遍历<br/>
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(final TreeNode root) {
        final List<List<Integer>> ret = new ArrayList<>();
        final LinkedList<TreeNode> linkedList = new LinkedList<>();
        if (root != null) {
            linkedList.add(root);
            //linkedList.addLast(root);
        }
        //默认不是反转
        boolean reverse = false;
        while (!linkedList.isEmpty()) {
            final LinkedList<Integer> levelRet = new LinkedList<>();
            for (int i = linkedList.size() - 1; i >= 0; i--) {
                final TreeNode treeNode = linkedList.poll();
//                final TreeNode treeNode = linkedList.removeFirst();

                if (reverse) {
                    //反转
                    //头插法
                    levelRet.addFirst(treeNode.val);
                } else {
                    //尾插法
                    levelRet.addLast(treeNode.val);
                }

                if (treeNode.left != null) {
                    linkedList.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    linkedList.add(treeNode.right);
                }
            }
            ret.add(levelRet);
            reverse = !reverse;
        }
        return ret;
    }

    private class WrapTreeNode {
        TreeNode treeNode;
        boolean mark;

        public WrapTreeNode(TreeNode treeNode, boolean mark) {
            this.treeNode = treeNode;
            this.mark = mark;
        }
    }

    /**
     * 前序遍历<br/>
     *
     * @param treeNode
     * @return
     */
    public List<Integer> preOrder(final TreeNode treeNode) {
        final Stack<WrapTreeNode> stack = new Stack<>();
        final List<Integer> ret = new ArrayList<>();
        if (treeNode != null) {
            stack.push(new WrapTreeNode(treeNode, false));
        }
        while (!stack.isEmpty()) {
            final WrapTreeNode wrapTreeNode = stack.pop();
            final TreeNode node = wrapTreeNode.treeNode;
            if (wrapTreeNode.mark) {
                ret.add(node.val);
            } else {
                if (node.right != null) {
                    stack.push(new WrapTreeNode(node.right, false));
                }
                if (node.left != null) {
                    stack.push(new WrapTreeNode(node.left, false));
                }
                stack.push(new WrapTreeNode(node, true));
            }
        }
        return ret;
    }

    /**
     * 中序遍历<br/>
     *
     * @param treeNode
     * @return
     */
    public List<Integer> inOrder(final TreeNode treeNode) {
        final Stack<WrapTreeNode> stack = new Stack<>();
        final List<Integer> ret = new ArrayList<>();
        if (treeNode != null) {
            stack.push(new WrapTreeNode(treeNode, false));
        }
        while (!stack.isEmpty()) {
            final WrapTreeNode wrapTreeNode = stack.pop();
            final TreeNode node = wrapTreeNode.treeNode;
            if (wrapTreeNode.mark) {
                ret.add(node.val);
            } else {
                if (node.right != null) {
                    stack.push(new WrapTreeNode(node.right, false));
                }
                stack.push(new WrapTreeNode(node, true));
                if (node.left != null) {
                    stack.push(new WrapTreeNode(node.left, false));
                }
            }
        }
        return ret;
    }

    /**
     * 后序遍历<br/>
     *
     * @param treeNode
     * @return
     */
    public List<Integer> postOrder(final TreeNode treeNode) {
        final Stack<WrapTreeNode> stack = new Stack<>();
        final List<Integer> ret = new ArrayList<>();
        if (treeNode != null) {
            stack.push(new WrapTreeNode(treeNode, false));
        }
        while (!stack.isEmpty()) {
            final WrapTreeNode wrapTreeNode = stack.pop();
            final TreeNode node = wrapTreeNode.treeNode;
            if (wrapTreeNode.mark) {
                ret.add(node.val);
            } else {
                stack.push(new WrapTreeNode(node, true));
                if (node.right != null) {
                    stack.push(new WrapTreeNode(node.right, false));
                }
                if (node.left != null) {
                    stack.push(new WrapTreeNode(node.left, false));
                }
            }
        }
        return ret;
    }
}
