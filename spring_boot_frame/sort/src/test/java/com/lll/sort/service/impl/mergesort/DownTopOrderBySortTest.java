package com.lll.sort.service.impl.mergesort;

import com.lll.sort.SortTest;
import com.lll.sort.utils.SortMnum;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @ClassName: DownTopOrderBySortTest
 * @Description:
 * @Author: ZL
 * @CreateTime: 2019-02-26 10:29
 */
public class DownTopOrderBySortTest extends SortTest {

    /**
     * 测试自底向上的排序算法
     */
    @Test
    public void sort() {
        isSort(SortMnum.DownTop_OrderBy_Sort.sort);
    }
}