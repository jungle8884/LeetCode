package com.linklist;

/**
 * @author Jungle
 */
public class reverseBetween_92 {

    /**
     * reverse 定义: 输入一个结点head, 将以head为起点的链表反转, 并返回之后的头结点
     */
    ListNode reverse(ListNode head) {
        // base case
        if (head.next == null) { return head; }

        ListNode last = reverse(head.next);
        head.next.next = head;
        // head 为最后一个结点 且 指向 null
        head.next = null;

        return last;
    }

    /**
     * 后驱结点
     */
    ListNode successor = null;
    /**
     * 将链表的前 n 个节点反转（n <= 链表长度）
     * 反转以 head 为起点的 n 个节点，返回新的头结点
     * 索引从1开始
     */
    ListNode reverseN(ListNode head, int n) {
        // base case
        if (n == 1) {
            // 记录第 n+1 个节点
            successor = head.next;
            return head;
        }
        // 以head.next 为起点, 需要反转前 n-1 个节点
        ListNode last = reverseN(head.next, n-1);

        head.next.next = head;
        // 让反转之后的head节点和后面的节点连起来
        head.next = successor;

        return last;
    }

    /**
     * 给一个索引区间 [m, n]（索引从 1 开始），仅仅反转区间中的链表元素
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        // base case
        if (m == 1) {
            return reverseN(head, n);
        }
        // 前进到反转的起点触发 base case
        head.next = reverseBetween(head.next, m-1, n-1);

        return head;
    }

}
