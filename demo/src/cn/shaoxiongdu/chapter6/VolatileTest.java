package cn.shaoxiongdu.chapter6;

/**
 * @作者: 写Bug的小杜 【email@shaoxiongdu.cn】
 * @时间: 2021/07/31
 * @描述: 通过代码验证 【volatile变量在并发下运算是不安全】
 */
public class VolatileTest {

    //volatile修饰的count
    private static volatile int count = 0;

    //count自增方法
    public static void increment(){
        count++;
    }

    public static void main(String[] args) {

        //对count进行递增10000次操作的可运行接口
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "线程开始对count进行递增操作");
                for (int i = 0; i < 1000; i++) {
                    increment();
                }
                System.out.println(Thread.currentThread().getName() + "线程对count递增操作结束");
            }
        };

        // 创建20个线程并启动
        for (int i = 0; i < 20; i++) {

            Thread thread = new Thread(runnable);
            thread.setName((i+1) + "号线程");
            thread.start();

        }

        while (Thread.activeCount() > 2){
            //主线程回到就绪状态
            Thread.yield();
        }

        System.out.println("所有线程结束,count = " + count);


    }


}
