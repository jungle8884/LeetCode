package com.OJ.XiaoMaZhiXing;

import java.util.ArrayList;
import java.util.Scanner;

public class Main4 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int n = reader.nextInt();
        Long[] arr = new Long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = reader.nextLong();
        }

        Long maxx, minn;
        if (arr[0] > arr[1]) {
            maxx = arr[0];
            minn = arr[1];
        } else {
            maxx = arr[1];
            minn = arr[0];
        }
        // 统计
        Long res = 0L;
        Long count = (maxx == minn) ? 2L : 0L;
        for (int i = 2; i < n; i++) {
            if (arr[i] == arr[i-1]) {
                if (count != 0)
                    count++;
                else
                    count = 2L;
                continue;
            } else if (arr[i] < minn || arr[i] > maxx) {
                if (arr[i] < minn) {
                    minn = arr[i];
                } else {
                    maxx = arr[i];
                }
                if (count != 1) res += count * (count - 1) / 2;
                count = 0L;
            } else {
                count++;
            }
        }
        if (count != 1) res += count * (count - 1) / 2;

        System.out.println(res);
    }
}
