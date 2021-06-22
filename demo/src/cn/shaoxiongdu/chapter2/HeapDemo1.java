package cn.shaoxiongdu.chapter2;

/**
 * 演示堆内存
 * -Xms20m -Xmx20m
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
