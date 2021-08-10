/*
 * Copyright (c) 2021 ShaoxiongDu <email@shaoxiongdu.cn> All Rights Reserved
 */

package cn.shaoxiongdu.chapter4;

/**
 * @Author: Shaoxiong Du <email@shaoxiongdu.cn>
 * @Date: 2021/7/6
 * @Describe: 测试Java对象存储规则
 */
public class GCParamTest {

    private static final int _1MB = 1024 * 1024;

    public static void main(String[] agrs) {
        testAllocation();
    }

    public static void testAllocation() {
        byte[] allocation1, allocation2, allocation3, allocation4;
        allocation1 = new byte[2 * _1MB];
        allocation2 = new byte[2 * _1MB];
        allocation3 = new byte[2 * _1MB];
        allocation4 = new byte[4 * _1MB];
    }
}