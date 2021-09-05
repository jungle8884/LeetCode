package com.OJ.WangYi;

import java.util.Scanner;

/*
* 对于一个整型数组, 里面任何2个元素相加, 小于等于M的组合有多少种
* 如果有符合的, 输出组合对数;
* 没有, 输出0.
*
* 示例: 7 -1 -1
* 输出: 3
* */
public class Test1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 输入一个数组
        String[] line1 = sc.nextLine().split(" ");
        int[] arr = new int[line1.length];
        for (int i = 0; i < line1.length; i++) {
            arr[i] = Integer.valueOf(line1[i]);
        }

        // 输入一个数
        int m = Integer.valueOf(sc.nextLine());

        int res = getNum(arr, m);
        System.out.println(res);
    }

    private static int getNum(int[] arr, int m) {
        int count = 0;
        // 双指针
        int left = 0, right = arr.length-1;
        while (left != arr.length-1) {
            while (left < right) {
                if (arr[left] + arr[right] <= m) {
                    count++;
                    right--;
                }
            }
            left++;
            right = arr.length-1;
        }

        return count;
    }

}
