package com.linklist;

/**
 * @author Jungle
 * 单链表节点的结构
 */
public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int x) { val = x; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}