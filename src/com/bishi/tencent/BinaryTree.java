package com.bishi.tencent;

import java.util.*;

/**
 * <pre class="code">
 *              5
 *      1               6
 *          8       4       2
 * </pre>
 *
 * @description: 二叉树 非递归 遍历
 * @date: 2021/3/22 21:24
 * @author: wei·man cui
 */
public class BinaryTree {
    public static void main(String[] args) {
        Node root = new Node(5);
        Node node1 = new Node(1);
        Node node2 = new Node(6);
        Node node3 = new Node(8);
        Node node4 = new Node(4);
        Node node5 = new Node(2);
        root.setLeft(node1);
        root.setRight(node2);
        node1.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);

        // List<Integer> list = root.levelTraversal();
        // List<Integer> list = root.frontTraversal();
        // List<Integer> list = root.midTraversal();
        List<Integer> list = root.afterTraversal();
        list.forEach(System.out::println);
    }
}

class Node {
    private Integer val;
    private Node left;
    private Node right;

    public Node(Integer val) {
        this.val = val;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public List<Integer> levelTraversal() {
        Queue<Node> queue = new LinkedList<>();
        List<Integer> list = new LinkedList<>();
        queue.add(this);
        while (queue.size() > 0) {
            Node poll = queue.poll();
            list.add(poll.val);
            if (poll.left != null) {
                queue.add(poll.left);
            }
            if (poll.right != null) {
                queue.add(poll.right);
            }
        }
        return list;
    }

    public List<Integer> frontTraversal() {
        Stack<Node> stack = new Stack<>();
        List<Integer> list = new LinkedList<>();
        stack.push(this);
        while (stack.size() > 0) {
            Node pop = stack.pop();
            list.add(pop.val);
            if (pop.right != null) {
                stack.push(pop.right);
            }
            if (pop.left != null) {
                stack.push(pop.left);
            }
        }
        return list;
    }

    /**
     * 非递归 中序遍历
     *
     * @return 结果
     */
    public List<Integer> midTraversal() {
        Stack<Node> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        Node node = this;
        while (node != null || !stack.isEmpty()) {
            if (node != null) {
                // 当节点不为 null 时，首先判断左节点
                stack.push(node);
                // 遍历左节点
                node = node.left;
            } else {
                // 出栈时，遍历出栈节点的右节点
                node = stack.pop();
                list.add(node.val);
                node = node.right;
            }
        }
        return list;
    }

    /**
     * 非递归 后序遍历
     *
     * @return 结果
     */
    public List<Integer> afterTraversal() {
        Stack<Node> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        Node node = this;
        // 记录根节点的右节点
        Node r = null;
        while (node != null || !stack.isEmpty()) {
            // 所有左节点入栈
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            if (!stack.empty()) {
                node = stack.pop();
                if (node.right == null || node.right == r) {
                    list.add(node.val);
                    r = node;
                    node = null;
                } else {
                    stack.push(node);
                    node = node.right;
                }
            }

        }
        return list;
    }
}