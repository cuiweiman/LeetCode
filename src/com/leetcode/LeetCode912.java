package com.leetcode;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @description: 快速排序
 * @date: 2021/4/10 21:13
 * @author: wei·man cui
 */
public class LeetCode912 {

    public static void main(String[] args) {
        int[] nums = {2, 1, 6, 5, 3};
        LeetCode912 demo = new LeetCode912();
        int[] sortArray = demo.sortArray(nums);
        List<Integer> res = Arrays.stream(sortArray).mapToObj(Integer::new).collect(Collectors.toList());
        System.out.println(res);
    }

    public int[] sortArray(int[] nums) {
        return quickSorted(nums, 0, nums.length - 1);
    }

    public int[] quickSorted(int[] nums, int start, int end) {
        if (start < end) {
            // 挖坑
            int mid = nums[start];
            int low = start;
            int high = end;
            while (low < high) {
                // 由于 mid 是从 0 开始的，因此先处理 右侧 high 的数据
                while (low < high && mid < nums[high]) {
                    // 当 右侧的数据 < 基数 mid 时，不需要处理，小->大 理应 大数在 high 侧。
                    high--;
                }
                // 当 右侧的数据 大于 基数 mid 时，将 右侧 high 的数值放在 mid 所在的位置，即 low 下标。
                nums[low] = nums[high];
                // 此时，若 low>=high，说明 nums 是逆序的。否则，右侧应该会有一个 坑（空位），即 high 下标处
                while (low < high && mid >= nums[low]) {
                    // 当 基数 mid > nums[low]时，不需要处理，小->大 理应 小数 在 low 侧
                    low++;
                }
                // 当 左侧的数 大于 基数mid时，将 low 下标的数 填到 high 下标的坑里，low 下标有空位
                nums[high] = nums[low];
            }
            // 循环最终执行到 low=high 位置，此时 low/high 为空，将 mid 基数填入
            nums[low] = mid;
            // 处理 基数 左侧的数，基数左侧的数，都比基数小
            quickSorted(nums, start, low - 1);
            // 处理 基数 右侧的数，基数右侧的数，都比基数大
            quickSorted(nums, low + 1, end);
        }
        return nums;
    }


}
