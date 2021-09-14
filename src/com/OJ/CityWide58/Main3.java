package com.OJ.CityWide58;

public class Main3 {
    public static void main(String[] args) {

    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param heros int整型一维数组 英雄池，// 0-中单 1-上路  2-打野 3-下路 4-辅助
     * @return int整型
     */
    public static int getTeams (int[] heros) {
        // write code here
        int[] heroNums = new int[5];
        for(int num : heros) {
            heroNums[num]++;
        }

        int res = 1;
        for (int i = 0; i < heroNums.length; i++) {
            res *= heroNums[i];
        }

        return res;
    }
}
