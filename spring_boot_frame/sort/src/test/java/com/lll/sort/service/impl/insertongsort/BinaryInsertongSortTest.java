package com.lll.sort.service.impl.insertongsort;

import com.lll.sort.SortTest;
import com.lll.sort.utils.SortMnum;
import com.lll.sort.utils.SortUtils;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @ClassName: BinaryInsertongSortTest
 * @Description:
 * @Author: ZL
 * @CreateTime: 2019-02-26 09:20
 */
public class BinaryInsertongSortTest extends SortTest {

    /**
     * 测试二分插入算法
     */
    @Test
    public void sort() {
        super.isSort(SortMnum.Binary_Insertong_Sort.sort);
    }
}