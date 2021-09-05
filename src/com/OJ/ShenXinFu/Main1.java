package com.OJ.ShenXinFu;

import java.util.Arrays;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int[] nums = Arrays.stream(reader.nextLine()
                .replace('[', ' ')
                .replace(']', ' ')
                .trim().split(",")).mapToInt((s)->{return Integer.valueOf(s);}).toArray();
        System.out.println(Arrays.toString(nearestDiff(nums)));
    }

    public static int findX(int[] nums, int i) {
        int x = 0;
        for (int j = i-1; j >= 0; j--) {
            if (nums[i] > nums[j]) {
                x = nums[i-1];
            }
        }
        return x;
    }

    public static int findY(int[] nums, int i) {
        int y = 0;
        // 找最近y
        for (int j = i+1; j < nums.length; j++) {
            if (nums[j] > nums[i]) {
                y = nums[j];
                break;
            }
        }
        return y;
    }

    public static int[] nearestDiff (int[] nums) {
        // write code here
        int len = nums.length;
        int[] res = new int[len];

        for (int i = 0; i < len; i++) {
            int x = findX(nums, i);
            int y = findY(nums, i);
            res[i] = y-x;
        }

        return res;
    }

}
