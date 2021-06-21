package cn.shaoxiongdu.chapter2;

/**
 * 演示设置栈的内存大小
 * 默认情况下：1M  count 11404
 * 设置栈的大小： -Xss256k count 2466
 * 设置栈的大小： -Xss128m count 1656372
 */
public class StackOverFlowErrorTest {
    private static int count = 1;
    public static void main(String[] args) {
        System.out.println(count);
        count++;
        main(args);
    }
}
