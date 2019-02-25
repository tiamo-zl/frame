package com.lll.sort.service.impl.mergesort;


import com.lll.sort.utils.SortUtils;

/**
 * @ClassName: OrderBySort
 * @Description: 归并数组
 * @Author: zl
 * @Create: 2019-02-24 23:08
 **/
public abstract class OrderBySort {

    /**
     * 原地归并排序
     * 如果数组从lo 到 mid 是有序的， mid+1 到 hi 是有序的，将两个数组归并为一个有序的数组
     *
     * @param needSortArray
     * @param aux
     * @param lo
     * @param mid
     * @param hi
     */
    void merge(Comparable[] needSortArray,Comparable[] aux, int lo, int mid, int hi) {
        //左边的索引
        int index1 = lo;
        //右边的索引
        int index2 = mid + 1;
        //复制出 lo 到 mid 的数组
        for (int i = lo; i <= hi; i++) {
            aux[i] = needSortArray[i];
        }

        for (int k = lo; k <= hi; k++) {
            /*
                如果左边的数组取完，直接取右边的数组
                如果右边的数组取完，直接取左边的数组
                如果右边的数比左边的还小，取右边的数
                如果左边的数比右边的还小，取左边的数
             */
            if (index1 > mid) {
                needSortArray[k] = aux[index2++];
            } else if (index2 > hi) {
                needSortArray[k] = aux[index1++];
            } else if (SortUtils.less(aux[index2], aux[index1])) {
                needSortArray[k] = aux[index2++];
            } else {
                needSortArray[k] = aux[index1++];
            }
        }
    }

}
