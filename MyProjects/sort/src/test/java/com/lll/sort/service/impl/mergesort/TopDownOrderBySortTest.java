package com.lll.sort.service.impl.mergesort;

import com.lll.sort.SortTest;
import com.lll.sort.utils.SortMnum;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @ClassName: TopDownOrderBySortTest
 * @Description:
 * @Author: ZL
 * @CreateTime: 2019-02-26 10:30
 */
public class TopDownOrderBySortTest extends SortTest {

    /**
     * 测试自顶向下的排序算法
     */
    @Test
    public void sort() {
        isSort(SortMnum.TopDown_OrderBy_Sort.sort);
    }
}