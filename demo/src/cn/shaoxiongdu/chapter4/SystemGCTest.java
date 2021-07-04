package cn.shaoxiongdu.chapter4;


public class SystemGCTest {
    public static void main(String[] args) {
        new SystemGCTest();
        System.gc();//提醒jvm的垃圾回收器执行gc,但是不确定是否马上执行gc
        System.runFinalization();//强制调用使用引用的对象的finalize()方法
    }
    @Override
    protected void finalize() throws Throwable {
        System.out.println("SystemGCTest 重写了finalize()");
    }
}