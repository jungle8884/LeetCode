package com.OJ.ShenXinFu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        String[] strs = reader.nextLine()
                .replace('[', ' ')
                .replace(']', ' ')
                .trim().split(",");
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < strs.length; i++) {
            list.add(strs[i].replace('"', ' ').trim());
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        merge(list);
    }


    public static ArrayList<String> merge (ArrayList<String> input) {
        ArrayList<ArrayList<String>> arrays = new ArrayList<>();
        // write code here
        for (int i = 0; i < input.size(); i++) {
            String during = input.get(i);
            ArrayList<String> tmp;
            if (during.contains("-")) {
                int indexSplit = during.charAt('-');
                tmp = new ArrayList<>();
                String left = during.substring(0, indexSplit);
                String right = during.substring(indexSplit+1);
                if (left.equals(right)) {
                    tmp.add(left);
                } else {
                    tmp.add(left);
                    tmp.add(right);
                }
                arrays.add(tmp);
            } else {
                tmp = new ArrayList<>();
                tmp.add(during);
                arrays.add(tmp);
            }
        }



        return new ArrayList<>(0);
    }
}
