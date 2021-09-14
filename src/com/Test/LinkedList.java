package com.Test;

import java.util.Arrays;
import java.util.Scanner;

public class LinkedList {
    // 定义节点
    static class ListNode {
        int val;
        ListNode next = null;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    /*
    * https://leetcode-cn.com/problems/remove-linked-list-elements/
    * 203. 移除链表元素
    * */
    public static ListNode removeElements(ListNode head, int val) {
        if (head == null) return head;
        // 添加虚节点
        ListNode p  = new ListNode(-1, head);
        ListNode pre = p;
        ListNode cur = head;
        while (cur != null) {
            if (cur.val == val) {
                pre.next = cur.next;
            } else {
                pre = cur;
            }
            cur = cur.next;
        }

        return p.next;
    }

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int[] head = Arrays.stream(reader.nextLine().replace('[', ' ').replace(']', ' ').trim().split(","))
                .mapToInt(s -> {
                    return Integer.valueOf(s);
                }).toArray();
        int val = reader.nextInt();
        // ...
    }
}
