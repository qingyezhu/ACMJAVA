package com.wangzhu.demo;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by wang.zhu on 2021-05-11 18:03.
 **/
public class MyListNode {
    static class ListNode {
        int val;
        ListNode next;

        ListNode() {

        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    static void print(final ListNode root) {
        ListNode node = root;
        while (node != null) {
            ListNode next = node.next;
            System.out.print(node.val + "--->");
            node = next;
        }
        System.out.println("----");
    }

    static void convertBinaryNumber(final ListNode root) {
//        final Stack<Integer> stack = new Stack<>();
//        ListNode node = root;
//        while (node != null) {
//            ListNode next = node.next;
//            stack.push(node.val);
//            node = next;
//        }
//        int sum = 0, x = 1;
//        while (stack.size() > 0) {
//            sum = sum + stack.pop() * x;
//            x = x << 1;
//        }
//        System.out.println(sum);

        int sum = 0;
        ListNode node = root;
        while (node != null) {
            ListNode next = node.next;
            sum <<= 1;
            sum |= node.val;
            node = next;
        }
        System.out.println(sum);
    }

    static void mergeKList(ListNode[] lists) {
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(new Comparator<ListNode>() {
            public int compare(ListNode node1, ListNode node2) {
                return node1.val - node2.val;
            }
        });
        for (final ListNode node : lists) {
            priorityQueue.offer(node);
        }
        ListNode head = new ListNode(), tail = head;
        while (priorityQueue.size() != 0) {
            ListNode node = priorityQueue.poll();
            tail.next = node;
            tail = node;
            if (node.next != null) {
                priorityQueue.offer(node.next);
            }
        }
    }

    public static void main(String[] args) {
        final int[] arr = {0, 1, 0, 1};
        ListNode root = null;
        for (int i = 0, len = arr.length; i < len; i++) {
            ListNode node = new ListNode(arr[i], root);
            root = node;
        }
        print(root);
        convertBinaryNumber(root);
    }
}
