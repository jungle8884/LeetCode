package com.OJ.CityWide58;

import java.util.*;

public class Main2 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        String line = reader.nextLine();
        int k = line.length()-1;
        char c;
        int[] status = new int[2];
        int index = 1;
        while ((c = line.charAt(k)) != ']') {
            Stack<Character> stack = new Stack<>();
            while (c != ',') {
                stack.push(c);
                k--;
                c = line.charAt(k);
            }
            k--;
            StringBuilder sb = new StringBuilder();
            while (!stack.isEmpty()) {
                sb.append(stack.pop());
            }
            if (index >= 0) {
                status[index--] = Integer.valueOf(sb.toString());
            }
        }
        int arrayLen = status[0];
        int subArrayLen = status[1];
        int[] Array = Arrays.stream(line.substring(0, k).replace('[', ' ')
                .replace(']', ' ').trim()
                .split(",")).mapToInt((s)->{
            return Integer.valueOf(s);
        }).toArray();
//        System.out.println(arrayLen);
//        System.out.println(subArrayLen);
//        System.out.println(Arrays.toString(Array));

        int[] res = subArraySum(Array, arrayLen, subArrayLen);
        System.out.println(Arrays.toString(res));
    }

    // 子数组求和
    // [1,2,30,4,5,6,7,8,9,10],10,3
    public static int[] subArraySum (int[] Array, int arrayLen, int subArrayLen) {
        // write code here
        int k = subArrayLen-1;
        int[] sum = new int[arrayLen+1];
        Map<Integer, Integer> map = new HashMap<>();
        // 统计当前位置为止的数组之和
        for (int i = 1; i <= arrayLen; i++) {
            sum[i] = sum[i-1] + Array[i-1];
        }

        int max = 0, maxi = 0;
        for (int i = 0; i < arrayLen - 1 - k; i++) {
            int res = sum[i+k+1] - sum[i];
            if (res > max) {
                max = res;
                maxi = i;
            }
        }

        return new int[]{maxi, max};
    }
}
