package com.OJ.ShunFengKeJi;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        /*
        * 输入:
            6
            4 -3 -1 -2 1 -5
        * 输出: 4
        * 解释: 取 4 -1 -2 1
        * */
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
        // 优先队列-默认小顶堆: 每次取出最小的负数, 即绝对值最大的, 让 sum 保持最大.
        PriorityQueue<Long> queue = new PriorityQueue<>(); //默认小顶堆
//        PriorityQueue<Long> queue = new PriorityQueue<>(n, (a, b)->{return (int) (a - b);}); // 小顶堆
//        PriorityQueue<Long> queue = new PriorityQueue<>(n, (a, b)->{return (int) (b - a);}); // 大顶堆
        for (int i = 0; i < n; i++) {
            if (sum + arr[i] >= 0) {
                ++cnt;
                sum += arr[i];
                if (arr[i] < 0) {
                    queue.offer(arr[i]);
//                    System.out.println("加入: " + arr[i]);
//                    System.out.println(Arrays.toString(queue.toArray()));
                }
            }  else {
                // 如果当前元素的 大于 堆顶元素 才可以加进去, 即 绝对值比小顶堆对顶小
                if (!queue.isEmpty() && queue.peek() < arr[i]) {
                    sum = sum - queue.peek() + arr[i];
                    queue.poll();
                }
            }
        }
        System.out.println(cnt);
    }
}