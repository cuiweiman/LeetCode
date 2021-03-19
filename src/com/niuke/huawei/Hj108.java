package com.niuke.huawei;

import java.util.Scanner;

/**
 * 最大公约数 =
 * 最小公倍数 = A * B / 最大公约数
 *
 * @description: 最小公倍数：正整数 A和正整数 B 的最小公倍数是指 能被A和B整除的最小的正整数值，设计一个算法，求输入A和B的最小公倍数。
 * @author: wei·man cui
 * @date: 2021/3/19 12:56
 */
public class Hj108 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        System.out.println(bei(a, b));
    }

    public static int yue(int a, int b) {
        int bigger = Math.max(a, b);
        int smaller = Math.min(a, b);
        int mod = bigger % smaller;
        while (mod != 0) {
            bigger = smaller;
            smaller = mod;
            mod = bigger % smaller;
        }
        return smaller;
    }

    public static int bei(int a, int b) {
        int yue = yue(a, b);
        return a * b / yue;
    }

}
