package com.niuke.huawei;

import java.util.Scanner;

/**
 * 参考：https://www.bilibili.com/video/BV1K4411X766
 *
 * @description: 购物单——未解决
 * @date: 2021/3/19 20:42
 * @author: wei·man cui
 */
public class Hj016 {

    public static void main(String[] args) {
        // easy();

        Scanner in = new Scanner(System.in);
        int capacity = in.nextInt();
        int size = in.nextInt() + 1;
        int[] weight = new int[size];
        int[] value = new int[size];
        int[] p = new int[size];
        for (int i = 1; i < size; i++) {
            weight[i] = in.nextInt();
            value[i] = in.nextInt();
            p[i] = in.nextInt();
        }
        System.out.println(shopping(capacity, size, weight, value, p));
    }

    public static int shopping(int capacity, int size, int[] weight, int[] value, int[] p) {
        // db[0][y]和db[x][0] 补 0
        int[][] db = new int[size][capacity + 1];
        // 按编号顺序，放入为1，没放入为0
        int[] exists = new int[size - 1];
        for (int i = 1; i < size; i++) {
            for (int j = 10; j < capacity; j += 10) {
                int realWeight = weight[i];
                if (p[i] > 0 && p[i] > i) {
                    realWeight = realWeight + weight[p[i]];
                }
                if (realWeight > j) {
                    // 体积大于背包容量，i 号物品不放入背包
                    db[i][j] = db[i - 1][j];
                } else {
                    int putResult = db[i - 1][j - realWeight] + value[i];
                    if (db[i - 1][j] > putResult) {
                        // 第 i 号商品放入背包后，价值反而变小了，那么就不放入
                        db[i][j] = db[i - 1][j];
                    } else {
                        // 否则就放入
                        db[i][j] = putResult;
                        exists[i - 1] = 1;
                    }
                }
            }
        }
        int result = 0;
        for (int i = 0; i < exists.length; i++) {
            if (exists[i] == 1) {
                result = result + weight[i + 1] * value[i + 1];
            }
        }
        return result;
    }


    /**
     * 先做个简单的动态规划的0-1背包问题
     * 背包容量：8
     * 物品编号：1 2 3 4
     * 物品体积：2 3 4 5
     * 物品价值：3 4 5 6
     */
    public static void easy() {
        int capacity = 8;
        int[] weight = {0, 2, 3, 4, 5};
        int[] value = {0, 3, 4, 5, 6};
        int[][] dp = new int[5][capacity + 1];
        for (int i = 1; i < weight.length; i++) {
            for (int j = 1; j <= capacity; j++) {
                if (weight[i] > j) {
                    // 第n个物品的容量大于当前体积，则价值等于前n-1个物品的价值
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i]] + value[i]);
                }
            }
        }
        System.out.println(dp[4][8]);
    }

}
