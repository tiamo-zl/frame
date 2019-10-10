package com.lll.frame.dao.mapper;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * description:
 *
 * @author zl
 * @date 2019-10-09 10:37
 **/
public class LockTest {

  private static Lock lock = new ReentrantLock();

  public static void main(String[] args) {
    lock.lock();
    try {
      int i = 1/0;
    } finally {
      System.err.println("解锁开始....");
      lock.unlock();
      System.err.println("解锁完成....");
    }

  }
}
