package com.OJ.ShunFengKeJi;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        // 一共 n 个地方
        int n = reader.nextInt();
        Long[] arr = new Long[n];
        for (int i = 0; i < n; i++) {
            //  第二行n个整数，从左到右依次表示小明旅游路线上每个地方特色物品可以提供的开心值
            arr[i] = reader.nextLong();
        }
        // 开始
        Long cnt = 0L, sum = 0L;
        // 优先队列-大顶堆: 每次取出最大的负数, 即绝对值最小的(最低降低开心值)
        PriorityQueue<Long> queue = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            if (sum + arr[i] >= 0) {
                ++cnt;
                sum += arr[i];
                if (arr[i] < 0) {
                    queue.offer(arr[i]);
                }
            }  else {
                if (!queue.isEmpty() && queue.peek() < arr[i]) {
                    // 取出 降低开心值最小的 特色物品
                    sum = sum - queue.peek() + arr[i];
                    queue.poll();
                }
            }
        }
        System.out.println(cnt);
    }
}