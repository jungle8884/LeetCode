package com.Test;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        String[] str = reader.nextLine().split(" ");
        int m = Integer.valueOf(str[0]); // 对战图 可以 摆放 m 张卡片
        int n = Integer.valueOf(str[1]); // 拥有 n 张卡片
        int[] arr = new int[n]; // n 张卡片的攻击值
        for (int i = 0; i < n; i++) {
            arr[i] = reader.nextInt();
        }
        reader.nextLine();
        // 输出小明的对战图能够具有的最大攻击值
        int[] dp = new int[m+1];
        int bagWight = m;
        int[] weight = new int[n];
        Arrays.fill(weight, 1);
        int[] value = arr;
        for (int i = 0; i < n; i++) { // 遍历物品
            for (int j = bagWight; j >= weight[i]; j--) { // 遍历背包容量
                // 容量为j的背包所背的最大价值
                dp[j] = Math.max(dp[j], dp[j-weight[i]]+value[i]);
            }
        }
        /*
            6 3
            5 2 10 4 6 5
        * */
        // 表示从物品里任意取，放进容量为j的背包，价值总和最大是多少
        System.out.println(dp[m]);
    }
}
