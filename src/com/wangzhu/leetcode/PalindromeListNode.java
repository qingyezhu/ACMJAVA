package com.wangzhu.leetcode;

/**
 * Created by wang.zhu on 2021-02-24 00:39.
 **/
public class PalindromeListNode {
    class ListNode {
        private int val;
        private ListNode next;
    }

    private ListNode init(final int[] arr) {
        ListNode head = null;
        for (int item : arr) {
            ListNode node = new ListNode();
            node.val = item;
            node.next = head;
            head = node;
        }
        return head;
    }

    private void print(final ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + "->");
            current = current.next;
        }
        System.out.println();
    }

    private boolean isPalindrome(final ListNode head) {
        System.out.println("反转前：");
        print(head);
        final ListNode midNode = findMidNode(head);
        final ListNode newHead = reverseNode(midNode);
        System.out.println("反转后：");
        print(head);
        print(newHead);
        final boolean ret = check(head, newHead);

        ListNode newNode = reverseNode(newHead);
        midNode.next = newNode.next;
        return ret;
    }

    private ListNode findMidNode(final ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    private ListNode reverseNode(final ListNode head) {
        ListNode newHead = null, current = head;
        while (current != null) {
            final ListNode next = current.next;
            current.next = newHead;
            newHead = current;
            current = next;
        }
        return newHead;
    }

    private boolean check(final ListNode leftNode, final ListNode rightNode) {
        ListNode leftCurrentNode = leftNode, rightCurrentNode = rightNode;
        while (leftCurrentNode != null && rightCurrentNode != null) {
            if (leftCurrentNode.val != rightCurrentNode.val) {
                return false;
            }
            leftCurrentNode = leftCurrentNode.next;
            rightCurrentNode = rightCurrentNode.next;
        }
        return true;
    }

    public static void main(String[] args) {
        start(new int[]{1, 2, 3, 4, 5, 6});
        System.out.println("------");
        start(new int[]{1, 2, 3, 4, 5});
    }

    private static void start(final int[] arr) {
        final PalindromeListNode palindromeListNode = new PalindromeListNode();
        final ListNode head = palindromeListNode.init(arr);
        System.out.println(palindromeListNode.isPalindrome(head));
        palindromeListNode.print(head);
    }
}
