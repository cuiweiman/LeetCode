package com.niuke.bytedance;

import java.util.LinkedList;
import java.util.Objects;

/**
 * @description: 反转链表：输入一个链表，反转链表后，输出新链表的表头。
 * @author: wei·man cui
 * @date: 2021/3/18 10:50
 */
public class Nc78 {

    public static void main(String[] args) {
        /*ListNode head = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        head.next = listNode2;
        listNode2.next = listNode3;*/
        ListNode head = null;

        Nc78 nc78 = new Nc78();

        ListNode listNode = nc78.ReverseList(head);
        System.out.println(listNode.val);
        while (Objects.nonNull(listNode.next)) {
            listNode = listNode.next;
            System.out.println(listNode.val);
        }

    }


    public ListNode ReverseList(ListNode head) {
        if (Objects.isNull(head)) {
            return null;
        }
        ListNode temp = head;
        LinkedList<Integer> list = new LinkedList<>();
        list.addFirst(temp.val);
        while (Objects.nonNull(temp.next)) {
            temp = temp.next;
            list.addFirst(temp.val);
        }

        ListNode reverseHead = new ListNode(list.get(0));
        ListNode tmp = reverseHead;
        for (int i = 1; i < list.size(); i++) {
            tmp.next = new ListNode(list.get(i));
            tmp = tmp.next;
        }
        return reverseHead;
    }

}

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}