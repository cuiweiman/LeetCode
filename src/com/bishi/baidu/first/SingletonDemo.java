package com.bishi.baidu.first;

/**
 * @description: 单例——饿汉式
 * @author: wei·man cui
 * @date: 2021/3/24 12:48
 */
public class SingletonDemo {

    private static SingletonDemo singleton = new SingletonDemo();

    private SingletonDemo() {
    }

    public static SingletonDemo getSingleton() {
        return singleton;
    }

    public static void main(String[] args) {
        final SingletonDemo a = SingletonDemo.getSingleton();
        final SingletonDemo b = SingletonDemo.getSingleton();
        System.out.println(a == b);

    }
}
