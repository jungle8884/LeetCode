package com.OJ.AliBB;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int t = Integer.valueOf(reader.nextLine());
        Long[] N = new Long[t];
        int[] K = new int[t];
        for (int i = 0; i < t; i++) {
            String[] line = reader.nextLine().split(" ");
            N[i] = Long.valueOf(line[0]);
            K[i] = Integer.valueOf(line[1]);
        }

        // 开始正文
        for (int i = 0; i < t; i++) {
            Long res = getNum(N[i], K[i]);
            System.out.println(res);
        }
    }

    private static Long getNum(Long num, int k) {
        Long res = 0L;
        List<String> arr = new ArrayList<>();
        while (num != 0) {
            res = num % k;
            num /= k;
            arr.add(String.valueOf(res));
        }
//        System.out.println(Arrays.toString(arr.toArray()));
        res = 0L;
        int j = 1;
        for (int i = arr.size()-1; i >= 0; i--) {
            res += j * Long.valueOf(arr.get(i));
            j *= k;
        }

        return res;
    }
}
