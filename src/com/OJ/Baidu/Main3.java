package com.OJ.Baidu;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        String[] line1 = reader.nextLine().split(" ");
        int n = Integer.valueOf(line1[0]);
        int k = Integer.valueOf(line1[1]);
        String s = reader.nextLine();
        Long res = NumKSer(s, k);
        System.out.println(res);
    }

    private static Long NumKSer(String s, int k) {
        char[] str = s.toCharArray();
        int len = str.length;

        Map<Character, Integer> windows = new HashMap<>();
        int valid = 0;
        int left = 0, right = 0;
        Long res = 0L;
        while (right < len) {
            char c = str[right];
            right++;
            if (!windows.containsKey(c) || windows.getOrDefault(c, 0) == 0) {
                valid++;
            }
            windows.put(c, windows.getOrDefault(c, 0) + 1);
            while (valid == k) {
                char b = str[left];
                left++;
                windows.put(b, windows.get(b)-1);
                if (windows.get(b) == 0) {
                    valid--;
                }
                res = res % (1000000007) + 1;
            }
        }

        return res == 0 ? 0 : res % (1000000007) + 1;
    }
}
