package com.leetcode;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * @description: Rand7() 生成 Rand10()，要 均匀随机整数
 * @date: 2021/4/11 20:02
 * @author: wei·man cui
 */
public class LeetCode470 {
    public static void main(String[] args) {
        LeetCode470 demo = new LeetCode470();
        int[] ints = demo.rand10(10);
        List<Integer> list = Arrays.stream(ints).boxed().collect(Collectors.toList());
        System.out.println(list);
    }

    public int[] rand10(int num) {
        int[] res = new int[num];
        for (int i = 0; i < num; i++) {
            res[i] = doRand10();
        }
        return res;
    }

    public int doRand10() {
        int col;
        int row;
        int res;
        do {
            col = rand7();
            row = rand7();
            res = col + (row - 1) * 7;
        } while (res > 40);
        return 1 + (res - 1) % 10;
    }

    public int rand7() {
        Random random = new Random();
        return random.nextInt(7) + 1;
    }
}
