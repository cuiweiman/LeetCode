package com.niuke.huawei.hj;

import java.util.Scanner;

/**
 * 输入一个整数（int类型），返回这个数转换成2进制后，输出1的个数
 *
 * @description: 输入一个int型的正整数，计算出该int型数据在内存中存储时1的个数。
 * @author: wei·man cui
 * @date: 2021/3/26 14:47
 */
public class Hj015 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            final int input = sc.nextInt();
            final String s = Integer.toBinaryString(input);
            final char[] chars = s.toCharArray();
            int count = 0;
            for (char aChar : chars) {
                if (aChar == 49) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}
