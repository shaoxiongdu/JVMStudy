package com.atguigu.java;

/**
 * -Xms20m -Xmx20m
 * @author shkstart  shkstart@126.com
 * @create 2020  16:42
 */
public class HeapDemo1 {
    public static void main(String[] args) {
        System.out.println("start...");
        try {
            Thread.sleep(1000000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("end...");
    }
}
