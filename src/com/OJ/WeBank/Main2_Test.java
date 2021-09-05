package com.OJ.WeBank;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main2_Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line;
        List<String[]> arr = new ArrayList<>();
        while (sc.hasNextLine()) {
            line = sc.nextLine();
            if ("".equals(line)) break;
            arr.add(line.trim().split(" "));
        }

        int len = arr.size();
        for (int i = 0; i < len; i++) {
            System.out.println(doTest2(arr.get(i)));
        }
    }

    private static String doTest2(String[] sArray) {
        int m = Integer.valueOf(sArray[0]);
        int n = Integer.valueOf(sArray[1]);
        StringBuilder res = new StringBuilder("");
        for (int k = m; k <= n; k++) {
            int a = k % 10;
            int b = (k / 10) % 10;
            int c = k / 100;
            if (Math.pow(a, 3) + Math.pow(b, 3) + Math.pow(c, 3) == k) {
                res.append(k + " ");
            }
        }
        if (res.toString().equals("")) return "no";

        return res.toString();
    }
}
