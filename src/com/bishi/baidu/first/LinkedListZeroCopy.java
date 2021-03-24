package com.bishi.baidu.first;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @description: 链表深度拷贝
 * @date: 2021/3/24 22:21
 * @author: wei·man cui
 */
public class LinkedListZeroCopy<source2> {
    public static void main(String[] args) {
        Node source = new Node(6);
        Node source2 = new Node(7);
        Node source3 = new Node(1);
        Node source4 = new Node(7);
        Node source5 = new Node(13);
        source.setNode(source2, source4);
        source2.setNode(source3, source);
        source3.setNode(source4, null);
        source4.setNode(source5, source2);
        source5.setNode(null, source);

        Node sourceTemp = source;
        while (source != null) {
            System.out.print(source.val + " ");
            if (source.random == null) {
                System.out.print("null " + source.hashCode());
            } else {
                System.out.print(source.random.val + " " + source.hashCode() + " " + source.random.hashCode());
            }
            source = source.next;
            System.out.println();
        }
        System.out.println("=======================");
        Node copy = sourceTemp.copy();
        while (copy != null) {
            System.out.print(copy.val + " ");
            if (copy.random == null) {
                System.out.print("null " + copy.hashCode());
            } else {
                System.out.print(copy.random.val + " " + copy.hashCode() + " " + copy.random.hashCode());
            }
            copy = copy.next;
            System.out.println();
        }
    }
}


class Node {
    Integer val;
    Node next;
    Node random;

    public Node(Integer val) {
        this.val = val;
    }

    public void setNode(Node next, Node random) {
        this.next = next;
        this.random = random;
    }

    /**
     * 1. 遍历所有节点，在节点后 复制一个同样的节点:A->A'->B->B'...K->K'
     * 2. A'.random=A->random.next
     * 3. 将复制好的节点链表拆分出去
     *
     * @return 拷贝的节点
     */
    public Node copy() {
        Node temp = this;
        Node head2 = new Node(val);
        head2.next = temp.next;
        temp.next = head2;

        // 将复制节点挂在节点后
        while (Objects.nonNull(temp = temp.next.next)) {
            Node copied = new Node(temp.val);
            copied.next = temp.next;
            temp.next = copied;
        }
        // 为Random节点赋值
        temp = this;
        temp.next.random = temp.random.next;
        while (Objects.nonNull(temp = temp.next.next)) {
            temp.next.random = Objects.isNull(temp.random) ? null : temp.random.next;
        }
        // 拆分节点
        temp = this;
        Node result = temp.next;
        Node copied = temp.next;
        while (Objects.nonNull(temp = temp.next.next)) {
            copied.next = temp.next;
            copied = copied.next;
        }
        return result;
    }


    public Node copy2() {
        Map<Node, Node> map = new HashMap<>();
        map.put(this, new Node(val));
        Node head = this;
        Node temp = this;
        while ((temp = temp.next) != null) {
            map.put(temp, new Node(temp.val));
        }
        temp = head;
        map.get(temp).next = map.get(temp.next);
        map.get(temp).random = map.get(temp.random);
        while ((temp = temp.next) != null) {
            map.get(temp).next = map.get(temp.next);
            map.get(temp).random = map.get(temp.random);
        }
        return map.get(head);
    }

}