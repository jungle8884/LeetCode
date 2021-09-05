package com.OJ.WangYi;

import java.util.*;

/*
* 给你两个正整数n和k, 其中 1 <= n <= 26, 字符串Sn的形成规则如下
* Li 表示26个英文字母 a~z, 依次是: L1 = 'a' ~ L26 = 'z'
* S1 = "a"
* 当 i > 1, Si = Si-1 + Li + reverse(invert(Si-1))
* 其中 + 表示字符串的连接操作, reverse(x) 返回反转x后得到的字符串,
* 而invert(x) 则会翻转x中的每一位 (例如: 'a'翻转为'z', 'b'翻转为'y', ... 而'z'翻转为'a').
* 例如, 符合上述描述的序列的前4个字符串依次是:
* S1 = "a"
* S2 = "abz"
* S3 = "abzcayz"
* S4 = "abzcayzdabzxayz"
* 请你返回Sn的第k位字符, 题目数据保证k一定在Sn长度范围以内.
* 示例: 输入 3,1
* 输出: a
* 说明: S3 = "abzcayz", 其第一位为a
* */
public class Test2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] line1 = sc.nextLine().split(",");
        int n = Integer.valueOf(line1[0]);
        int k = Integer.valueOf(line1[1]);
        System.out.println(findKthChar(n, k));
    }

    // Li 表示26个英文字母 a~z, 依次是: L1 = 'a' ~ L26 = 'z'
    private static char getCharbyPos(int index) {
        return (char) (index - 1 + 'a');
    }

    // Li 表示26个英文字母 a~z, 依次是: L1 = 'a' ~ L26 = 'z'
    private static int getPosbyChar(char c) {
        return (int) (c - 'a' + 1);
    }

    private static String invert(String s) {
        char[] str = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            char c = str[i];
            str[i] = getCharbyPos(27 - getPosbyChar(c));
        }
        return new String(str);
    }

    private static String reverse(String s) {
        int len = s.length();
        char[] str = s.toCharArray();
        int i = 0;
        int j = len-1;
        char temp;
        while (i < j) {
            temp = str[i];
            str[i] = str[j];
            str[j] = temp;
            i++;
            j--;
        }
        return new String(str);
    }

    public static char findKthChar(int n, int k) {
        return findHelper(n).charAt(k-1);
    }

    // 当 i > 1, Si = Si-1 + Li + reverse(invert(Si-1))
    private static String findHelper(int n) {
        if (n == 1) return "a";

        String sn_1 = findHelper(n-1);

        StringBuilder sb = new StringBuilder();
        sb.append(sn_1);
        sb.append(getCharbyPos(n));
        sb.append(reverse(invert(sn_1)));

        return sb.toString();
    }



}
