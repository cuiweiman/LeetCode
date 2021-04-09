package com.leetcode;

/**
 * @description: 反转链表：递归 和 迭代
 * @author: wei·man cui
 * @date: 2021/4/9 17:31
 */
public class LeetCode206 {

    public static void main(String[] args) {
        ListNode2 node1 = new ListNode2(1);
        ListNode2 node2 = new ListNode2(2);
        ListNode2 node3 = new ListNode2(3);
        ListNode2 node4 = new ListNode2(4);
        ListNode2 node5 = new ListNode2(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        LeetCode206 demo = new LeetCode206();
        ListNode2 temp = demo.reverseList2(node1);
        while (temp != null) {
            System.out.print(temp.val + ",");
            temp = temp.next;
        }
        System.out.println();
    }

    /**
     * 迭代
     * 1->2->3->4->5->null
     * null->5->4->3->2->1->null
     *
     * @param head 头结点
     * @return 结果
     */
    public ListNode2 reverseList(ListNode2 head) {
        ListNode2 prev = null;
        ListNode2 curr = head;
        while (curr != null) {
            ListNode2 next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    /**
     * 递归
     * 1->2->3->4->5->null
     * null->5->4->3->2->1->null
     *
     * @param head 头结点
     * @return 结果
     */
    public ListNode2 reverseList2(ListNode2 head) {
        if (head == null || head.next == null) {
            return head;
        }
        // 递归到 最后一个 节点。此时 head=4，node=5
        ListNode2 node = reverseList2(head.next);
        // head.next.next 指向自己，形成闭环
        head.next.next = head;
        // 断开 head.next 的闭环
        head.next = null;
        return node;
    }

}


class ListNode2 {
    int val;
    ListNode2 next;

    ListNode2() {
    }

    ListNode2(int val) {
        this.val = val;
    }

    ListNode2(int val, ListNode2 next) {
        this.val = val;
        this.next = next;
    }
}


