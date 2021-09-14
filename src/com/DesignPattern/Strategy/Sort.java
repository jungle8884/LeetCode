package com.DesignPattern.Strategy;

public class Sort implements ISort{
    private ISort sort;

    Sort(ISort sort) {
        this.sort = sort;
    }


    @Override
    public void sort(int[] arr) {
        sort.sort(arr);
    }

    // 设置采用哪种算法
    public void setSort(ISort sort){
        this.sort = sort;
    }
}
