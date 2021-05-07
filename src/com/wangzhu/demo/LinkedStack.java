package com.wangzhu.demo;

/**
 * Created by wang.zhu on 2021-03-03 22:17.
 **/
public class LinkedStack {

    private static class Node {
        Object item;
        Node prev;
        Node next;

        public Node(Node prev, Object item, Node next) {
            this.prev = prev;
            this.item = item;
            this.next = next;
        }

        @Override
        public String toString() {
            return "prev=" + (prev == null ? -1 : prev.item) + ", item=" + item + ", next=" + (next == null ? -1 : next.item);
        }
    }

    Node first, last;

    public void push(Object object) {
        linkLast(object);
    }

    private void linkLast(Object item) {
        final Node l = this.last;
        final Node newNode = new Node(l, item, null);
        this.last = newNode;
        if (l == null) {
            this.first = newNode;
        } else {
            l.next = newNode;
        }
    }

    public Object pop() {
        if (this.last == null) {
            return null;
        }
        return unlinkLast(this.last);
    }

    private Object unlinkLast(Node l) {
        final Node prev = l.prev;
        final Object item = l.item;
        l.item = null;
        l.prev = null;//help gc

        this.last = prev;
        if (prev == null) {
            this.first = null;
        } else {
            prev.next = null;
        }
        return item;
    }

    public Object pull() {
        if (this.first == null) {
            return null;
        }
        return unlinkFirst(this.first);
    }

    private Object unlinkFirst(Node f) {
        final Node next = f.next;
        final Object item = f.item;
        f.item = null;
        f.next = null; //help gc

        this.first = next;
        if (next == null) {
            this.last = null;
        } else {
            next.prev = null;
        }
        return item;
    }

    public void print() {
        Node current = first;
        while (current != null) {
            System.out.print(current.item + "->");
            current = current.next;
        }
        System.out.println("----");
        System.out.println("first[" + first + "]");
        System.out.println("last[" + last + "]");

    }

    public static void main(String[] args) {
        final LinkedStack linkedStack = new LinkedStack();
        for (int i = 0; i < 10; i++) {
            linkedStack.push(i);
        }
        linkedStack.print();
        System.out.println(linkedStack.pop());
        System.out.println(linkedStack.pull());
        linkedStack.push(22);
        linkedStack.print();
    }
}
