package cn.shaoxiongdu.chapter2;

/**
 * 演示堆内存
 * -Xms10m -Xmx10m R
 */
public class HeapDemo {
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
