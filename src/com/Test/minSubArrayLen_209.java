package com.Test;

import java.util.Arrays;
import java.util.Scanner;

public class minSubArrayLen_209 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        // target = 7, nums = [2,3,1,2,4,3]
        /*  输入：
            7
            [2,3,1,2,4,3]
            输出：2
        * */
        int target = Integer.valueOf(reader.nextLine());
        String line = reader.nextLine();
        int[] nums = Arrays.stream(line.substring(1, line.length()-1)
                .split(","))
                .mapToInt(s -> {return Integer.valueOf(s);}).toArray();
        int res = minSubArrayLen(target, nums);
        System.out.println(res);
    }

    // 找出该数组中满足其和 大于等于 target 的长度最小的 连续子数组
    public static int minSubArrayLen(int target, int[] nums) {
        // 滑动窗口解法：窗口就是 满足其和 大于等于 s 的长度最小的 连续 子数组。
        int left = 0;
        int sum = 0;
        int res = Integer.MAX_VALUE;
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (sum >= target) {
                res = Math.min(res, right-left+1);
                sum -= nums[left++];
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}
