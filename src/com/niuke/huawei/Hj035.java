package com.niuke.huawei;

import java.util.Scanner;

/**
 * 1 3 6 10 15
 * 2 5 9 14
 * 4 8 13
 * 7 12
 * 11
 *
 * @description: 蛇形矩阵
 * @date: 2021/3/21 19:09
 * @author: wei·man cui
 */
public class Hj035 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int[][] arr = new int[n][n];
            for (int i = 0; i < n; i++) {
                arr[0][i] = add(i + 1);
            }
            for (int i = 1; i < n; i++) {
                int distance = i;
                for (int j = 0; j < n - i; j++) {
                    arr[i][j] = arr[i - 1][j] + distance;
                    distance++;
                }
            }
            printNum(arr);
        }
    }

    public static void printNum(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int add(int index) {
        return (1 + index) * index / 2;
    }

}
