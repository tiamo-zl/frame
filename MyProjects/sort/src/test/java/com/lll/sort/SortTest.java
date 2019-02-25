package com.lll.sort;

import com.lll.sort.utils.SortMnum;
import com.lll.sort.utils.SortUtils;
import org.junit.Test;

/**
 * @ClassName: SortTest
 * @Description: 排序测试
 * @Author: zl
 * @Create: 2019-02-26 00:08
 **/
public class SortTest extends SortApplicationTests {


    @Test
    public void sortTest(){
        SortUtils.work(SortMnum.Binary_Insertong_Sort.sort);
    }

}
