package com.leetcode;

/**
 * @description: 力扣 80. 删除有序数组中的重复项 II
 * @date: 2021/4/6 20:51
 * @author: wei·man cui
 */
public class LeetCode080 {
    public static void main(String[] args) {
        LeetCode080 demo = new LeetCode080();
        int[] nums = {0, 0, 1, 1, 1, 1, 2, 3, 3};
        int len = demo.removeDuplicates(nums);
        demo.printArr(len, nums);
    }

    public int removeDuplicates(int[] nums) {
        if (nums.length < 3) {
            return nums.length;
        }
        int count = 1;
        int compare = nums[0];
        int len = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == compare) {
                count++;
                if (count >= 3) {
                    nums[len] = nums[i];
                } else {
                    nums[len] = nums[i];
                    len++;
                }
            } else {
                count = 1;
                compare = nums[i];
                nums[len] = nums[i];
                len++;
            }
        }
        return len;
    }

    public void printArr(int length, int[] nums) {
        System.out.print(length + ", nums = [");
        for (int i = 0; i < length; i++) {
            if (i < length - 1) {
                System.out.print(nums[i] + ",");
            } else {
                System.out.print(nums[i]);
            }
        }
        System.out.println("]");
    }

}
