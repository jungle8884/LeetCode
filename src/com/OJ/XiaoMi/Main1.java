package com.OJ.XiaoMi;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        // 合并两个数组
        Scanner reader = new Scanner(System.in);
        String[] line1 = reader.nextLine().split(",");
        int m = Integer.valueOf(line1[0].split("=")[1]); // A 的数组长度
        int n = Integer.valueOf(line1[1].split("=")[1]); // B 的数组长度
        int[] A = new int[m+n];
        int[] B = new int[n];
        String[] line2 = reader.nextLine().split(",");
        for (int i = 0; i < m; i++) {
            A[i] = Integer.valueOf(line2[i]);
        }
        String[] line3 = reader.nextLine().split(",");
        for (int i = 0; i < n; i++) {
            B[i] = Integer.valueOf(line3[i]);
        }
        // 开搞
        int i = 0, j = 0, k = 0;
        int[] tmp = new int[m+n];
        while (i < m && j < n) {
            if (A[i] < B[j]) {
                tmp[k++] = A[i];
                i++;
            } else {
                tmp[k++] = B[j];
                j++;
            }
        }
        // 如果还有剩余的
        while (i < m && k < tmp.length) tmp[k++] = A[i++];
        while (j < n && k < tmp.length) tmp[k++] = B[j++];
        for (k = 0; k < tmp.length; k++) {
            A[k] = tmp[k];
            System.out.print(A[k] + " ");
        }
    }
}
