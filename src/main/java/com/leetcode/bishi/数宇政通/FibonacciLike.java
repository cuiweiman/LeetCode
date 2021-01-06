package com.leetcode.bishi.数宇政通;

/**
 * <p>
 * 有一对小兔子，从出生后第2个月起，每个月都生一对兔子。
 * 小兔子长到第2个月后，每个月又生一对兔子。
 * 按此规律，假设没有兔子死亡，第一个月有一对刚出生的小兔子，问第n个月有多少对兔子？
 * 分析：比斐波那契的兔子繁殖能力强，少一个月，从第一个月开始，得到的兔子队列是：1  2  3  5  8  13 21 34
 * </p>
 *
 * @description: 斐波那契变形
 * @date: 2020/9/20 20:34
 * @author: wei·man cui
 */
public class FibonacciLike {
    public static void main(String[] args) {
        int item = 7;
        int result = fibonacci(item);
        int result2 = fibonacci2(item);
        System.out.println(result + " " + result2);
    }

    /**
     * 递归
     *
     * @param item 输入
     * @return 输出
     */
    public static int fibonacci(int item) {
        if (item == 1 || item == 2 || item == 3) {
            return item;
        } else if (item > 3) {
            return fibonacci(item - 1) + fibonacci(item - 2);
        } else {
            return -1;
        }
    }

    /**
     * 非递归
     *
     * @param item 输入
     * @return 输出
     */
    public static int fibonacci2(int item) {
        if (item == 1 || item == 2 || item == 3) {
            return 1;
        } else if (item > 3) {
            int f1 = 1;
            int f2 = 2;
            int result = 0;
            for (int i = 0; i <= item - 3; i++) {
                result = f1 + f2;
                f1 = f2;
                f2 = result;
            }
            return result;
        } else {
            return -1;
        }
    }
}
