package com.lll.sort;

import com.lll.sort.service.IArrayWork;
import com.lll.sort.utils.SortMnum;
import com.lll.sort.utils.SortUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * @ClassName: SortTest
 * @Description: 排序测试基类
 * @Author: zl
 * @Create: 2019-02-26 00:08
 **/
public class SortTest extends SortApplicationTests {

    /**
     * 断言默认数组经过排序算法后是一个有序的数组
     * @param iArrayWork
     */
   public void isSort(IArrayWork iArrayWork){
       Assert.assertEquals(SortUtils.isSorted(SortUtils.work(iArrayWork)), true);
   }

    /**
     * 断言自定义的数组经过排序算法后是一个有序的数组
     * @param iArrayWork
     * @param needSortArray
     */
    public void isSort(IArrayWork iArrayWork, Comparable[] needSortArray){
        Assert.assertEquals(SortUtils.isSorted(SortUtils.work(iArrayWork, needSortArray)), true);
    }
}
