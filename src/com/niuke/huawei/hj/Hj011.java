package com.niuke.huawei.hj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @description: 正整数颠倒输出
 * @date: 2021/3/21 20:05
 * @author: wei·man cui
 */
public class Hj011 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String read;
        while ((read = br.readLine()) != null) {
            for (int i = read.length() - 1; i >= 0; i--) {
                System.out.print(read.charAt(i));
            }
            System.out.println();
        }
    }
}
