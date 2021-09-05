package com.OJ.KeDaXunFei;

import java.util.Arrays;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int[] nums = new int[50];
        for (int i = 0; i < 50; i++) {
            nums[i] = reader.nextInt();
        }
        int niuniu = reader.nextInt();
        int rank = 0;
        for (int i = 0; i < nums.length; i++) {
            if (niuniu == nums[i]) {
                rank = i+1;
                break;
            }
        }

        // 找到等级
        if (rank < 6) {
            System.out.println("A+");
        } else if (rank < 16) {
            System.out.println("A0");
        } else if (rank < 31) {
            System.out.println("B+");
        } else if (rank < 36) {
            System.out.println("B0");
        } else if (rank < 46) {
            System.out.println("C+");
        } else if (rank < 49) {
            System.out.println("C0");
        } else {
            System.out.println("F");
        }
    }
}
