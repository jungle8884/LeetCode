package com.linklist;

/**
 * @author Jungle
 * 给你一个链表, 每k个节点一组进行翻转, 请你返回翻转后的链表
 */
public class reverseKGroup_25 {

    /**
     * 反转以 a 为头结点的链表
     * 其实就是翻转 a 到 null 之间的 节点
     * */
    ListNode reverse(ListNode a) {
        ListNode pre, cur, nxt;
        pre = null; cur = a; nxt = a;
        while (cur != null) {
            // 逐个节点翻转
            nxt = cur.next;
            cur.next = pre;
            // 更新指针位置
            pre = cur;
            cur = nxt;
        }

        return pre;
    }

    /**
     * 反转区间 [a, b) 的元素，注意是左闭右开
     * */
    ListNode reverse(ListNode a, ListNode b) {
        ListNode pre, cur, nxt;
        pre = null; cur = a; nxt = a;
        // while 终止的条件改一下就行了
        while (cur != b) {
            nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }
        // 返回反转后的头结点
        return pre;
    }


    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) { return null; }
        // 从区间 [a, b) 包含 k 个待翻转元素
        ListNode a, b;
        a = b = head;
        for (int i = 0; i < k; i++) {
            // 不足 k 个, 不需要反转, base case
            if (b == null) { return head; }
            b = b.next;
        }
        // 反转前k个元素
        ListNode newHead = reverse(a, b);
        // 递归反转后续链表并连接起来
        a.next = reverseKGroup(b, k);

        return newHead;
    }
}
