package cn.shaoxiongdu.chapter4;

public class LocalVarGC {
    public void localvarGC1() {
        byte[] buffer = new byte[10 * 1024 * 1024];//10MB
        System.gc();
        //输出: 不会被回收, FullGC时被放入老年代
        //[GC (System.gc()) [PSYoungGen: 14174K->10736K(76288K)] 14174K->10788K(251392K), 0.0089741 secs] [Times: user=0.01 sys=0.00, real=0.01 secs]
        //[Full GC (System.gc()) [PSYoungGen: 10736K->0K(76288K)] [ParOldGen: 52K->10649K(175104K)] 10788K->10649K(251392K), [Metaspace: 3253K->3253K(1056768K)], 0.0074098 secs] [Times: user=0.01 sys=0.02, real=0.01 secs]
    }

    public void localvarGC2() {
        byte[] buffer = new byte[10 * 1024 * 1024];
        buffer = null;
        System.gc();
        //输出: 正常被回收
        //[GC (System.gc()) [PSYoungGen: 14174K->544K(76288K)] 14174K->552K(251392K), 0.0011742 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
        //[Full GC (System.gc()) [PSYoungGen: 544K->0K(76288K)] [ParOldGen: 8K->410K(175104K)] 552K->410K(251392K), [Metaspace: 3277K->3277K(1056768K)], 0.0054702 secs] [Times: user=0.01 sys=0.00, real=0.01 secs]

    }

    public void localvarGC3() {
        {
            byte[] buffer = new byte[10 * 1024 * 1024];
        }
        System.gc();
        //输出: 不会被回收, FullGC时被放入老年代
        //[GC (System.gc()) [PSYoungGen: 14174K->10736K(76288K)] 14174K->10784K(251392K), 0.0076032 secs] [Times: user=0.02 sys=0.00, real=0.01 secs]
        //[Full GC (System.gc()) [PSYoungGen: 10736K->0K(76288K)] [ParOldGen: 48K->10649K(175104K)] 10784K->10649K(251392K), [Metaspace: 3252K->3252K(1056768K)], 0.0096328 secs] [Times: user=0.01 sys=0.01, real=0.01 secs]
    }

    public void localvarGC4() {
        {
            byte[] buffer = new byte[10 * 1024 * 1024];
        }
        int value = 10;
        System.gc();
        //输出: 正常被回收
        //[GC (System.gc()) [PSYoungGen: 14174K->496K(76288K)] 14174K->504K(251392K), 0.0016517 secs] [Times: user=0.01 sys=0.00, real=0.00 secs]
        //[Full GC (System.gc()) [PSYoungGen: 496K->0K(76288K)] [ParOldGen: 8K->410K(175104K)] 504K->410K(251392K), [Metaspace: 3279K->3279K(1056768K)], 0.0055183 secs] [Times: user=0.00 sys=0.00, real=0.01 secs]
    }

    public void localvarGC5() {
        localvarGC1();
        System.gc();
        //输出: 正常被回收
        //[GC (System.gc()) [PSYoungGen: 14174K->10720K(76288K)] 14174K->10744K(251392K), 0.0121568 secs] [Times: user=0.02 sys=0.00, real=0.02 secs]
        //[Full GC (System.gc()) [PSYoungGen: 10720K->0K(76288K)] [ParOldGen: 24K->10650K(175104K)] 10744K->10650K(251392K), [Metaspace: 3279K->3279K(1056768K)], 0.0101068 secs] [Times: user=0.01 sys=0.02, real=0.01 secs]
        //[GC (System.gc()) [PSYoungGen: 0K->0K(76288K)] 10650K->10650K(251392K), 0.0005717 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
        //[Full GC (System.gc()) [PSYoungGen: 0K->0K(76288K)] [ParOldGen: 10650K->410K(175104K)] 10650K->410K(251392K), [Metaspace: 3279K->3279K(1056768K)], 0.0045963 secs] [Times: user=0.01 sys=0.00, real=0.00 secs]
    }

    public static void main(String[] args) {
        LocalVarGC local = new LocalVarGC();
        local.localvarGC1();
    }
}
