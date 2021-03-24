package com.bishi.baidu.first;

import java.util.LinkedList;
import java.util.Objects;

/**
 * @description: 有序链表合并
 * @author: wei·man cui
 * @date: 2021/3/24 12:54
 */
public class LinkedListDemo {

    public static void main(String[] args) {
        LinkedList<Integer> list1 = new LinkedList<>();
        list1.add(2);
        list1.add(8);
        list1.add(26);
        list1.add(46);
        list1.add(78);

        LinkedList<Integer> list2 = new LinkedList<>();
        list2.add(1);
        list2.add(13);
        list2.add(90);
        list2.add(780);

        LinkedList<Integer> result = merge(list1, list2);
        out(list1);
        out(list2);
        out(result);

    }

    public static LinkedList<Integer> merge(LinkedList<Integer> list1, LinkedList<Integer> list2) {
        LinkedList<Integer> list = new LinkedList<>();
        LinkedList<Integer> listA = new LinkedList<>(list1);
        LinkedList<Integer> listB = new LinkedList<>(list2);
        while (!listA.isEmpty() || !listB.isEmpty()) {
            final Integer pollA = listA.poll();
            final Integer pollB = listB.poll();
            if (Objects.nonNull(pollA) && Objects.nonNull(pollB)) {
                if (pollA > pollB) {
                    list.add(pollB);
                    listA.addFirst(pollA);
                } else {
                    list.add(pollA);
                    listB.addFirst(pollB);
                }
            } else if (Objects.isNull(pollA)) {
                list.add(pollB);
            } else {
                list.add(pollA);
            }
        }
        return list;
    }

    public static void out(LinkedList<Integer> list) {
        for (Integer integer : list) {
            System.out.print(integer + " ");
        }
        System.out.println();
    }


}
