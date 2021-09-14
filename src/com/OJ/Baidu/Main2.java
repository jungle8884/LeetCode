package com.OJ.Baidu;

import java.util.Scanner;

// 完美数 每位都是 1 或 2 或 3
public class Main2 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int T = Integer.valueOf(reader.nextLine());
        Long[] nums = new Long[T];
        for (int i = 0; i < T; i++) {
            nums[i] = Long.valueOf(reader.nextLine());
        }

        // 开始
        for (int i = 0; i < T; i++) {
            Long res = getPerfectNum(nums[i]);
            System.out.println(res);
        }
    }

    public static Long getPerfectNum(Long num) {
        Long originNum = num;
        Long sum = 0L;
        Long tmp = 1L;
        do{
            // 个位
            Long a = num % 10;
            if (a >= 3) {
                a = 3L;
            } else {
                if (a == 2L) a = 2L;
                if (a <= 1L) a= 1L;
            }
            sum += tmp* a;
            tmp *= 10L;
            num /= 10;
        } while (num > 0);

        System.out.println(sum);
        if (sum > originNum) {
            sum = (sum/10) * 3;
        }

        return sum;
    }

}
