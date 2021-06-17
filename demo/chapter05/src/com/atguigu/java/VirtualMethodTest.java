package com.atguigu.java;

/**
 * @author shkstart
 * @create 2020 下午 11:59
 */
class Father {
    public static void print(String str) {
        System.out.println("father " + str);
    }
    private void show(String str) {
        System.out.println("father " + str);
    }
}
class Son extends Father {
}
public class VirtualMethodTest {
    public static void main(String[] args) {
        Son.print("coder");
        //Father fa = new Father();
        //fa.show("cooooder");
    }
}
