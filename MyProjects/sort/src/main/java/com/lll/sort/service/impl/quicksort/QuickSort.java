package com.lll.sort.service.impl.quicksort;


import com.lll.sort.service.IArrayWork;
import com.lll.sort.service.ISort;
import com.lll.sort.utils.SortUtils;

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
     *
     * @param needSortArray 需要排序的算法
     * @param lo            排序的开始位置
     * @param hi            排序的结束位置
     */
    private void sort(Comparable[] needSortArray, int lo, int hi) {
        if (hi <= lo) {
            return;
        }
        int point = partition(needSortArray, lo, hi);
        sort(needSortArray, lo, point - 1);
        sort(needSortArray, point + 1, hi);
    }

    /**
     * 找到切点
     *
     * @param needSortArray 需要进行操作的数组
     * @param lo            排序的开始位置
     * @param hi            排序的结束位置
     * @return 返回切点的index
     */
    private int partition(Comparable[] needSortArray, int lo, int hi) {
        //将数组切为 [lo ... point] [point] [point ... hi]
        Comparable pointElement = needSortArray[lo];
        // 左指针
        int leftIndex = lo;
        // 右指针
        int rightIndex = hi + 1;
        while (true) {
            // 扫描左右， 检查扫描是否结束并交换元素
            while (SortUtils.less(needSortArray[++leftIndex], pointElement)) {
                if (leftIndex == hi) {
                    break;
                }
            }

            while (SortUtils.less(pointElement, needSortArray[--rightIndex])) {
                if (rightIndex == lo) {
                    break;
                }
            }

            if (leftIndex >= rightIndex) {
                break;
            }
            SortUtils.exch(needSortArray, leftIndex, rightIndex);

        }

        SortUtils.exch(needSortArray, lo, rightIndex);

        return rightIndex;
    }
}
