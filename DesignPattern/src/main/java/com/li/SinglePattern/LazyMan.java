package com.li.SinglePattern;// Version 4

/**
 * 懒汉式 单例，
 */
public class LazyMan {

    private static volatile LazyMan instance;

    private LazyMan() {}

    public static LazyMan getInstance() {

        if (instance == null) {

            synchronized (LazyMan.class) {

                if (instance == null) {

                    instance = new LazyMan();

                }

            }

        }

        return instance;

    }

}