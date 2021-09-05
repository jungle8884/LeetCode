package com.OJ.WeBank;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int yearStart = reader.nextInt();
        int yearEnd = reader.nextInt();
        int count = 0;

        // yearStart 的 1月 到 yearEnd 的 12 月 有多少个月份的第一天是星期一
        for (int i = yearStart; i <= yearEnd; i++) {
            for (int j = 1; j <= 12; j++) {

                int y = i, m = j;
                // 特殊处理
                if (j == 1 || j == 2) {
                    m += 12;
                    y--;
                }
                // Day = 1
                int result = (1 + 2*m + 3*(m+1)/5 + y + y/4 - y/100 + y/400) % 7;

                // 0 代表星期1
                if (result == 0) {
                    count++;
                }
            }
        }

        System.out.println(count);
    }

    /*  蔡勒（Zeller）公式:
    *   Week=(Day + 2*Month + 3*(Month+1）/5 + Year + Year/4 - Year/100 + Year/400) % 7
    *   0 是 星期1;
    *   1-星期2，2-星期3，3-星期4，4-星期5，5-星期6，6-星期日;
     * */
    public static int calcWeek(int year, int month, int day) {
        int result = (day + 2*month + 3*(month+1)/5
                + year + year/4 - year/100 + year/400) % 7;

        return result;
    }
}
