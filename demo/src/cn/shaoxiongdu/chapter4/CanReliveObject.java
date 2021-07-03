package cn.shaoxiongdu.chapter4;

/**
 * 测试Object类中finalize()方法
 */
public class CanReliveObject {

    /**
     * 类变量 属于GCRoots
     */
    public static CanReliveObject ref;

    @Override
    protected void finalize() throws Throwable {
        System.out.println("调用当前类重写的finalize()方法");
        /**
         * 当前待回收的对象重新加入引用链
         */
        ref = this;
    }

    public static void main(String[] args) {

        ref = new CanReliveObject();

        ref = null;
        //调用垃圾回收
        System.gc();
        System.out.println("第一次GC执行完毕");

        /**
         * 因为finalize优先级较低 主线程暂停2s 等待它
         */
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if(ref == null){
            System.out.println("对象已死");
        }else {
            System.out.println("对象未死");
        }
        ref = null;
        System.gc();
        System.out.println("第二次GC执行完毕");
        if(ref == null){
            System.out.println("对象已死");
        }else {
            System.out.println("对象未死");
        }
    }

}
