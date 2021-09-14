package com.DesignPattern.Strategy;

// 稳定的
public class BubbleSort implements ISort{
    @Override
    public void sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length-1-i; j++) {
                if (arr[j] > arr[j+1]) {
                    Utils.swap(arr, j, j+1);
                }
            }
        }
    }
}
