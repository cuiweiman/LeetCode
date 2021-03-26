package com.niuke.huawei.hj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @description: 多线程
 * @date: 2021/3/21 18:13
 * @author: wei·man cui
 */
public class Hj049 {

    public static void main(String[] args) throws IOException, InterruptedException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String readLine = reader.readLine();
        int input = Integer.parseInt(readLine);
        for (int i = 0; i < input; i++) {
            System.out.print("ABCD");
        }
        System.out.println();
    }
}
