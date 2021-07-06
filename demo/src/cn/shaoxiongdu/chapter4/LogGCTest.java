/*
 * Copyright (c) 2021 ShaoxiongDu <email@shaoxiongdu.cn> All Rights Reserved
 */

package cn.shaoxiongdu.chapter4;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Shaoxiong Du <email@shaoxiongdu.cn>
 * @Date: 2021/7/6
 * @Describe: XXX
 */
public class LogGCTest {

    public static void main(String[] args) {

        List list = new ArrayList();

        for (int i = 0; i < 5000; i++) {

            list.add(new byte[1024 * 1024]); //1MB

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }





    }

}
