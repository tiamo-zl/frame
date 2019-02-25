package com.lll.sort.service.impl.mergesort;

import com.lll.sort.service.IArrayWork;
import com.lll.sort.service.ISort;

/**
 * @ClassName: TopDownOrderBySort
 * @Description: 归并排序
 * @Author: zl
 * @Create: 2019-02-24 13:50
 **/
public class TopDownOrderBySort extends OrderBySort implements IArrayWork, ISort {

    /**
     * 辅助数组
     */
    static Comparable[] aux;

    @Override
    public void work(Comparable[] array) {
        sort(array);
    }

    /**
     * 自顶向下的归并排序
     *
     * @param needSortArray
     */
    @Override
    public void sort(Comparable[] needSortArray) {
        aux = new Comparable[needSortArray.length];
        sort(needSortArray, 0, needSortArray.length - 1);
        aux = null;
    }

    /**
     * 排序
     *
     * @param needSortArray
     * @param lo
     * @param hi
     */
    private void sort(Comparable[] needSortArray, int lo, int hi) {
        if (hi <= lo) {
            return;
        }
        int mid = (lo + hi) / 2;
        //左边的进行排序
        sort(needSortArray, lo, mid);
        //右边的进行排序
        sort(needSortArray, mid + 1, hi);
        //归并左边和右边的数组
        super.merge(needSortArray,aux, lo, mid, hi);
    }


}
