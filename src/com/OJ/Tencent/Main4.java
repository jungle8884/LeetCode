package com.OJ.Tencent;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main4 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        int n = reader.nextInt();
        int left = reader.nextInt();
        int right = reader.nextInt();

        Deque<Integer> stack1 = new ArrayDeque<>();
        Deque<Integer> stack2 = new ArrayDeque<>();
        stack1.push(n);

        int tmp;
        while (!stack1.isEmpty()) {
            tmp = stack1.pollFirst();
            if (tmp < 2) {
                stack2.push(tmp);
            } else {
                stack1.push(tmp / 2);
                stack1.push(tmp % 2);
                stack1.push(tmp / 2);
            }
        }

        int cnt = 0;
        while (!stack2.isEmpty()) {
            if (right < 1) break;
            if (stack2.peekFirst() != 0 && left <= 1 && right >= 1) {
                cnt++;
            }
            stack2.pollFirst();
            left--;
            right--;
        }

        System.out.println(cnt);
    }
}
