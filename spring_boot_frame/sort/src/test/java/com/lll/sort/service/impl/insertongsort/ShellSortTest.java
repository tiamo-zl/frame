package com.lll.sort.service.impl.insertongsort;

import com.lll.sort.SortTest;
import com.lll.sort.utils.SortMnum;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @ClassName: ShellSortTest
 * @Description:
 * @Author: ZL
 * @CreateTime: 2019-02-26 09:37
 */
public class ShellSortTest extends SortTest {

    /**
     * 测试希尔排序
     */
    @Test
    public void sort() {
        isSort(SortMnum.Shell_Sort.sort);
    }
}