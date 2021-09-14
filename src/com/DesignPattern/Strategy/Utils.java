package com.DesignPattern.Strategy;

public class Utils {
    /*
    * 采用异或运算交换数组中, 下标为 i和j 的元素的值
    * */
    public static void swap(int[] arr, int i, int j) {
        if (arr == null || arr.length <= 1 || i == j) return;
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }
}
