package com.lll.sort.service.impl.quicksort;


import com.lll.sort.service.IArrayWork;
import com.lll.sort.service.ISort;

/**
 * @ClassName: QuickSort
 * @Description: 快速排序
 * @Author: zl
 * @Create: 2019-02-25 00:09
 **/
public class QuickSort implements IArrayWork, ISort {
    @Override
    public void work(Comparable[] array) {
        sort(array);
    }

    @Override
    public void sort(Comparable[] needSortArray) {
        sort(needSortArray, 0, needSortArray.length - 1);
    }

    /**
     * 排序
     * @param needSortArray
     * @param i
     * @param i1
     */
    private void sort(Comparable[] needSortArray, int lo, int hi) {
        if (hi <= lo){
            return;
        }
        int point = partition(needSortArray, lo, hi);
        sort(needSortArray, lo, point - 1);
        sort(needSortArray, point + 1, hi);
    }

    /**
     * 找到切点
     * @param needSortArray
     * @param lo
     * @param hi
     * @return
     */
    private int partition(Comparable[] needSortArray, int lo, int hi) {
        //将数组切为 [lo ... point] [point] [point ... hi]
        Comparable pointElement = needSortArray[lo];

        return 0;
    }
}
