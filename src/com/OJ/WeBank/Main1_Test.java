package com.OJ.WeBank;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
输入:
*   81 4
    2 2
输出:
    94.73
    3.41
* */
public class Main1_Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String[]> list = new ArrayList<>();
        String line;
        while (sc.hasNextLine()) {
            line = sc.nextLine();
            if ("".equals(line)) break;
            list.add(line.trim().split(" "));
        }
        sc.close();

        Double[] res = doTest1(list);
        for (Double d : res) {
            System.out.println(String.format("%.2f", d));
        }
    }

    private static Double[] doTest1(List<String[]> arrayList) {
        int len = arrayList.size();
        Double[] res = new Double[len];

        Integer n, m;
        for (int i = 0; i < len; i++) {
            String[] arr = arrayList.get(i);
            n = Integer.valueOf(arr[0]);
            m = Integer.valueOf(arr[1]);
            Double sum = Double.valueOf(n);
            Double temp = Double.valueOf(n);
            for (Integer k = 1; k < m; k++) {
                temp = Math.sqrt(temp);
                sum += temp;
            }
            res[i] = sum;
        }

        return  res;
    }

}
