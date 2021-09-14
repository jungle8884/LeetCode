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
        // 1 读取 n
        int n = reader.nextInt();
        // 2 再读取 n 行
        Long[] nums = new Long[n];
        for (int i = 0; i < n; i++) {
            nums[i] = reader.nextLong();
        }
        // 3 开始: 讨厌1
        int cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            Long temp = 1L;
            // 转换为对应的 1...1 如: 122 -> 111
            for (Long j = nums[i]; j > 10; j /= 10) {
                temp = temp * 10 + 1;
            }

            // 不停地对 1...1 取余, 最后为0 就说明是一个讨厌的数
            for (Long j = temp; j > 10; j /= 10) {
                nums[i] %= j;
            }
            if (nums[i] == 0L) cnt++;
        }

        System.out.println(cnt);
    }

}
