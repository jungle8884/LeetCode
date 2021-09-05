package com.OJ.BoHaiBank;

import java.util.Arrays;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int n = reader.nextInt(); // 同学数
        int[] surger = new int[n];
        int sum= 0;
        for (int i = 0; i < n; i++) {
            surger[i] = reader.nextInt();
            sum += surger[i];
        }
        int avg = sum / n;
        int takeNum = sum % n;
        int cnt = 0;
        Arrays.sort(surger);
        for (int i = n-1; i >= 0; i--) {
            if (surger[i] > avg) {
                int tmp = surger[i] - avg; // 可以拿走多少
                surger[i] -= tmp;
                sum -= tmp;
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
