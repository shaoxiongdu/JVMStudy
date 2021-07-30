package cn.shaoxiongdu.chapter1;

/**
 * @作者: 写Bug的小杜 【email@shaoxiongdu.cn】
 * @时间: 2021/07/30
 * @描述:
 */
class A{
    public static int a = 10;
    static {
        a = 20;
    }
}
class B extends A{
    public static int b = a;
}
public class CInitTestMain {

    public static void main(String[] args) {
        System.out.println(B.b);
    }
}
