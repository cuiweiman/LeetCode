package com.leetcode;

/**
 * 1. num1 和num2 的长度都小于 5100
 * 2. num1 和num2 都只包含数字 0-9
 * 3. num1 和num2 都不包含任何前导零
 * 4. 你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式
 *
 * @description: 字符串相加
 * @date: 2021/4/10 21:48
 * @author: wei·man cui
 */
public class LeetCode415 {

    public static void main(String[] args) {
        LeetCode415 demo = new LeetCode415();
        String res = demo.addStrings("567", "321");
        System.out.println(res);
    }

    public String addStrings(String num1, String num2) {
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int add = 0;
        StringBuilder builder = new StringBuilder();
        while (i >= 0 || j >= 0 || add != 0) {
            int x = i >= 0 ? num1.charAt(i) - '0' : 0;
            int y = j >= 0 ? num2.charAt(j) - '0' : 0;
            int result = x + y + add;
            add = result / 10;
            builder.append(result % 10);
            i--;
            j--;
        }
        return builder.reverse().toString();
    }

}
