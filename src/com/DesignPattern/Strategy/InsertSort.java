package com.DesignPattern.Strategy;

// 稳定的
public class InsertSort implements ISort{

    @Override
    public void sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int j = i-1;
            int curNum = arr[i];
            while (j >= 0 && arr[j] > curNum) {
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = curNum;
        }
    }
}
