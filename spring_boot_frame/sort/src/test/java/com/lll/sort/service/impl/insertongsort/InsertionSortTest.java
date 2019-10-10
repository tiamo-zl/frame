package com.lll.sort.service.impl.insertongsort;

import com.lll.sort.SortTest;
import com.lll.sort.utils.SortMnum;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @ClassName: InsertionSortTest
 * @Description:
 * @Author: ZL
 * @CreateTime: 2019-02-26 09:36
 */
public class InsertionSortTest extends SortTest {

    /**
     * 测试插入算法
     */
    @Test
    public void sort() {
        super.isSort(SortMnum.Insertion_Sort.sort);
    }
}