package com.wang.utils;

/**
 * Created by hppc on 2017/6/21.
 */
public class MultiThread extends Thread {
    public MultiThread () {

    }

    public MultiThread (String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println("新的线程 接下来准备休眠10秒");
        try {
            Thread.sleep(10000);
            System.out.println("休眠完毕");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
