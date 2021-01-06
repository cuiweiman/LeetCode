package com.leetcode.bishi.数宇政通;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * <p>
 * 输入一个字符串，判断是否完全循环，若是则输出最小循环子串，否则输出自身。
 * 输入：abababab，完全循环子串有：abab，ab，最短的是 ab，因此输出ab；
 * 输入：abcabcab，没有完全循环子串，输出自身abcabcab。
 * </p>
 *
 * @description: 最小循环子串
 * @date: 2020/9/20 20:09
 * @author: wei·man cui
 */
public class MinLoopSubString {

    /**
     * 判断 重复
     *
     * @param in 输入
     * @return 输出
     */
    public static Set<String> getMinLoop(String in) {
        Set<String> set = new HashSet<>();
        if (in == null || in.length() <= 0) {
            return set;
        } else if (in.length() <= 3) {
            set.add(in);
            return set;
        } else {
            for (int i = 0; i < in.length(); i++) {
                for (int j = i + 1; j < in.length(); j++) {
                    // 循环获取子串
                    String t = in.substring(i, j);
                    if (in.replace(t, "").length() == 0) {
                        // 放入集合中
                        set.add(t);
                    }
                }
            }
            return set;
        }
    }


    public static void main(String[] args) {
        String in = "abcabcabcabcabc";
        List<String> list = new ArrayList<>(getMinLoop(in));

        if (list.size() == 0) {
            // 不是一个循环串，输出自身
            System.out.println(in);
        } else {
            // 有循环串，找出最小循环串
            int index = 0;
            int min = list.get(0).length();
            for (int i = 0; i < list.size(); i++) {
                if (min > list.get(0).length()) {
                    min = list.get(0).length();
                    index = i;
                }
            }
            System.out.println(list.get(index));
        }
    }
}
