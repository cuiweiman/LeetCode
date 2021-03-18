package com.niuke;

import java.util.*;

/**
 * 给定一个数组，请你编写一个函数，返回该数组排序后的形式。
 * 示例 1：
 * 输入
 * [5,2,3,1,4]
 * 返回
 * [1,2,3,4,5]
 * <p>
 * 示例 2：
 * 输入
 * [5,1,6,2,5]
 * 返回
 * [1,2,5,5,6]
 *
 * @description: 排序
 * @author: wei·man cui
 * @date: 2021/3/18 16:06
 */
public class Nc140 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 将给定数组排序
     *
     * @param arr int整型一维数组 待排序的数组
     * @return int整型一维数组
     */
    public int[] MySort(int[] arr) {

        // write code here
        return quickSort(arr, 0, arr.length - 1);
    }


    public int[] quickSort(int[] arr, int start, int end) {
        if (start < end) {
            int low = start;
            int high = end;
            int standard = arr[low];
            while (low < high) {
                while (low < high && standard < arr[high]) {
                    high--;
                }
                arr[low] = arr[high];
                while (low < high && standard >= arr[low]) {
                    low++;
                }
                arr[high] = arr[low];
            }
            arr[low] = standard;
            quickSort(arr, start, low - 1);
            quickSort(arr, low + 1, high);
        }
        return arr;
    }


    public static void main(String[] args) {
        Nc140 nc140 = new Nc140();
        final int[] ints = nc140.MySort(new int[]{5, 1, 6, 2, 5});
        Arrays.stream(ints).forEach(System.out::println);
    }

}
