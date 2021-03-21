package com.niuke.huawei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @description: 字符串反转
 * @date: 2021/3/21 17:33
 * @author: wei·man cui
 */
public class Hj012 {
    public static void main(String[] args) throws IOException {
        InputStream in = System.in;
        int len;
        byte[] b = new byte[1024];
        while ((len = in.read(b)) > 0) {
            String str = new String(b, 0, len - 1);
            char[] chars = str.toCharArray();
            int length = chars.length;
            char[] charsB = new char[chars.length];
            for (int i = 0; i < length; i++) {
                charsB[i] = chars[length - 1 - i];
            }
            System.out.println(new String(charsB));
        }
    }

    public static void solve1() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        for (int i = input.length() - 1; i >= 0; i--) {
            System.out.print(input.charAt(i));
        }
        System.out.println();
    }
}
