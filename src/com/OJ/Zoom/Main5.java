package com.OJ.Zoom;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Main5 {
    public static void main(String[] args) {

    }

    public int find132Pattern (int[] nums) {
        int len = nums.length;
        int cnt = 0;
        Deque<Integer> queue = new ArrayDeque<>();
        int max = Integer.MAX_VALUE;
        for (int i = len-1; i >= 0; i--) {
            if (nums[i] < max) cnt++;
            while (!queue.isEmpty() && queue.peekLast() < nums[i]) {
                max = Math.max(max, queue.pollLast());
            }
            queue.addLast(nums[i]);
        }

        return cnt;
    }

    public int[] slideWindow (int[] nums, int windowSize, int step) {
        if (nums == null || nums.length < 2) return nums;
        Deque<Integer> queue = new LinkedList<>();
        int[] res = new int[nums.length-windowSize+1];
        for (int i = 0; i < nums.length; i++) {
            while (!queue.isEmpty() && nums[queue.peekLast()] <= nums[i]) {
                queue.pollLast();
            }
            queue.addLast(i);
            if (queue.peek() <= i-windowSize) queue.poll();
            if (i+1 >= step) res[i+1-windowSize] = nums[queue.peek()];
        }

        return res;
    }
}
