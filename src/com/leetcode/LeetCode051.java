package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: N皇后
 * @date: 2021/4/7 7:43
 * @author: wei·man cui
 */
public class LeetCode051 {

    public static void main(String[] args) {
        LeetCode051 demo = new LeetCode051();
        List<List<String>> lists = demo.solveNQueens(4);
        System.out.println(lists.size());
        System.out.println(lists);
    }

    public List<List<String>> solveNQueens(int n) {
        char[][] chs = new char[n][n];
        // 列出 n*n 棋盘
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                chs[i][j] = '.';
            }
        }
        List<List<String>> res = new ArrayList<>();
        // 从第 0 行开始，摆放皇后。行数在方法中递归。
        backTracing(chs, 0, n, res);
        return res;
    }

    /**
     * 递归回溯算法
     *
     * @param chs n*n棋盘
     * @param row 当前行
     * @param n   n*n棋盘，n个皇后
     * @param res 结果
     */
    public void backTracing(char[][] chs, int row, int n, List<List<String>> res) {
        if (row == n) {
            // 递归 到 最后一行，将 二维数组 内容添加到 List 结果中
            res.add(chsToList(chs));
            return;
        }
        for (int i = 0; i < chs[0].length; i++) {
            // 判断 chs[row][i] 出
            if (isValid(chs, row, i)) {
                chs[row][i] = 'Q';
                // 递归，判断下一行 皇后的位置
                backTracing(chs, row + 1, n, res);
                // for循环执行结束，说明没有合法位置可以放置 Q，在 (row,i) 放置 皇后是 错误的，回溯。
                chs[row][i] = '.';
            }
        }
    }

    /**
     * 判断在 (row,col) 位置 放置皇后 是否有效
     * <p>
     * 遍历二维数组，当一个坐标上出现 Q 皇后时，判断这个皇后的 的 同行、同列、对角线上不存在其他皇后
     * <p>
     * 判断合法：当前将要摆放'Q'的位置和其他已摆放‘Q’的位置不能在同一列，且不能在同一条45度斜线或135度斜线上。
     * 这里判断是否在同一条斜线上可通过当前将要摆放'Q'的位置和其他已摆放‘Q’的位置横坐标之差和纵坐标之差的绝对值是否相等来判断。
     * <p>
     * row==i 则同行(行数会递增，可以不用判断)
     * col==j 则同列
     * Math.abs(row-i)==Math.abs(col-j) 则对角线
     *
     * @param chs 二维数组 棋盘
     * @param row 行
     * @param col 列
     * @return 结果
     */
    public boolean isValid(char[][] chs, int row, int col) {
        for (int i = 0; i < chs.length; i++) {
            for (int j = 0; j < chs[i].length; j++) {
                // 若 chs[i][j]=='Q',则 (i,j) 坐标的 同行、同列 或者 两条对角线出现 Q，是非法的
                boolean isValid = chs[i][j] == 'Q' && (col == j || Math.abs(row - i) == Math.abs(col - j));
                if (isValid) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * 将 chs 的一维数组转 List
     *
     * @param chs 二维数组
     * @return list
     */
    public List<String> chsToList(char[][] chs) {
        List<String> list = new ArrayList<>();
        for (char[] ch : chs) {
            list.add(new String(ch));
        }
        return list;
    }

}
