package com.bishi.tencent;

import java.util.Stack;

/**
 * @description: 字符串括号匹配
 * @date: 2021/3/27 21:00
 * @author: wei·man cui
 */
public class Demo2 {
    public static void main(String[] args) {
        String input = "asdf(asdffds)afdadsf {asfasf d}";
        String input2 = "asd{f(asd}ffds)afdadsf {asfasf d}";
        System.out.println(check(input));
    }

    public static boolean check(String str) {
        char[] chars = str.toCharArray();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(' || chars[i] == '{') {
                stack.push(chars[i]);
            } else if (chars[i] == ')') {
                if (stack.peek() != '(') {
                    return false;
                } else {
                    stack.pop();
                }
            } else if (chars[i] == '}') {
                if (stack.peek() != '{') {
                    return false;
                } else {
                    stack.pop();
                }
            }
        }
        return stack.isEmpty();
    }

}
