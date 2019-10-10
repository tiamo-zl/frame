package com.lll.sort.service.impl.insertongsort;


import com.lll.sort.service.IArrayWork;
import com.lll.sort.service.ISort;
import com.lll.sort.utils.SortUtils;

/**
 * @ClassName: ShellSort
 * @Description: 这是一个希尔排序
 * @Author: zl
 * @Create: 2019-02-23 13:56
 **/
public class ShellSort implements IArrayWork, ISort {


    /**
     * 将数组进行希尔排序，返回排序后的数组
     *
     * @param needSortArray
     * @return
     */
    @Override
    public void sort(Comparable[] needSortArray) {

        int length = needSortArray.length;
        int h = 1;

        while (h < length / 3) {
            //1,4,13,40,121,364,1093
            h = h * 3 + 1;
        }

        while (h >= 1) {
            // 将数组变为 h 有序
            for (int i = h; i < length; i++) {
                // 将a[i] 插入到 a[i-h], a[i-2*h], a[i-3*h] ...之中

                for (int j = i; j >= h && SortUtils.less(needSortArray[j], needSortArray[j - h]); j -= h) {
                    SortUtils.exch(needSortArray, j, j - h);
                }
            }
            h = h / 3;
        }

    }

    @Override
    public void work(Comparable[] array) {
        sort(array);
    }

}
