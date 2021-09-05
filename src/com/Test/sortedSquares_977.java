package com.Test;

import java.util.Arrays;
import java.util.Scanner;

public class sortedSquares_977 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        // [-4,-1,0,3,10]
        String line = reader.nextLine();
        int size = line.length();
        int[] nums = Arrays.stream(line.substring(1, size-1)
                .split(","))
                .mapToInt((s)->{return Integer.valueOf(s);}).toArray();
//        for (int i = 0; i < nums.length; i++) {
//            System.out.println(nums[i]);
//        }
        int[] res = sortedSquares(nums);
        System.out.println(Arrays.toString(res));
    }

    /*
    * 给你一个按 非递减顺序 排序的整数数组 nums，
    * 返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
    * */
    public static int[] sortedSquares(int[] nums) {
        // 插入排序解法：O(n*n)
//        nums[0] *= nums[0];
//        for (int i = 1; i < nums.length; i++) {
//            int cur = nums[i] * nums[i];
//            int j = i - 1;
//            while (j >= 0 && cur < nums[j]) {
//                nums[j+1] = nums[j];
//                j--;
//            }
//            nums[j+1] = cur;
//        }
//
//        return nums;

        // 双指针解法：
        int left = 0;
        int right = nums.length-1;
        int k = nums.length-1;
        int[] res = new int[nums.length];
        while (k < res.length && left <= right) {
            int tmpLeft = nums[left]* nums[left];
            int tmpRight = nums[right] * nums[right];
            if (tmpLeft <= tmpRight) {
                res[k--] = tmpRight;
                right--;
            } else {
                res[k--] = tmpLeft;
                left++;
            }
        }
        return res;
    }
}
