package com.atguigu.java;

/**
 * @author shkstart
 * @create 2020 下午 8:53
 */
public class IHaveNatives {
    public native void Native1(int x);

    public native static long Native2();

    private native synchronized float Native3(Object o);

    native void Native4(int[] ary) throws Exception;

}
