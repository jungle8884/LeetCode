package com.OJ.HaLuo;

import java.util.Scanner;

public class Test3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(winnerSquareGame(n));
    }

    // 1510. 石子游戏 IV
    // https://leetcode-cn.com/problems/stone-game-iv/solution/shi-zi-you-xi-iv-by-leetcode-solution/
    /*
    * Alice 和 Bob 两个人轮流玩一个游戏，Alice 先手。
    * 一开始，有 n 个石子堆在一起。每个人轮流操作，正在操作的玩家可以从石子堆里拿走 任意 非零 平方数 个石子。
    * 如果石子堆里没有石子了，则无法操作的玩家输掉游戏。
    * 给你正整数 n ，且已知两个人都采取最优策略。
    * 如果 Alice 会赢得比赛，那么返回 True ，否则返回 False 。
    * */
    public static boolean winnerSquareGame(int n) {
        boolean[] res = new boolean[n+1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j*j <= i; j++) {
                // res[i] 表示先手在面对 i 颗石子时 是否 处于必胜态（会赢得比赛）
                // 当且仅当存在某个 res[i-j*j]为 必败态 (输掉比赛):
                //          也就是说，当先手在面对 i 颗石子时，可以选择取走 j*j 颗，
                //          剩余的 i-j*j 颗对于后手来说是必败态，因此先手会获胜
                // 说明: 默认为false, 取非表示存在某个 res[i-j*j]
                // eg: n=1, res[1-1*1] 表示存在res[0] 即 没有石子了, Bob输掉比赛, 此时res[1] = true, Alice 获胜.
                // n=2, res[2-1*1] 即 res[1], 此时 res[1] = true, 取非表示 Bob 拿到, Alice输掉比赛.
                // 依次递推, dp解决问题!
                if (!res[i-j*j]) {
                    res[i] = true;
                    break;
                }
            }
        }

        return res[n];
    }
}
