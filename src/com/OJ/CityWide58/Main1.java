package com.OJ.CityWide58;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int[] nums = Arrays.stream(reader.nextLine().replace('[', ' ')
                .replace(']', ' ').trim()
                .split(",")).mapToInt((s)->{
                    return Integer.valueOf(s);
        }).toArray();
        int[] res = find(nums);
        System.out.println(Arrays.toString(res));
    }

    // [1,1,4,7,7]
    public static int[] find (int[] arg) {
        // write code here
        int[] count = new int[10000];
        for (int num : arg) {
            count[num]++;
        }
        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < arg.length; i++) {
            if (count[arg[i]] == 1) {
                arr.add(arg[i]);
            }
        }
        int[] res = new int[arr.size()];
        for (int i = 0; i < arr.size(); i++) {
            res[i] = arr.get(i);
        }
        return res;
    }
}
