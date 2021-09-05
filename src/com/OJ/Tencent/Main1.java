package com.OJ.Tencent;

import java.util.*;

public class Main1 {

    public static class ListNode {
        int val;
        ListNode next = null;
        public ListNode(int val) {this.val = val;}
    }

    public static void main(String[] args) {

    }

    public static ListNode solve (ListNode[] a) {
        // write code here
        Deque<ListNode> queue = new ArrayDeque<>();
        // 先将 a 的三个 头指针 入队
        for (int i = 0; i < a.length; i++) {
            ListNode pi = a[i];
            queue.offerLast(pi);
        }
        ListNode list = new ListNode(0);
        list.next = null;
        ListNode head = list;
        while (!queue.isEmpty()) {
            ListNode pi = queue.pollFirst();
            ListNode tmp = pi;
            if (pi != null) {
                list.next = tmp;
                pi = pi.next;
                tmp.next = null; // 断开当前链表
                list = list.next;
                queue.offerLast(pi);
            }
        }
        return head.next;
    }
}
