package com.niuke.huawei.hj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * IP字符串转数字：AAA.BBB.CCC.DDD = AAA*256^3 + BBB*256^2 + CCC*256 + DDD
 *
 * @description: IP分类统计
 * @date: 2021/3/21 12:54
 * @author: wei·man cui
 */
public class Hj018 {

    public static void main(String[] args) throws IOException {
        int a = 0, b = 0, c = 0, d = 0, e = 0, err = 0, pri = 0;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String str = bufferedReader.readLine();
        while (str != null && str.length() > 0) {
            String temp = str;
            int index = temp.indexOf("~");
            str = bufferedReader.readLine();
            boolean dnsJudge = dnsJudge(temp.substring(index + 1));
            String ip = temp.substring(0, index);
            if (!dnsJudge || !ipCheck(ip)) {
                err++;
                continue;
            }
            if (isA(ip)) {
                a++;
            } else if (isB(ip)) {
                b++;
            } else if (isC(ip)) {
                c++;
            } else if (isD(ip)) {
                d++;
            } else if (isE(ip)) {
                e++;
            }
            if (isPri(ip)) {
                pri++;
            }
        }
        System.out.println(a + " " + b + " " + c + " " + d + " " + e + " " + err + " " + pri);
    }

    public static boolean isA(String ipStr) {
        long ipMin = ipToNum("1.0.0.0");
        long ipMax = ipToNum("126.255.255.255");
        long ip = ipToNum(ipStr);
        return ip >= ipMin && ip <= ipMax;
    }


    public static boolean isB(String ipStr) {
        long ipMin = ipToNum("128.0.0.0");
        long ipMax = ipToNum("191.255.255.255");
        long ip = ipToNum(ipStr);
        return ip >= ipMin && ip <= ipMax;
    }


    public static boolean isC(String ipStr) {
        long ipMin = ipToNum("192.0.0.0");
        long ipMax = ipToNum("223.255.255.255");
        long ip = ipToNum(ipStr);
        return ip >= ipMin && ip <= ipMax;
    }


    public static boolean isD(String ipStr) {
        long ipMin = ipToNum("224.0.0.0");
        long ipMax = ipToNum("239.255.255.255");
        long ip = ipToNum(ipStr);
        return ip >= ipMin && ip <= ipMax;
    }


    public static boolean isE(String ipStr) {
        long ipMin = ipToNum("240.0.0.0");
        long ipMax = ipToNum("255.255.255.255");
        long ip = ipToNum(ipStr);
        return ip >= ipMin && ip <= ipMax;
    }


    public static boolean isPri(String ipStr) {
        long ipMin1 = ipToNum("10.0.0.0");
        long ipMax1 = ipToNum("10.255.255.255");
        long ipMin2 = ipToNum("172.16.0.0");
        long ipMax2 = ipToNum("172.31.255.255");
        long ipMin3 = ipToNum("192.168.0.0");
        long ipMax3 = ipToNum("192.168.255.255");
        long ip = ipToNum(ipStr);
        return ip >= ipMin1 && ip <= ipMax1 ||
                ip >= ipMin2 && ip <= ipMax2 ||
                ip >= ipMin3 && ip <= ipMax3;
    }

    public static long ipToNum(String ipStr) {
        String[] arr = ipStr.split("\\.");
        long num = 0;
        for (int i = 0; i < arr.length; i++) {
            long l = Long.parseLong(arr[i]);
            num = (long) (num + l * Math.pow(256, 3 - i));
        }
        return num;
    }


    public static long ipToNum2(String ipStr) {
        String[] arr = ipStr.split("\\.");
        return (Long.parseLong(arr[0]) << 24) + (Long.parseLong(arr[1]) << 16)
                + (Long.parseLong(arr[2]) << 8) + (Long.parseLong(arr[3]));
    }

    public static boolean ipCheck(String ip) {
        return ip.split("\\.").length == 4;
    }

    public static boolean dnsJudge(String dns) {
        String[] arr = dns.split("\\.");
        if (arr.length != 4) {
            return false;
        }
        String binary = dnsToBinary(arr);
        int firstZero = binary.indexOf("0");
        int lastOne = binary.lastIndexOf("1");
        return firstZero - lastOne == 1;
    }

    public static String dnsToBinary(String[] arr) {
        String result = "";
        for (String s : arr) {
            int anInt = Integer.parseInt(s);
            String binary = Integer.toBinaryString(anInt);
            while (binary.length() < 8) {
                binary = "0".concat(binary);
            }
            result = result.concat(binary);
        }
        return result;
    }

    public static String ipToString(long ip) {
        String result = String.valueOf(ip >> 24).concat(".");
        result = result.concat(String.valueOf((ip & 0X00FFFFFF) >> 16)).concat(".");
        result = result.concat(String.valueOf((ip & 0X0000FFFF) >> 8)).concat(".");
        result = result.concat(String.valueOf(ip & 0X0000FF)).concat("");
        return result;
    }

    /**
     * IP Long 转 String
     * 192.0.0.0 == 16777216
     *
     * @param args 命令参数
     */
    /*public static void main(String[] args) {
        long ipLong = ipToNum2("192.168.0.101");
        System.out.println(ipLong);
        String ipStr = ipToString(ipLong);
        System.out.println(ipStr);
    }*/
}
