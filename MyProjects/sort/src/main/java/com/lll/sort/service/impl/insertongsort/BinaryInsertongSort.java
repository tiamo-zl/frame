package com.lll.sort.service.impl.insertongsort;

import com.lll.sort.service.IArrayWork;
import com.lll.sort.service.ISort;
import com.lll.sort.utils.SortUtils;

/**
 * @ClassName: BinaryInsertongSort
 * @Description: 二分插入排序
 * @Author: zl
 * @Create: 2019-02-23 22:15
 **/
public class BinaryInsertongSort implements ISort, IArrayWork {

    /**
     * 二分插入排序
     * @param needSortArray
     */
    @Override
    public  void sort(Comparable[] needSortArray) {
        int length = needSortArray.length;
        for (int i = 0; i < length - 1; i++) {
            int targetIndex = i + 1;
            Comparable target = needSortArray[targetIndex];

            int spitIndex = binarySearch(needSortArray,0,i, target);
            System.out.println(spitIndex);
            //没有找到
            if (spitIndex < 0){
                //数组位置变换
                retrusion(needSortArray, 0-spitIndex + 1, targetIndex);
            //找到了，或者是找不到（比最小的还小）
            }else{
                //数组位置后移
                retrusion(needSortArray, spitIndex, targetIndex);
            }
        }
    }

    /**
     * 数组从index的位置开始后移一位，直到 target位置
     * @param needSortArray
     * @param index
     * @param target
     */
    public void retrusion(Comparable[] needSortArray, int index, int target){
        SortUtils. print(needSortArray);
        System.out.println(index + "---" + target);
        Comparable last = needSortArray[target];
        for (int i = target; i > index; i--) {
            needSortArray[i] = needSortArray[i-1];
        }
        needSortArray[index] = last;
    }

    /**
     * 查找需要插入的位置index
     * @param array
     * @param element
     * @return
     */
    public int binarySearch(Comparable[] array,int lo, int hi, Comparable element){
        int length = array.length;
        int mid = (lo + hi)/2;
        while (lo <= hi && 0 <= mid && mid < length) {
            int compareValue = array[mid].compareTo(element);
            if (compareValue < 0) {
                lo = mid + 1;
                mid = (lo + hi)/2;
            }else if (compareValue > 0){
                hi = mid - 1;
                mid = (lo + hi)/2;
            }else {
                return mid;
            }
        }
        return 0 - mid;
    }

    
    @Override
    public void work(Comparable[] array) {
        sort(array);
    }

}
