package com.oj.threesixzero;

import java.util.Scanner;

/**
 * @author Jungle
 * yeah数列: 对于任意一个位置, 左右两边至少有一个比它大
 * V 字型
 * 3
 * 4 1 8
 * 0
 *
 * 8
 * 6 6 6 6 2 3 3 3
 * 9
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner reader  = new Scanner(System.in);

        int n = reader.nextInt();
        Long[] arr = new Long[n];
        int pos = 0;
        Long min_num = Long.MAX_VALUE;
        // 先找到最小的数和位置
        for (int i = 0; i < n; i++) {
            arr[i] = reader.nextLong();
            if (arr[i] < min_num) {
                min_num = arr[i];
                pos = i;
            }
        }

        int tmp = 0;
        // 有多少个最小的数
        for (int i = pos; i < n; i++) {
            if (arr[i].equals(arr[pos])) {
                tmp++;
            } else {
                break;
            }
        }
        pos += tmp/2;

        int cnt = 0;
        for (int i = 1; i < pos; i++) {
            if (arr[i] >= arr[i-1]) {
                cnt += arr[i] - arr[i-1] + 1;
                arr[i] = arr[i-1] - 1;
            }
        }
        for (int i = n - 2; i > pos; i--) {
            if (arr[i] >= arr[i+1]) {
                cnt += arr[i] - arr[i+1] + 1;
                arr[i] = arr[i+1] - 1;
            }
        }

        if (pos-1 > 0 && arr[pos-1] <= arr[pos]) {
            cnt += arr[pos] - arr[pos-1] + 1;
        }

        System.out.println(cnt);
    }
}
