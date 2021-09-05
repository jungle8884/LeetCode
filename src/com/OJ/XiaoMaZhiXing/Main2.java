package com.OJ.XiaoMaZhiXing;

import java.util.Arrays;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        Long n = reader.nextLong(); // n*n
        int m  = reader.nextInt(); // m 个关键点
        int k = reader.nextInt(); // 至少 k 个关键点

        Long[] arr = new Long[m+k-1];
        Arrays.fill(arr, 4*n);
        for (int i = 0; i < m; i++) {
            Long x = reader.nextLong();
            Long y = reader.nextLong();
            if (y == 0)
                arr[i] = x;
            else if (x == n)
                arr[i] = n + y;
            else if (y == n)
                arr[i] = 2 * n + (n - x);
            else if (x == 0)
                arr[i] = 3 * n + (n - y);
        }
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        for (int i = m; i < arr.length; i++) {
            arr[i] = arr[i-m] + 4 * n;
        }
        Long minn = 4L * n;
        for (int i = 0; i < m; i++) {
            minn = Math.min(minn, arr[i+k-1] - arr[i]);
        }

        System.out.println(minn);
        System.out.println(Arrays.toString(arr));
    }
}
