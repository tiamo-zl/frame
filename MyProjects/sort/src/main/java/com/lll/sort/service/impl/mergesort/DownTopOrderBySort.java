package com.lll.sort.service.impl.mergesort;


import com.lll.sort.service.IArrayWork;
import com.lll.sort.service.ISort;

/**
 * @ClassName: DownTopOrderBySort
 * @Description: 自底向上的归并排序
 * @Author: zl
 * @Create: 2019-02-24 22:18
 **/
public class DownTopOrderBySort extends OrderBySort implements IArrayWork, ISort {

    /**
     * 辅助数组
     */
    private  static Comparable[] aux;

    @Override
    public void work(Comparable[] array) {
        sort(array);
    }

    @Override
    public void sort(Comparable[] needSortArray) {
        int length = needSortArray.length;
        aux = new Comparable[length];

        for (int size = 1; size < length; size += size) {
            System.out.println("size: " + size);
            for (int lo = 0; lo < length - size; lo += size + size) {
                int mid = lo + size - 1;
                int hi = Math.min(lo + size + size -1, length - 1);
                System.out.println(lo + "----" + mid + "-----" + hi);
                merge(needSortArray, aux, lo, mid, hi);
            }
        }
    }
}
