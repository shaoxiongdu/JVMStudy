package cn.shaoxiongdu.chapter1;

/**
 * @作者: 写Bug的小杜 【email@shaoxiongdu.cn】
 * @时间: 2021/07/30
 * @描述: 测试一个类的CInit方法是否被加锁
 */
class TestClass {
    static{
        // 如果不加这个判断 编译器会报死循环的错误
        if(true){
            System.out.println(Thread.currentThread().getName() + "线程正在执行CInit方法");
            while (true){
            }
        }
    }
}
public class DeadLoopClass{
    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "启动");
                TestClass testClass = new TestClass(); //触发加载TestClass类
                System.out.println(Thread.currentThread().getName() + "结束");
            }
        };
        new Thread(runnable).start();
        new Thread(runnable).start();
    }
}

