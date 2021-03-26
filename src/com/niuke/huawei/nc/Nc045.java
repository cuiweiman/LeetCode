package com.niuke.huawei.nc;

import java.util.*;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * <pre class="code">
 *           5
 *     3            8
 *  6    9      0       7
 * </pre>
 * <p>
 * https://www.nowcoder.com/practice/a9fec6c46a684ad5a3abd4e365a9d362?tab=answerKey
 *
 * @description: 二叉树的前、中、后、层次遍历
 * @author: wei·man cui
 * @date: 2021/3/26 9:38
 */
public class Nc045 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);

        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(8);
        TreeNode node3 = new TreeNode(6);
        TreeNode node4 = new TreeNode(9);
        TreeNode node5 = new TreeNode(0);
        TreeNode node6 = new TreeNode(7);

        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;
        node2.right = node6;

        Nc045 nc045 = new Nc045();
        final int[][] ints = nc045.threeOrders(root);
        for (int i = 0; i < ints.length; i++) {
            for (int j = 0; j < ints[i].length; j++) {
                System.out.printf("%d ", ints[i][j]);
            }
            System.out.println();
        }
    }

    public int[][] threeOrders(TreeNode root) {
        List<Integer> preResult = new ArrayList<>();

        preOrder(root, preResult);
        int[] before = preResult.stream().mapToInt(Integer::intValue).toArray();
        List<Integer> midResult = new ArrayList<>();
        midOrder(root, midResult);
        int[] mid = midResult.stream().mapToInt(Integer::intValue).toArray();
        List<Integer> afterResult = new ArrayList<>();
        afterOrder(root, afterResult);
        int[] after = afterResult.stream().mapToInt(Integer::intValue).toArray();
        return new int[][]{before, mid, after};
    }


    /**
     * 前序遍历（中、左、右）
     * 1. 首先 root 节点入栈
     * 2. 循环判断 栈不为空：节点出栈，并存储到 list 结果中
     * 3. 若出栈节点有 右子树，则右子树节点入栈；若出栈节点有 左子树，左子树节点入栈。
     *
     * @param node 节点
     * @param list 存储结果
     */
    public void preOrder(TreeNode node, List<Integer> list) {
        if (Objects.isNull(node)) {
            return;
        }
        LinkedBlockingDeque<TreeNode> stack = new LinkedBlockingDeque<>();
        stack.push(node);
        while (!stack.isEmpty()) {
            final TreeNode pop = stack.pop();
            list.add(pop.val);
            if (Objects.nonNull(pop.right)) {
                stack.push(pop.right);
            }
            if (Objects.nonNull(pop.left)) {
                stack.push(pop.left);
            }
        }
    }

    /**
     * 中序遍历（左中右）
     * 1. 获取当前节点，循环条件为： 栈 不为空 或 当前节点 不为空。
     * 2. 若 当前节点不为空，则将 当前节点入栈，当前节点 变为 当前节点的左子树节点（遍历所有的 左子树节点）。
     * 3. 否则（当前节点为空），将 当前节点=出栈节点，并将当前节点内容记录到结果集中，将 当前节点 变为 当前节点的右子树。
     *
     * @param node 节点
     * @param list 结果
     */
    public void midOrder(TreeNode node, List<Integer> list) {
        LinkedBlockingDeque<TreeNode> stack = new LinkedBlockingDeque<>();
        TreeNode curr = node;
        while (!stack.isEmpty() || curr != null) {
            if (Objects.nonNull(curr)) {
                stack.push(curr);
                curr = curr.left;
            } else {
                curr = stack.pop();
                list.add(curr.val);
                curr = curr.right;
            }
        }
    }

    /**
     * 后序遍历（左右中）
     * 1. 首先 当前节点入栈
     * 2. 循环判断 栈不为空：节点出栈，并放入结果集首位 {@code list.add(0,pop.val)}。
     * 3. 与前序遍历相反，先判断 出栈节点的 左子树节点 不为空，则将 出栈节点的左子树节点入栈
     * 4. 再判断 出栈节点的 右子树节点 不为空，则将 出栈节点的 右子树节点入栈。
     *
     * @param node 节点
     * @param list 结果集
     */
    public void afterOrder(TreeNode node, List<Integer> list) {
        if (Objects.isNull(node)) {
            return;
        }
        LinkedBlockingDeque<TreeNode> deque = new LinkedBlockingDeque<>();
        deque.push(node);
        while (!deque.isEmpty()) {
            final TreeNode pop = deque.pop();
            list.add(0, pop.val);
            if (Objects.nonNull(pop.left)) {
                deque.push(pop.left);
            }
            if (Objects.nonNull(pop.right)) {
                deque.push(pop.right);
            }
        }
    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }

    /**
     * 层次遍历
     *
     * @return 结果
     */
    public List<List<Integer>> levelTraversal() {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        queue.add(this);
        while (!queue.isEmpty()) {
            int count = queue.size();
            List<Integer> list = new ArrayList<>();
            while (count > 0) {
                final TreeNode poll = queue.poll();
                count--;
                list.add(poll.val);
                if (Objects.nonNull(poll.left)) {
                    queue.add(poll.left);
                }
                if (Objects.nonNull(poll.right)) {
                    queue.add(poll.right);
                }
            }
            result.add(list);
        }
        return result;
    }
}











