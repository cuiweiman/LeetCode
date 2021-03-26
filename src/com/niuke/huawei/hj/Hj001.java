package com.niuke.huawei.hj;

import java.io.IOException;
import java.io.InputStream;

/**
 * @description: 计算字符串最后一个单词的长度，单词以空格隔开
 * @date: 2021/3/19 20:23
 * @author: wei·man cui
 */
public class Hj001 {
    public static void main(String[] args) throws IOException {
        // System.out.println(length("hello nowcoder"));
        length2();
    }

    public static Integer length(String str) {
        String[] strings = str.split(" ");
        return strings[strings.length - 1].length();
    }

    public static void length2() throws IOException {
        int times = 0;
        InputStream in = System.in;
        char c = (char) in.read();
        while (c != '\n') {
            if (c == ' ') {
                times = 0;
            } else {
                times += 1;
            }
            c = (char) in.read();
        }
        System.out.println(times);
    }
}
