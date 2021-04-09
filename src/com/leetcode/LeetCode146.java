package com.leetcode;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * @description: LRU缓存机制
 * @author: wei·man cui
 * @date: 2021/4/9 12:49
 */
public class LeetCode146 {

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(2, 1);
        cache.put(2, 2);
        System.out.println(cache.get(2));
        cache.put(1, 2);
        cache.put(4, 1);
        System.out.println(cache.get(2));
    }

}

class LRUCache {

    private int capacity;
    private HashMap<Integer, Integer> map = new HashMap<>();
    private LinkedList<Integer> list = new LinkedList<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(Integer key) {
        boolean remove = list.remove(key);
        if (!remove) {
            return -1;
        }
        list.add(key);
        return map.get(key);
    }

    /**
     * 增加/新增 元素 放队尾，淘汰 队首元素
     *
     * @param key   key
     * @param value val
     */
    public void put(Integer key, Integer value) {
        if (list.contains(key)) {
            list.remove(key);
            list.add(key);
            map.put(key, value);
            return;
        }
        if (list.size() >= capacity) {
            final Integer first = list.removeFirst();
            map.remove(first);
        }
        list.add(key);
        map.put(key, value);
    }
}

