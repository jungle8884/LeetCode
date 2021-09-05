package com.OJ.efficientWinning;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
*给定一个整数数组 nums 和一个整数目标值 target，
* 请你在该数组中找出 和为目标值 target  的那 两个 整数，
* 并返回它们的数组下标。
* */
public class TwoSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] line1 = sc.nextLine()
                .replace('[', ' ')
                .replace(']',' ')
                .trim()
                .split(",");
        int[] nums = new int[line1.length];
        for (int i = 0; i < line1.length; i++) {
            nums[i] = Integer.valueOf(line1[i]);
        }
        int target = Integer.valueOf(sc.nextLine());
        System.out.println(Arrays.toString(twoSum(nums, target)));
    }

//    public static int[] twoSum(int[] nums, int target) {
//        int len = nums.length;
//        int left = 0;
//        int right = len-1;
//        while (left != len-1) {
//            while (left < right) {
//                if (nums[left] + nums[right] == target) {
//                    return new int[]{left, right};
//                }
//                right--;
//            }
//            left++;
//            right = len-1;
//        }
//
//        return new int[0];
//    }

//    // 使用HashMap优化
//    public static int[] twoSum(int[] nums, int target) {
//        Map<Integer, Integer> map = new HashMap<>();
//        for (int i = 0; i < nums.length; i++) {
//            if (map.containsKey(target - nums[i])) {
//                return new int[]{map.get(target - nums[i]), i};
//            }
//            map.put(nums[i], i);
//        }
//
//        return new int[0];
//    }

    // 167. 两数之和 II - 输入有序数组
//    public static int[] twoSum(int[] nums, int target) {
//        Map<Integer, Integer> map = new HashMap<>();
//        for (int i = 0; i < nums.length; i++) {
//            if (map.containsKey(target - nums[i])) {
//                return new int[]{map.get(target - nums[i]), i+1};
//            }
//            map.put(nums[i], i+1);
//        }
//
//        return new int[0];
//    }

    // 167. 两数之和 II - 输入有序数组
    // 优化: 使用双指针
    public static int[] twoSum(int[] nums, int target) {
        int len = nums.length;
        int left = 0;
        int right = len-1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) {
                return new int[]{left+1, right+1};
            } else if (sum > target) {
                right--;
            } else {
                left++;
            }
        }

        return new int[0];
    }
}
