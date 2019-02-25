package com.lll.sort.service.impl.selectionsort;


import com.lll.sort.service.IArrayWork;
import com.lll.sort.service.ISort;
import com.lll.sort.utils.SortUtils;

/**
 * @ClassName: SelectionSort
 * @Description: 选择排序
 * @Author: zl
 * @Create: 2019-02-24 13:29
 **/
public class SelectionSort implements IArrayWork, ISort {

    /**
     * 选择排序
     * @param needSortArray
     */
    @Override
    public void sort(Comparable[] needSortArray) {
        int length = needSortArray.length;
        for (int i = 0; i < length; i++) {
            Comparable less = needSortArray[i];
            int index = i;
            for (int j = i + 1; j < length; j++) {
                Comparable element = needSortArray[j];
                if (less.compareTo(element) > 0){
                    less = element;
                    index = j;
                }
            }
            SortUtils.exch(needSortArray, i, index);
        }
    }

    @Override
    public void work(Comparable[] array) {
        sort(array);
    }
}
