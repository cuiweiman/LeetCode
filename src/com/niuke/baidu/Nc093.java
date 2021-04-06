package com.niuke.baidu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @description: 设计LRU缓存结构
 * @date: 2021/3/28 8:37
 * @author: wei·man cui
 */
public class Nc093 {

    public static void main(String[] args) {
        Nc093 nc093 = new Nc093();
        int[][] operators = {{1, 1, 1}, {1, 2, 2}, {1, 3, 2}, {2, 1}, {1, 4, 4}, {2, 2}};
        int limit = 3;
        int[] lru = nc093.LRU(operators, limit);
        for (int i = 0; i < lru.length; i++) {
            System.out.print(lru[i] + " ");
        }
        System.out.println();
    }


    /**
     * lru design
     *
     * @param operators int整型二维数组 the ops，操作步骤
     *                  operate,key,val, 1存储元素或者 operate,key 2获取元素
     *                  operate:1表示存储；2表示获取。
     * @param k         int整型 the k，最大容量
     * @return int整型一维数组
     */
    public int[] LRU(int[][] operators, int k) {
        LruCache cache = new LruCache(k);
        List<Integer> resList = new ArrayList<>();
        for (int[] operator : operators) {
            if (operator[0] == 1) {
                cache.put(operator[1], operator[2]);
            } else if (operator[0] == 2) {
                resList.add(cache.get(operator[1]));
                // System.out.println(cache.get(operator[1]));
            } else {
                System.out.println("存在操作符错误：" + operator[0]);
            }

        }
        return resList.stream().mapToInt(Integer::intValue).toArray();
    }
}

class LruCache {
    private Integer limit;
    private LinkedList<Integer> linkedList = new LinkedList<>();
    private HashMap<Integer, Integer> hashMap = new HashMap<>();

    public LruCache(Integer limit) {
        this.limit = limit;
    }

    public void put(Integer key, Integer val) {
        if (linkedList.size() >= limit) {
            // 移除最近最久未使用元素，移除队头的元素
            Integer removeFirst = linkedList.removeFirst();
            hashMap.remove(removeFirst);
        }
        // 添加元素到队尾
        linkedList.add(key);
        hashMap.put(key, val);
    }

    public Integer get(Integer key) {
        boolean remove = linkedList.remove(key);
        if (!remove) {
            return -1;
        }
        linkedList.add(key);
        return hashMap.get(key);
    }


    public Integer size() {
        return this.linkedList.size();
    }

}

