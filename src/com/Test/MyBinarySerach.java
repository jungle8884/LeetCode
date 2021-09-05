package com.Test;

import java.util.Arrays;
import java.util.Scanner;

public class MyBinarySerach {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int[] nums = Arrays.stream(reader.nextLine().
                replace('[', ' ')
                .replace(']', ' ')
                .trim().split(",")).mapToInt((s)->{return Integer.valueOf(s);}).toArray();
        int target = reader.nextInt();
        int res = search(nums, target);
        System.out.println(res);
    }

    public static int search(int[] nums, int target) {
        // 初始判断
        if (nums == null || nums.length == 0) {
            return -1;
        }
        // 定义target在左闭右闭的区间里, [left, right]
        int left = 0, right = nums.length-1;
        // 当left == right 时, 区间依然有效, 所以用 <=
        while (left <= right) {
            int mid = left + (right-left) / 2;
            if (nums[mid] == target) {
                // 找到则返回下标
                return mid;
            } else if (nums[mid] < target) {
                // target 在右边
                left = mid + 1;
            } else {
                // target 在左边
                right = mid - 1;
            }
        }

        return -1;
    }
}
