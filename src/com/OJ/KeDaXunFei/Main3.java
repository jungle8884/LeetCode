package com.OJ.KeDaXunFei;

import java.util.Scanner;

// 马尔科夫链
public class Main3 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int T = reader.nextInt();
        int[] X = new int[T];
        int[] ST = new int[T];
        for (int i = 0; i < T; i++) {
            X[i] = reader.nextInt();
            ST[i] = reader.nextInt();
        }

        // 正文
        for (int i = 0; i < T; i++) {
            double res = doTest3(X[i], ST[i]);
            String s = String.valueOf(res).replace('0', ' ').trim();
            System.out.println(String.format(s));
//            System.out.println(res);
        }
    }

    private static double doTest3(int x, int st) {
        double p = 0.5;
        double pLeft = 1.0, pRight = 1.0;

        if (x - st < 0) {
            // 往左
            for (int i = st; i >= 0; i--) {
                x--;
                pLeft *= p;
                if (x < 0) break;
            }
        }

        if (x + st > 60) {
            // 往右
            for (int i = st; i >= 0; i--) {
                x++;
                pRight *= p;
                if (x > 60) break;
            }
        }

        return 1.0 - pLeft * pRight;
    }
}
