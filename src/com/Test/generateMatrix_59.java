package com.Test;

import java.util.Arrays;
import java.util.Scanner;

public class generateMatrix_59 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int n = reader.nextInt();
        // 开始执行
        int[][] res = generateMatrix(n);
        // 输出
        System.out.print("[");
        for (int i = 0; i < res.length; i++) {
            System.out.print("[");
            int len = res[i].length;
            int j = 0;
            for (; j < len-1; j++) {
                System.out.print(res[i][j] + ",");
            }
            if (j == len-1) System.out.print(res[i][j]);
            System.out.print("]");
        }
        System.out.print("]");
    }

    public static int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int step = 1;
        int left = 0, right = n - 1;
        int top = 0, bottom = n-1;
        int destination = n*n;
        while (step <= destination) {
            // 从左到右
            for (int j = left; j <= right; j++) matrix[top][j] = step++;
            top++;
            // 从上到下
            for (int i = top; i <= bottom; i++) matrix[i][right] = step++;
            right--;
            // 从右到左
            for (int j = right; j >= left; j--) matrix[bottom][j] = step++;
            bottom--;
            // 从下到上
            for (int i = bottom; i >= top; i--) matrix[i][left] = step++;
            left++;
        }

        return matrix;
    }
}
