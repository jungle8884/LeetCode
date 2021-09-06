package com.OJ.ShunFengKeJi;

import java.util.Scanner;

public class Main1 {
    // 讨厌1
    public static void main(String[] args) {
        /*  输入:
            3
            22 122 111111233
            输出: 3
        */
        Scanner reader = new Scanner(System.in);
        int n = reader.nextInt();
        Long[] nums = new Long[n];
        for (int i = 0; i < n; i++) {
            nums[i] = reader.nextLong();
        }
        // 正文开始
        int cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            Long temp = 1L;
            // 转换为对应的111... 如: 122 -> 111
            for (Long j = nums[i]; j > 10; j /= 10) {
                temp = temp * 10 + 1;
            }
            // 直到 j 为 个人数, 此时 nums[i] == 0L
            for (Long j = temp; j > 10; j /= 10) {
                nums[i] %= j;
            }
            if (nums[i] == 0L) cnt++;
        }

        System.out.println(cnt);
    }

}
