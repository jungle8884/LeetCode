package com.OJ.WeBank;

import java.util.Arrays;
import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int n = reader.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = reader.nextInt();
        }
        System.out.println(doTest3(n, arr));
    }

    private static int doTest3(int n, int[] arr) {
        Arrays.sort(arr);
        int k = 1; //食量
        for (int i = 0; i < n; i++) {
            if (arr[i] >= k) {
                k++;
            }
        }

        return k;
    }

}
