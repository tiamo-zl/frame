package com.lll.sort.service.impl.insertongsort;


import com.lll.sort.service.IArrayWork;
import com.lll.sort.service.ISort;
import com.lll.sort.utils.SortUtils;

/**
 * @ClassName: InsertionSort
 * @Description: 插入排序
 * @Author: zl
 * @Create: 2019-02-23 17:17
 **/
public class InsertionSort implements IArrayWork, ISort {

    @Override
    public void sort(Comparable[] needSortArray){
        int length = needSortArray.length;
        for (int i = 0; i < length; i++) {
            for (int j = i; j >0 && SortUtils.less(needSortArray[j], needSortArray[j-1]); j--) {
                SortUtils.exch(needSortArray, j, j-1);
            }
        }
    }

    @Override
    public void work(Comparable[] array) {
        sort(array);
    }
}
