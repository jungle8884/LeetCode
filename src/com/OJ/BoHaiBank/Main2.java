package com.OJ.BoHaiBank;

import java.util.Arrays;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int n = reader.nextInt();
        Long L = reader.nextLong();
        Long R = reader.nextLong();
        Long[] A = new Long[n];
        for (int i = 0; i < n; i++) {
            A[i] = reader.nextLong();
        }
        Arrays.sort(A);
        int cnt = 0;
        for (int i = 0; i < n-1; i++) {
            for (int j = i + 1; j < n; j++) {
                Long sum = A[i] + A[j];
                if (sum >= L && sum <= R) {
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }
}
