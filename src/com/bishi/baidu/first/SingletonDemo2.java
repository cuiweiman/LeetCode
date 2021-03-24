package com.bishi.baidu.first;

/**
 * @description: 单例——懒汉式
 * @author: wei·man cui
 * @date: 2021/3/24 12:48
 */
public class SingletonDemo2 {

    private SingletonDemo2() {
    }

    private enum SingletonEnum {
        /*
         * 实例
         */
        INSTANCE;
        private SingletonDemo2 singleton;

        SingletonEnum() {
            this.singleton = new SingletonDemo2();
        }

        public SingletonDemo2 getInstance() {
            return singleton;
        }
    }


    public static SingletonDemo2 getSingleton() {
        return SingletonEnum.INSTANCE.getInstance();
    }

    public static void main(String[] args) {
        final SingletonDemo2 a = SingletonDemo2.getSingleton();
        final SingletonDemo2 b = SingletonDemo2.getSingleton();
        System.out.println(a == b);

    }
}
