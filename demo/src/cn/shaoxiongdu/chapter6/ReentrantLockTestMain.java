package cn.shaoxiongdu.chapter6;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @作者: 写Bug的小杜 【email@shaoxiongdu.cn】
 * @时间: 2021/08/02
 * @描述: Lock的使用
 */
public class ReentrantLockTestMain {

    public static void main(String[] args) {

        Lock lock = new ReentrantLock();

        lock.lock();
        try{
            //处理任务
        }catch(Exception ex){

        }finally{
            lock.unlock();  //释放锁
        }
    }
}
