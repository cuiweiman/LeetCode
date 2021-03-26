package com.niuke.huawei.nc;

/**
 * https://www.nowcoder.com/company/home/code/239?codeType=1
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。
 * 求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 * <p>
 * 思路：逆向思维
 * 从第n阶台阶向下跳，跳到n-1阶有 1种跳法，跳到n-2阶有2种跳法。所以 f(n) = f(n-1) + f(n-2)
 * 即：斐波那契数列。
 *
 * @description: 跳台阶
 * @author: wei·man cui
 * @date: 2021/3/26 9:22
 */
public class Nc068 {

    /**
     * 递归
     */
    public int jumpFloor(int target) {
        if (target <= 1) {
            return 1;
        }
        return jumpFloor(target - 1) + jumpFloor(target - 2);
    }


    /**
     * 动态规划 解法.
     *
     * @param target n节台阶。n过大时可以使用 long类型
     * @return 结果
     */
    public int jumpFloor2(int target) {
        int[] dp = new int[target + 1];
        dp[0] = dp[1] = 1;
        for (int i = 2; i <= target; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[target];
    }

    public static void main(String[] args) {
        Nc068 nc068 = new Nc068();
        final int result = nc068.jumpFloor2(100);
        System.out.println(result);
    }
}
