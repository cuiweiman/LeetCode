package com.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 * 示例：
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 * </p>
 *
 * @description: 两数之和
 * @date: 2020/8/29 23:27
 * @author: wei·man cui
 */
public class LeetCode001 {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        // int[] result = twoSum(nums, target);
        // int[] result = twoSumHashMapTwice(nums, target);
        int[] result = twoSumHashMapOnce(nums, target);
        System.out.println(Arrays.toString(result));
    }

    /**
     * 将数组放到Map中，在判断差是否存在Map中。边放到Map边判断
     *
     * @param nums   数组
     * @param target 目标
     * @return 结果
     */
    public static int[] twoSumHashMapOnce(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[]{i, map.get(complement)};
            }
        }
        throw new RuntimeException("no two sum solution");
    }

    /**
     * 将数组放到Map中，在判断差是否存在Map中。先放到Map再判断
     *
     * @param nums   数组
     * @param target 目标
     * @return 结果
     */
    public static int[] twoSumHashMapTwice(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[]{i, map.get(complement)};
            }
        }
        throw new RuntimeException("no two sum solution");
    }


    /**
     * 暴力破解
     *
     * @param nums   数组
     * @param target 目标
     * @return 结果
     */
    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int add = nums[i] + nums[j];
                if (add == target) {
                    result[0] = i;
                    result[1] = j;
                }
            }
        }
        return result;
    }
}
