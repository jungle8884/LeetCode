package com.OJ.XiaoMi;

import java.util.Scanner;

public class Main2 {
    // 辅助空间
    static class Node {
        int val;
        Node next = null;
        Node(int val) {
            this.val = val;
        }
    }

    // 链表法
    public static int doTest2(int n) {
        Node head = new Node(1);
        // 建立一个环
        Node h = head;
        for (int i = 1; i < n; i++) {
            h.next = new Node(i+1);
            h = h.next;
        }
        h.next = head;
        // 开始计数
        int cnt = 0;
        Node cur = head; // 指向头部
        Node pre = h; // 前驱为尾部
        // 链表只剩下一个元素退出
        while (cur.next != cur) {
            cnt++;
            if (cnt % 3 == 0) {
                pre.next = cur.next;
                cur = cur.next;
            } else {
                pre = pre.next;
                cur = cur.next;
            }
        }
        return cur.val;
    }

    // 约瑟夫环解法
    public static int doTest3(int n) {
        int res = 0; // f(1, m) = 0
        for (int i = 2; i <= n; i++) {
            // f(n) = (f(n-1, m) + m) % n
            res = (res+3) % i;
        }
        return res+1;
    }

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int n = reader.nextInt();
        int res = doTest3(n);
        System.out.println(res);
    }
}
