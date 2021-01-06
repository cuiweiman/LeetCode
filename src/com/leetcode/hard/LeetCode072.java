package com.leetcode.hard;

/**
 * <p>
 * 给你两个单词 word1 和 word2，请你计算出将 word1 转换成 word2 所使用的最少操作数 。
 * 你可以对一个单词进行如下三种操作：插入一个字符；删除一个字符；替换一个字符。
 * </p>
 * <实例1>
 * 输入：word1 = "horse", word2 = "ros"
 * 输出：3
 * 解释：
 * horse -> rorse (将 'h' 替换为 'r')
 * rorse -> rose (删除 'r')
 * rose -> ros (删除 'e')
 * </实例1>
 * <实例2>
 * 输入：word1 = "intention", word2 = "execution"
 * 输出：5
 * 解释：
 * intention -> inention (删除 't')
 * inention -> enention (将 'i' 替换为 'e')
 * enention -> exention (将 'n' 替换为 'x')
 * exention -> exection (将 'n' 替换为 'c')
 * exection -> execution (插入 'u')
 * </实例2>
 * <解析>
 * word1 变 word2，或者 word2 变 word1：
 * 1. word1 插入一个字符 <==> word2 删除一个字符
 * 2. word1 删除一个字符 <==> word2 插入一个字符
 * 3. word1 替换一个字符 <==> word2 替换一个字符
 * 虽然有六条，但是两两对应重复，可归纳为：
 * A. 向 word1 插入一个字符；
 * B. 向 word2 插入一个字符；
 * C. 替换 word1 一个字符
 * <p>
 * ————————————————————|
 * |   | # | R | O | S |
 * ————————————————————|
 * | # | 0 | 1 | 2 | 3 |
 * ————————————————————|
 * | H | 1 | 1 | 2 | 3 |
 * ————————————————————|
 * | O | 2 | 2 | 1 | 2 |
 * ————————————————————|
 * | R | 3 | 3 | 2 | 2 |
 * ————————————————————|
 * | S | 4 | 4 | 3 | 2 |
 * ————————————————————|
 * | E | 5 | 5 | 4 | 3 |
 * ————————————————————|
 * <p>
 * 1. 从纵轴来看，H 变 R 需要 1步（H替换R）；
 * 2. HO 变 R 需要 2 步（H替换R，删去O）。
 * …………………………省略n行
 * N+2. H 变 RO 需要 2 步 （H替换R，增加O）;
 * ………………………省略m行
 * M+3. HORSE 变 RO 需要 4 步（H替换R，删去R、S、E）
 * M+4. HORSE 变 ROS 需要 3步 （H替换R，删去 R、S）
 * </解析>
 *
 * @description: 编辑距离
 * @author: wei·man cui
 * @date: 2021/1/6 17:21
 */
public class LeetCode072 {

    public static void main(String[] args) {
        String word1 = "horse";
        String word2 = "ros";
        int minDistance = minDistance(word1, word2);
        System.out.println(word1 + " compareTo " + word2 + " = " + minDistance);
    }

    public static int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        if (n * m == 0) {
            return n + m;
        }

        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= m; j++) {
            dp[0][j] = j;
        }

        int temp;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    temp = 0;
                } else {
                    temp = 1;
                }
                dp[i][j] = min(dp[i - 1][j] + 1, dp[i][j - 1] + 1, dp[i - 1][j - 1] + temp);
                System.out.println(dp[i][j]);
            }
        }
        return dp[n][m];
    }

    public static int min(int... args) {
        int min = Integer.MAX_VALUE;
        for (int arg : args) {
            if (min > arg) {
                min = arg;
            }
        }
        return min;
    }

}
