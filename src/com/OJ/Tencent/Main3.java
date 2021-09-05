package com.OJ.Tencent;

import java.util.*;

public class Main3 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int n = Integer.valueOf(reader.nextLine());
        String line = reader.nextLine();
        int res = maxSub(line);
        System.out.println(res);
    }

    public static String deleteChar(String s, int j) {
        char[] str = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length; i++) {
            if (i != j) {
                sb.append(str[i]);
            }
        }

        return sb.toString();
    }

    public static int strValue(String s) {
        char[] str = s.toCharArray();
        int res = 1;
        int value = 1;
        if (str.length == 1) return res;
        for (int i = 1; i < str.length; i++) {
            if (str[i] == str[i-1]) {
                value++;
            } else {
                value = 1;
            }
            res += value;
        }

        return res;
    }

    public static int maxSub(String s) {
        Deque<String> queue = new LinkedList<>();
        Map<String, Integer> valueMap = new HashMap<>();

        queue.offerLast(s);

        int max = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String cur = queue.pollFirst();
                if (cur.length() == 1) break;
                if (valueMap.containsKey(cur)) continue;
                int sCur = strValue(cur);
                valueMap.put(cur, sCur);
                max = Math.max(max, sCur);

                for (int j = 0; j < cur.length(); j++) {
                    if (cur.length() == 1) continue;
                    String subCur = deleteChar(cur, j);
                    if (!valueMap.containsKey(subCur)) {
                        queue.offerLast(subCur);
                    }
                }
            }
        }
        return max;
    }
}
