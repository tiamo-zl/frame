package com.lll.sort.utils;


import com.lll.sort.service.IArrayWork;

/**
 * @ClassName: SortUtils
 * @Description: 这是排序的工具类
 * @Author: zl
 * @Create: 2019-02-23 13:57
 **/
public class SortUtils {

    /**
     * 交换数组中的两个位置的值
     *
     * @param arrays
     * @param i      第一个位置的值
     * @param j      第二个位置的值
     */
    public static void exch(Comparable[] arrays, int i, int j) {
        int length = arrays.length - 1;
        if (i < 0 || j < 0 || length < i || length < j) {
            return;
        }
        Comparable mediant = arrays[i];
        arrays[i] = arrays[j];
        arrays[j] = mediant;
    }

    /**
     * 判断第一个值是否小于第二个值
     *
     * @param frist 第一个值
     * @param last  第二个值
     * @return 小于返回true，不小于返回false
     */
    public static boolean less(Comparable frist, Comparable last) {
        return frist.compareTo(last) < 0 ? true : false;
    }

    /**
     * 判断第一个值是否大于第二个值
     *
     * @param frist 第一个值
     * @param last  第二个值
     * @return 大于返回true，不小于返回false
     */
    public static boolean more(Comparable frist, Comparable last) {
        return frist.compareTo(last) > 0 ? true : false;
    }

    /**
     * 判断一个数组是否是有序的
     *
     * @param array
     * @return
     */
    public static boolean isSorted(Comparable[] array) {
        for (int i = 1; i < array.length; i++) {
            if (less(array[i], array[i - 1])) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        Integer[] a = new Integer[]{1, 2, 3, 4, 5, 6};

        System.out.println(isSorted(a));
    }

    /**
     * 获取初始化数组
     * @return
     */
    private static Integer[] getArray() {
        return new Integer[]{
                89, 88, 87, 86, 45, 44, 43, 42, 41, 40,
                69, 68, 63, 62, 61, 60,73, 72, 71, 70,
                99, 98, 97, 96, 95, 94, 93, 92, 91, 90,
                79, 78, 77, 76, 75, 74, 67, 66, 65, 64,
                59, 58, 57, 56, 55, 54, 53, 52, 51, 50,
                49, 48, 47, 46, 85, 84, 83, 82, 81, 80

        };
    }

    /**
     *
     * 数组进行工作后，打印数组
     * @param iArrayWork
     */
    public static void work(IArrayWork iArrayWork){
        Integer[] array = getArray();
        iArrayWork.work(array);
        print(array);
    }

    public static void print(Comparable[] array){
        int index = 0;
        for(Comparable element : array){
            System.out.print(element + "  ");
            if (++index % 10 == 0){
                System.out.println();
            }
        }
    }

}
