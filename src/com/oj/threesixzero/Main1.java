package com.oj.threesixzero;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Jungle
 * 5
 * 5 1 2 1 5
 * 3
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner reader  = new Scanner(System.in);

        int n = reader.nextInt();
        Long[] height = new Long[n+2];
        height[0] = Long.MAX_VALUE;
        height[n+1] = Long.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            height[i] = reader.nextLong();
        }

        Long[] cnt = new Long[n+2];
        Arrays.fill(cnt,1L);

        int tmp = 0;
        for (int i = 1; i <= n; i++) {
            if (height[i] > height[i-1]) {
                tmp += 1;
                cnt[i] += tmp;
            } else {
                tmp = 0;
            }
        }
        tmp = 0;
        for (int i = n; i >= 0; i--) {
            if (height[i] > height[i+1]) {
                tmp += 1;
                cnt[i] += tmp;
            } else {
                tmp = 0;
            }
        }

        Long res = 0L;
        for (int i = 1; i <= n; i++) {
            if (cnt[i] > res) {
                res = cnt[i];
            }
        }

        System.out.println(res);
    }
}
