package cn.shaoxiongdu.chapter2;

/** 测试：大对象直接进入老年代
 * -Xms60m -Xmx60m -XX:NewRatio=2 -XX:SurvivorRatio=8 -XX:+PrintGCDetails
 */
public class YoungOldAreaTest {
    // 新生代 20m ，Eden 16m， s0 2m， s1 2m
    // 老年代 40m
    public static void main(String[] args) {
        //Eden 区无法存放buffer  晋升老年代
        byte[] buffer = new byte[1024 * 1024 * 20];//20m

        try {
            Thread.sleep(1000 * 1000 );
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
