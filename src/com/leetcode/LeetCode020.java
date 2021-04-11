package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

/**
 * @description: 字符串 括号匹配
 * @date: 2021/4/11 18:40
 * @author: wei·man cui
 */
public class LeetCode020 {

    public static void main(String[] args) {
        LeetCode020 demo = new LeetCode020();
        boolean valid = demo.isValid2("((");
        System.out.println(valid);
    }

    public boolean isValid2(String s) {
        List<Character> left = new ArrayList<>(3);
        left.add('(');
        left.add('[');
        left.add('{');
        List<Character> right = new ArrayList<>(3);
        right.add(')');
        right.add(']');
        right.add('}');
        Stack<Character> stack = new Stack<>();

        char[] chs = s.toCharArray();
        for (char ch : chs) {
            if (left.contains(ch)) {
                stack.push(ch);
                continue;
            }
            if (right.contains(ch) && !stack.isEmpty()) {
                Character pop = stack.pop();
                if (left.indexOf(pop) != right.indexOf(ch)) {
                    return false;
                }
            } else if (right.contains(ch)) {
                return false;
            }
        }
        return stack.isEmpty();
    }

    public boolean isValid(String s) {
        char[] chs = s.toCharArray();

        HashMap<Character, Character> map = new HashMap<>(3);
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');

        Stack<Character> stack = new Stack<>();
        for (char ch : chs) {
            if (map.containsKey(ch)) {
                stack.push(ch);
            }
            if (map.containsValue(ch)) {
                if (!stack.isEmpty()) {
                    Character pop = stack.pop();
                    if (ch != map.get(pop)) {
                        return false;
                    }
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

}
