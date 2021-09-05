package com.OJ.WangYi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/*
* 一群小朋友围成一圈准备开始画画，现在老师需要给这些孩子发纸张;
规则是如果一个小朋友的年龄比自己旁边的人大，那么这个小朋友就必须分到比身旁孩子更多的纸张;
所有孩子至少要有一个纸张，请帮助老师设计一个算法，算出最少需要多少张纸。
* 备注∶
* 假设小朋友的总数量不会超过100个;
* 每个小朋友至少要求至少有一张纸;
* 当且仅当年龄大于相邻小朋友时，才会要求纸张数量更多（年龄相等的情况下，允许小于或者等于)
* 示例:
* 4 4 5 表示三个孩子, 年龄分别4岁, 4岁, 5岁
* 最少需要 1+1+2 == 4
* */
public class Test3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 读取一个数组的方式
        String[] line1 = sc.nextLine().split(" ");
        int[] arr = new int[line1.length];
        for (int i = 0; i < line1.length; i++) {
            arr[i] = Integer.valueOf(line1[i]);
        }

        System.out.println(minPaper(arr));
    }

    // 最少需要多少张纸
    /*
    * 等同于 leetcode-135-分发糖果
    * https://leetcode-cn.com/problems/candy/solution/candy-cong-zuo-zhi-you-cong-you-zhi-zuo-qu-zui-da-/
    * */
    private static int minPaper(int[] nums) {
        int len = nums.length;
        int[] left = new int[len];
        int[] right = new int[len];

        Arrays.fill(left, 1);
        Arrays.fill(right, 1);

        for (int i = 1; i < len; i++) {
            if (nums[i] > nums[i-1]) {
                left[i] = left[i-1] + 1;
            }
        }
        int count = left[len-1];
        for (int i = len-2; i >= 0; i--) {
            if (nums[i] > nums[i+1]) {
                right[i] = right[i+1] + 1;
            }
            count += Math.max(left[i], right[i]);
        }

        return count;
    }

}
