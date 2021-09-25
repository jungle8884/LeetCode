package com.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Jungle
 */
public class Permute47 {
    public static void main(String[] args) {
        int[] nums = new int[] {1, 2, 3};
        System.out.println(Arrays.toString(new Permute47()
                .permute(nums).toArray()));
    }

    /**存放符合条件结果的集合*/
    List<List<Integer>> result = new ArrayList<>();

    /**用来存放符合条件结果*/
    LinkedList<Integer> path = new LinkedList<>();

    boolean[] used;

    /**
     * 求数组的全排列*/
    public List<List<Integer>> permute(int[] nums) {
        if (nums.length == 0){
            return result;
        }

        used = new boolean[nums.length];
        Arrays.fill(used, false);
        Arrays.sort(nums);

        backtrack(nums);
        return result;
    }

    private void backtrack(int[] nums){
        if (path.size() == nums.length){
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++){
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }
            //如果同⼀树⽀nums[i]没使⽤过开始处理
            if (used[i] == false) {
                used[i] = true;
                path.add(nums[i]);
                backtrack(nums);
                path.remove(path.size() - 1);
                used[i] = false;
            }
        }
    }
}
