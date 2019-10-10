package com.lll.sort.service.impl.selectionsort;

import com.lll.sort.SortTest;
import com.lll.sort.utils.SortMnum;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @ClassName: SelectionSortTest
 * @Description:
 * @Author: ZL
 * @CreateTime: 2019-02-26 10:31
 */
public class SelectionSortTest extends SortTest {

    /**
     * 测试选择排序
     */
    @Test
    public void sort() {
        isSort(SortMnum.Selection_Sort.sort);
    }
}