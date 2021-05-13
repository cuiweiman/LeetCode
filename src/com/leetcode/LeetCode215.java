package com.leetcode;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/kth-largest-element-in-an-array/
 *
 * @description: 数组中的第K个最大元素
 * @author: wei·man cui
 * @date: 2021/5/13 16:37
 */
public class LeetCode215 {

    /**
     * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
     */
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    /**
     * 先排序，后 获取数值
     *
     * @param nums 数组
     * @param k    k
     * @return 结果
     */
    public int findKthLargest2(int[] nums, int k) {
        final int[] sort = quickSort(nums, 0, nums.length - 1);
        // System.out.println(Arrays.toString(sort));
        return nums[nums.length - k];
    }

    public int[] quickSort(int[] nums, int start, int end) {
        if (start < end) {
            int standard = nums[start];
            int left = start;
            int right = end;
            while (left < right) {
                while (left < right && standard < nums[right]) {
                    right--;
                }
                nums[left] = nums[right];
                while (left < right && standard >= nums[left]) {
                    left++;
                }
                nums[right] = nums[left];
            }
            nums[left] = standard;
            quickSort(nums, start, left - 1);
            quickSort(nums, right + 1, end);
        }
        return nums;
    }

    /**
     * nums：[3,2,1,5,6,4]
     * k：2
     * res：5
     * nums：[3,2,3,1,2,4,5,5,6]
     * k：4
     * res：4
     *
     * @param args 参数
     */
    public static void main(String[] args) {
        LeetCode215 demo = new LeetCode215();
        int[] nums = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        int k = 4;
        long start = System.currentTimeMillis();

        // final int result = demo.findKthLargest(nums, k);
        final int result = demo.findKthLargest2(nums, k);

        System.out.println("耗时：" + (System.currentTimeMillis() - start) + " 结果为：" + result);
    }
}
