package cn.shaoxiongdu.chapter5.memoryleak;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * @author 演示内存泄漏
 * @create 15:05
 */
public class Stack {
    private Object[] elements;
    private int size = 0;

    public static void main(String[] args) {



    }

    /**
     * 默认容量
     */
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    public Stack() {
        elements = new Object[DEFAULT_INITIAL_CAPACITY];
    }

    /**
     * 入栈
     * @param e
     */
    public void push(Object e) { //入栈
        ensureCapacity();
        elements[size++] = e;
    }

    /**
     * 出栈
     * @return
     */
    public Object pop() {
        if (size == 0)
            throw new EmptyStackException();
        Object result = elements[--size];

        //不加此行代码 容易造成内存泄漏
        //elements[size] = null;
        return result;
    }

    /**
     * 扩容
     */
    private void ensureCapacity() {
        if (elements.length == size)
            elements = Arrays.copyOf(elements, 2 * size + 1);
    }
}
