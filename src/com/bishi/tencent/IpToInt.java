package com.bishi.tencent;

/**
 * @description: 字符串ip转数字
 * @date: 2021/3/22 21:17
 * @author: wei·man cui
 */
public class IpToInt {

    public static void main(String[] args) {
        String ip = "192.168.0.1";
        String[] split = ip.split("\\.");
        System.out.println((Long.parseLong(split[0]) << 24) + (Long.parseLong(split[1]) << 16)
                + (Long.parseLong(split[2]) << 8) + (Long.parseLong(split[3])));
    }

}
