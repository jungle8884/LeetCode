package com.Test;

public class MyLinkedList {
    // 定义单链表-链表结点
    class ListNode {
        int val;
        ListNode next;
        ListNode() {};
        ListNode(int val) {this.val = val;}
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    int size;
    ListNode head;

    public MyLinkedList() {
        this.size = 0;
        this.head = new ListNode(0, null);
    }

    /* 获取链表中第 index 个节点的值。如果索引无效，则返回-1 */
    public int get(int index) {
        if (index < 0 || index > size) return -1;
        ListNode cur = head.next;
        // 包含一个虚拟头结点
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }

        return cur.val;
    }

    /* 在链表的第一个元素之前添加一个值为 val 的节点。插入后，新节点将成为链表的第一个节点 */
    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    /* 将值为 val 的节点追加到链表的最后一个元素 */
    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    /** 在链表中的第 index 个节点之前添加值为 val  的节点。
     * 如果 index 等于链表的长度，则该节点将附加到链表的末尾。
     * 如果 index 大于链表长度，则不会插入节点。
     * 如果index小于0，则在头部插入节点。
     * */
    public void addAtIndex(int index, int val) {
        // 若 index 大于链表的长度, 则返回空
        if (index > size) return;
        if (index < 0) index = 0;

        ListNode pre = head;
        // 找打要插入结点的前驱
        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }
        ListNode cur = pre.next;
        // 新建临时结点
        ListNode tmp = new ListNode(val, null);
        // 插入结点
        tmp.next = cur;
        pre.next = tmp;

        size++;
    }

    /** 如果索引 index 有效，则删除链表中的第 index 个节点 */
    public void deleteAtIndex(int index) {
        if (index < 0 || index > size-1) return;
        ListNode pre = head;
        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }
        ListNode cur = pre.next;
        pre.next = cur.next;
        cur.next = null;
        size--;
    }
}
