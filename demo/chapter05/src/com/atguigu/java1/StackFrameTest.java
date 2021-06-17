package com.atguigu.java1;

/**
 * @author shkstart
 * @create 2020 下午 4:11
 *
 * 方法的结束方式分为两种：① 正常结束，以return为代表  ② 方法执行中出现未捕获处理的异常，以抛出异常的方式结束
 *
 */
public class StackFrameTest {
    public static void main(String[] args) {
        try {
            StackFrameTest test = new StackFrameTest();
            test.method1();

        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("main()正常结束");

    }

    public void method1(){
        System.out.println("method1()开始执行...");
        method2();
        System.out.println("method1()执行结束...");
//        System.out.println(10 / 0);

//        return ;//可以省略
}

    public int method2() {
        System.out.println("method2()开始执行...");
        int i = 10;
        int m = (int) method3();
        System.out.println("method2()即将结束...");
        return i + m;
    }

    public double method3() {
        System.out.println("method3()开始执行...");
        double j = 20.0;
        System.out.println("method3()即将结束...");
        return j;
    }

}
