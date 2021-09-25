package com.oj.lexin;

import java.util.Arrays;

public class Main2 {
    public static void main(String[] args) {
        int[] nums = new int[6];
        int target = 10;
        nums = new int[] {5, 7, 7, 8, 8, 10};
        int[] res = searchRange(nums, target);
        System.out.println(Arrays.toString(res));
    }

    public static int[] searchRange (int[] nums, int target) {
        // write code here
        int len = nums.length;
        int left = 0, right = len-1;
        while (left < len) {
            if (nums[left] == target) break;
            left++;
        }
        int index = left;
        if (left == len) left = -1;

        while (right >= index) {
            if (nums[right] == target) break;
            right--;
        }
        if (right < index) right = -1;

        int[] res = new int[2];
        res[0] = left; res[1] = right;

        return res;
    }
}
