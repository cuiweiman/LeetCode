package com.leetcode;

import java.util.Objects;

/**
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，
 * 并且每个节点只能存储 一位 数字。请你将两个数相加，并以相同形式返回一个表示和的链表。
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <示例>
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 * <p>
 * 示例 2：
 * 输入：l1 = [0], l2 = [0]
 * 输出：[0]
 * <p>
 * 示例 3：
 * 输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * 输出：[8,9,9,9,0,0,0,1]
 * </示例>
 *
 * @description: 两数相加
 * @author: wei·man cui
 * @date: 2021/1/7 13:17
 */
public class LeetCode002 {

    public static void main(String[] args) {
        ListNode2 x1 = new ListNode2(2);
        ListNode2 x2 = new ListNode2(4);
        ListNode2 x3 = new ListNode2(3);
        x1.next = x2;
        x2.next = x3;
        ListNode2 y1 = new ListNode2(5);
        ListNode2 y2 = new ListNode2(6);
        ListNode2 y3 = new ListNode2(4);
        y1.next = y2;
        y2.next = y3;

        ListNode2 listNode = addTwoNumbers(x1, y1);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    public static ListNode2 addTwoNumbers(ListNode2 l1, ListNode2 l2) {
        ListNode2 root = new ListNode2(0);
        ListNode2 cursor = root;
        int carry = 0;

        while (Objects.nonNull(l1) || Objects.nonNull(l2) || carry != 0) {
            // 链表1 有数，或者链表2 有数，或者 有进位
            int val1 = Objects.nonNull(l1) ? l1.val : 0;
            int val2 = Objects.nonNull(l2) ? l2.val : 0;
            int sum = val1 + val2 + carry;
            final ListNode2 node = new ListNode2(sum % 10);
            cursor.next = node;
            cursor = node;
            carry = sum / 10;
            if (Objects.nonNull(l1)) {
                l1 = l1.next;
            }
            if (Objects.nonNull(l2)) {
                l2 = l2.next;
            }
        }
        return root.next;
    }
}

class ListNode {
    int val;
    ListNode2 next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode2 next) {
        this.val = val;
        this.next = next;
    }
}
