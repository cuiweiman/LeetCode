package com.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * TinyURL是一种 URL简化服务， 比如：当你输入一个 URL https://leetcode.com/problems/design-tinyurl 时，
 * 它将返回一个简化的 URL http://tinyurl.com/4e9iAk。
 * <p>
 * 要求：设计一个 TinyURL 的加密 encode 和解密 decode 的方法。你的加密和解密算法如何设计和运作是没有限制的，
 * 你只需要保证一个 URL可以被加密成一个 TinyURL，并且这个 TinyURL可以用解密方法恢复成原本的 URL。
 *
 * @description: TinyURL的加密与解密
 * @author: wei·man cui
 * @date: 2021/3/12 10:03
 */
public class LeetCode535 {

    private static Map<Integer, String> map = new HashMap<>();
    private static final String TINY_RUL_PREFIX = "http://tinyurl.com/";

    public static String encode(String longUrl) {
        Integer hashCode = longUrl.hashCode();
        if (hashCode < 0) {
            hashCode = 0 - hashCode;
        }
        map.put(hashCode, longUrl);
        return TINY_RUL_PREFIX + hashCode;
    }

    public static String decode(String shortUrl) {
        final String replace = shortUrl.replace(TINY_RUL_PREFIX, "");
        return map.get(Integer.valueOf(replace));
    }

    public static void main(String[] args) {
        String url = "https://leetcode.com/problems/design-tinyurl";
        final String encode = encode(url);
        final String decode = decode(encode);
        System.out.println(encode);
        System.out.println(decode);
    }
}

