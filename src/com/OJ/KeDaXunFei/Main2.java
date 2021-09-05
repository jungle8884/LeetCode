package com.OJ.KeDaXunFei;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int n = reader.nextInt();
        int[] A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = reader.nextInt();
        }

        // 正文
        int cnt = 1, max = 1;
        for (int i = 1; i < A.length; i++) {
            if (A[i] == A[i-1]) {
                cnt++;
            } else {
                if (i+1 < n && A[i-1] == A[i+1]) cnt++;
                max = Math.max(max, cnt);
                cnt = 1;
                if (cnt == 1 && i-2 > 0 && A[i-2] == A[i]) cnt++;
            }
        }

        System.out.println(max);
    }
}
