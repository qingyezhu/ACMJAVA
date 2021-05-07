package com.wangzhu.leetcode;

/**
 * Created by wang.zhu on 2021-02-22 23:46.
 **/
public class SingleLinkedList {

    static class SingleListedNode {
        int val;
        SingleListedNode next;

        SingleListedNode(int val) {
            this.val = val;
        }
    }

    static class MyLinkedList {

        SingleListedNode head;
        SingleListedNode tail;

        /**
         * Initialize your data structure here.
         */
        public MyLinkedList() {

        }

        /**
         * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
         */
        public int get(int index) {
            if (index < 0) {
                return -1;
            }
            SingleListedNode current = head;
            while (current != null && index > 0) {
                current = current.next;
                index--;
            }
            if (current == null) {
                return -1;
            }
            return current.val;
        }

        /**
         * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
         */
        public void addAtHead(int val) {
            final SingleListedNode node = new SingleListedNode(val);
            if (head == null) {
                tail = node;
            } else {
                node.next = head;
            }
            head = node;
        }

        /**
         * Append a node of value val to the last element of the linked list.
         */
        public void addAtTail(int val) {
            final SingleListedNode node = new SingleListedNode(val);
            if (tail == null) {
                head = node;
            } else {
                tail.next = node;
            }
            tail = node;
        }

        /**
         * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
         */
        public void addAtIndex(int index, int val) {
            if (index <= 0 || head == null) {
                //首位或者空链表
                addAtHead(val);
                return;
            }
            index--;
            SingleListedNode prev = head;
            while (prev != null && index > 0) {
                prev = prev.next;
                index--;
            }
            if (prev == null) {
                //索引太长了
                return;
            }
            final SingleListedNode next = prev.next;
            final SingleListedNode node = new SingleListedNode(val);
            node.next = next;
            prev.next = node;
            if (next == null) {
                //更新尾节点
                tail = node;
            }
        }

        /**
         * Delete the index-th node in the linked list, if the index is valid.
         */
        public void deleteAtIndex(int index) {
            if (index < 0 || head == null) {
                //索引无效或者空链表
                return;
            }
            if (index == 0) {
                //删除头节点
                SingleListedNode node = head;
                head = node.next;
                node.next = null;//
                if (head == null) {
                    tail = null;
                }
                return;
            }
            SingleListedNode prev = null, current = head;
            while (index > 0 && current != null) {
                index--;
                prev = current;
                current = current.next;
            }
            if (current == null) {
                //索引太长了
                return;
            }

            SingleListedNode next = current.next;
            prev.next = next;
            current.next = null;//
            if (current == tail) {
                //更新尾节点
                tail = prev;
            }
        }

        public void print() {
            SingleListedNode current = head;
            while (current != null) {
                System.out.print(current.val + "->");
                current = current.next;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.addAtHead(7);
        linkedList.addAtHead(2);
        linkedList.addAtHead(1);
        linkedList.addAtIndex(3, 0);
        linkedList.print();
        linkedList.deleteAtIndex(2);
        linkedList.print();
        linkedList.addAtHead(6);
        linkedList.print();
        linkedList.addAtTail(4);
        linkedList.print();
//        System.out.println(linkedList.get(1));            //返回2
//        linkedList.deleteAtIndex(1);  //现在链表是1-> 3
        System.out.println(linkedList.get(4));            //返回3

    }

}
