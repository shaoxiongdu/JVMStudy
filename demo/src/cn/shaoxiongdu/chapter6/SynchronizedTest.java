package cn.shaoxiongdu.chapter6;

/**
 * @作者: 写Bug的小杜 【email@shaoxiongdu.cn】
 * @时间: 2021/08/01
 * @描述:
 */
public class SynchronizedTest {



    private static int count = 0;

    public static synchronized void increment(){
        count++;
    }

    public static void main(String[] args) {

    }

}
