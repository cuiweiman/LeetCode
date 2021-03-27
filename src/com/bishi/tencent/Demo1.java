package com.bishi.tencent;

/**
 * @description: 二维矩阵旋转90°
 * @date: 2021/3/27 21:07
 * @author: wei·man cui
 */
public class Demo1 {

    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

        // 1. 先对角线翻转 (x,y)==>(n-1-x,n-1-y)
        // 2. 水平翻转 (x,y)==>(n-1-x,y)
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len - i; j++) {
                int temp = arr[i][j];
                arr[i][j] = arr[len - j - 1][len - i - 1];
                arr[len - j - 1][len - i - 1] = temp;
            }
        }

        for (int i = 0; i < len / 2; i++) {
            for (int j = 0; j < len; j++) {
                int temp = arr[i][j];
                arr[i][j] = arr[len - 1 - i][j];
                arr[len - 1 - i][j] = temp;
            }
        }


        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

    }

}
