package com.niuke.huawei.hj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @description: 质子因数
 * @date: 2021/3/21 18:47
 * @author: wei·man cui
 */
public class Hj006 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = br.readLine()) != null) {
            long input = Long.parseLong(str);
            StringBuilder sb = new StringBuilder();
            double sqrt = Math.sqrt(input);
            for (int i = 2; i <= input; i++) {
                if (input % i == 0) {
                    sb.append(i).append(" ");
                    input = input / i;
                    i--;
                }
            }
            if (sb.toString().length() == 0) {
                sb.append(input).append(" ");
            }
            System.out.println(sb.toString());
        }
    }
}
