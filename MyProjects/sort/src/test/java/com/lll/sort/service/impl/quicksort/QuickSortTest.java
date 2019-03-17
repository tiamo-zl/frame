package com.lll.sort.service.impl.quicksort;

import com.lll.sort.SortTest;
import com.lll.sort.utils.SortMnum;
import org.junit.Test;

/**
 * @ClassName: QuickSortTest
 * @Description:
 * @Author: zl
 * @Create: 2019-02-28 23:44
 **/
public class QuickSortTest extends SortTest {


    /**
     * 测试数组
     */
    private Integer[] needSortArray = {6, 9, 2,3,10,38,4};

    /**
     * 测试快速排序
     */
    @Test
    public void sort() {
        isSort(SortMnum.Quick_Sort.sort, needSortArray);
    }
}