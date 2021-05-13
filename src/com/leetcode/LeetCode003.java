package com.leetcode;

/**
 * @description: 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * @author: wei·man cui
 * @date: 2021/5/13 17:25
 */
public class LeetCode003 {

    public int lengthOfLongestSubstring(String s) {
        // 记录 字符上一次出现的位置
        int[] last = new int[128];
        for (int i = 0; i < 128; i++) {
            last[i] = -1;
        }
        int n = s.length();

        int res = 0;
        int start = 0;
        for (int i = 0; i < n; i++) {
            int index = s.charAt(i);
            start = Math.max(start, last[index] + 1);
            res = Math.max(res, i - start + 1);
            last[index] = i;
        }
        return res;
    }

    public static void main(String[] args) {
        LeetCode003 demo = new LeetCode003();
        String s = "abcabcbb";
        final int i = demo.lengthOfLongestSubstring(s);
        System.out.println(i);
    }

}
