package com.OJ.HaiKangWeiShi;

import java.util.Arrays;
import java.util.Scanner;

public class Multiply {
    public static void main(String[] args) {
        /*
        输入:
            123
            456
        输出:
            56088
         */
        Scanner reader = new Scanner(System.in);
        String str1 = reader.nextLine();
        String str2 = reader.nextLine();
        String res = multiply(str1, str2);
        System.out.println(res);
    }

    // https://leetcode-cn.com/problems/multiply-strings/solution/
    // 借鉴:

    public static String multiply(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)) return "0";

        int len1 = num1.length();
        int len2 = num2.length();
        int[] A = new int[len1];
        int[] B = new int[len2];
        // C 为结果数组
        int[] C = new int[len1+len2];
        for (int i = len1-1; i >= 0; i--) {
            A[i] = num1.charAt(i) - '0';
            for (int j = len2-1; j >= 0; j--) {
                B[j] = num2.charAt(j)-'0';
                // 先累加, 不进位
                C[i+j+1] += A[i]*B[j];
            }
        }
        int carry = 0; // 保存进位
        // 计算进位
        int k = C.length-1;
        while (k >= 0) {
            carry += C[k]; // 这里是精华所在!!!
            C[k] = carry % 10; // 保留不进位的数
            carry /= 10; // 保留进位
            k--;
        }
        // 056088
        k = 0;
        while (k <= C.length-1 && C[k] == 0) k++; // 去掉首部0
        StringBuilder res = new StringBuilder();
        while (k <= C.length-1) res.append(C[k++] );

        return res.toString();
    }
}
