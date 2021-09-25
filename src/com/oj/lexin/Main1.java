package com.oj.lexin;

import java.util.Arrays;

public class Main1 {
    public static void main(String[] args) {
//        String[] skuAmount = new String[] {"199.90","39.90","29.90","59.90"};
        String[] skuAmount = new String[] {"0.00", "199.90","39.90","29.90","59.90"};
        String res = calcPayAmount(skuAmount);
        System.out.println(res);
    }

    public static String calcPayAmount (String[] skuAmount) {
        int len = skuAmount.length;
        if (len < 2) return String.format("%.2f", 0);

        double[] skuA = Arrays.stream(skuAmount).mapToDouble((s)->{
            return Double.valueOf(s);
        }).toArray();
        Arrays.sort(skuA);
        System.out.println(Arrays.toString(skuA));
        // write code here
        double res = 0.00f;
        if (len % 2 == 0) {
            for (int i = 1; i < len; i+=2) {
                res += skuA[i];
            }
        } else {
            for (int i = 0; i < len; i+=2) {
                res += skuA[i];
            }
        }

        return String.format("%.2f", res);
    }
}
