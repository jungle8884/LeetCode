package com.OJ.XiaoMaZhiXing;

import sun.awt.image.ImageWatched;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        String line = reader.nextLine();
        int res = doTest3(line);
        System.out.println(res);
    }

    private static int doTest3(String line) {
        Deque<Character> queue = new ArrayDeque<>();
        for (int i = 0; i < line.length(); i++) {
            queue.addLast(line.charAt(i));
        }

        String s = "pony";
        int start = 0;
        int end = s.length();

        int count = 0;
        while (end != queue.size()) {
            if ("pony".equals(line.substring(start, end))) {
                count++;
                System.out.println(line);
                line = line.substring(0, start) + line.substring(end);
                start--;
                end--;
            }
            start++; end++;
        }
        if ("pony".equals(line.substring(start, end))) count++;
        return count;
    }
}
