package com.OJ.WeBank;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
三角形路径
* 题目描述: 一定数目的点或圆在等距离的情况下可以形成一个等边三角形, 这样的数称为三角形数.
如: 1, 3, 6
* 第i行有i个数, 位置居中对齐. 显然, 除了最后一行的点, 每个点的下方都有两个点与它相邻,
    本体并不是求三角形数的问题, 而是与这个性质有关.
      .         1
     ..         3
    ...         6
* 给你若干个点, 按照上图中的方式排列(保证排满, 即点的个数是三角形数).
    你一开始位于第一行的点, 身上带有一个数1. 然后你要一行一行地往下走,
    每一步可以走到下方的两个相邻点中的一个, 走 n-1 步 可到达终点(底部).
    除了第一行的点以外, 每个点上带上一个效果, 它可能是如下几种中的一种:
        +x: 使你身上的数加x
        -x: 使你身上的数减x
        /x: 使你身上的数除以x, 向远离0的方向上取整: 正数向上, 负数向下
        s: 如果你身上的数为正数, 则开平方根, 向上取整.
            如果为负数, 则取相反数, 进行如上操作, 再取相反数: 如8经过s操作变为3, -8则变为-3.
        n: 使你身上的数变为它的相反数, 即乘-1
    显然, 从起点到一个点的路径并不是唯一的, 到这个点时身上的值也不一定唯一.
    你的任务是计算以最后一行的每个点为终点, 可能的最大值和最小值.
* 输入:
  第一行一个正数 n，表示三角形的层数。(n <= 400)
    后面 n*(n+1)-1 行，每行有 “+ x” “- x” “/ x” “s” “n” 中的一种，
    运算符和数之间有一个空格，作用详见问题描述，
        按从上到下，从左到右的顺序表示
        除第一行以外的各点上的效果。
    (0 < x <= 1000000000)
* */

public class Main2 {
    public static void main(String[] args) {

        Scanner reader = new Scanner(System.in);
        int n = reader.nextInt(); //三角形的层数
        // 一开始位于第一行的点, 身上有一个数 1
        int start = 1;
        // 走 n-1 步到达终点
        int resNums = returnNum(n) - 1; //剩余数目
        List<String[]> list = new ArrayList<>();
        for (int i = 0; i < resNums; i++) {
            String str = reader.nextLine();
            list.add(str.trim().split(" "));
        }
        reader.close();

        for (int i = 0; i < list.size(); i++) {
            int result = doOperator(list.get(i), start);
            System.out.println(result);
        }
    }

    // 计算三角形数
    private static int returnNum(int n) {
        if (n == 1) return 1;
        return n + returnNum(n-1);
    }

    private static int doOperator(String[] str, int y) {
        int len = str.length;
        String op = str[0];
        int result = 0;
        if (len > 1) {
            int x = Integer.valueOf(str[1]);
            if ("+".equals(op)) return y + x;
            if ("-".equals(op)) return y - x;
            if ("/".equals(op)) {
                double res = (double)y / (double) x;
                if (res > 0)
                    result = (int) Math.ceil(res);
                else
                    result = (int) Math.floor(res);
            }

        } else {
            if ("n".equals(op)) {
                result = (-1) * Integer.valueOf(op);
            }

            if ("s".equals(op)) {
                // 如果的身上的数为正数，则开平方根，向上取整。
                if (y >= 0) {
                    result = doSqrt(y);
                } else { //如果为负数，则取相反数，进行如上操作，再取相反数
                    // 如 8 经过 s 操作为 3，-8 则变为 -3
                    result = (-1)*doSqrt(-y);
                }
            }
        }

        return result;
    }

    private static int doSqrt(int y) {
        double temp = Math.sqrt(y);

        return  (int)Math.ceil(temp);
    }
}
