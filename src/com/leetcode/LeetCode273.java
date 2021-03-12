package com.leetcode;

/**
 * <p>输入：num = 123
 * 输出："One Hundred Twenty Three"
 *
 * <p>输入：num = 12345
 * 输出："Twelve Thousand Three Hundred Forty Five"
 *
 * <p>输入：num = 1,234,567
 * 输出："One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
 *
 * <p>输入：num = 1,234,567,891
 * 输出："One Billion Two Hundred Thirty Four Million Five Hundred Sixty Seven Thousand Eight Hundred Ninety One"
 *
 * @description: 将非负整数 num 转换为其对应的英文表示。
 * @author: wei·man cui
 * @date: 2021/3/12 10:29
 */
public class LeetCode273 {

    private static final String[] LESS_THAN_TWENTY = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine",
            "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};

    private static final String[] HUNDRED = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

    private static final String[] THOUSAND = {"Hundred", "Thousand", "Million", "Billion"};

    public static String helps(int num) {
        if (num == 0) {
            return "";
        } else if (num < 20) {
            return " " + LESS_THAN_TWENTY[num];
        } else if (num < 100) {
            return " " + HUNDRED[num / 10] + helps(num % 10);
        } else if (num < 1000) {
            return " " + LESS_THAN_TWENTY[num / 100] + " " + THOUSAND[0] + helps(num % 100);
        }
        for (int i = 1; i <= 3; i++) {
            if (num < Math.pow(1000, i + 1)) {
                return helps(num / (int) Math.pow(1000, i)) + " " + THOUSAND[i] + helps(num % (int) Math.pow(1000, i));
            }
        }
        return "";
    }

    public static String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }
        return helps(num).trim();
    }

    public static void main(String[] args) {
        System.out.println(numberToWords(50868));
    }

}
