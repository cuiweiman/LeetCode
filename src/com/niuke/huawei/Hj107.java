package com.niuke.huawei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @description: 求解立方根，不能使用 库函数
 * @date: 2021/3/21 15:46
 * @author: wei·man cui
 */
public class Hj107 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String readLine = br.readLine();
        double input = Double.parseDouble(readLine);
        System.out.println(liFang(input));
    }

    /**
     * 牛顿迭代法
     *
     * @param a 入参
     * @return 结果
     */
    public static String liFang(double a) {
        double result = 0;
        if (a == 0 || a == 1 || a == -1) {
            result = a;
        } else {
            double num1;
            num1 = a;
            result = num1 * 2 / 3 + a / (num1 * num1 * 3);
            double last = result - num1 > 0 ? result - num1 : num1 - result;
            while (last > 0.000001) {
                last = result - num1 > 0 ? result - num1 : num1 - result;
                num1 = result;
                result = num1 * 2 / 3 + a / (num1 * num1 * 3);
            }
        }
        return String.format("%.1f", result);
    }

}
