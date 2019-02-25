package com.lll.sort.utils;


import com.lll.sort.service.IArrayWork;
import com.lll.sort.service.impl.insertongsort.BinaryInsertongSort;
import com.lll.sort.service.impl.insertongsort.InsertionSort;
import com.lll.sort.service.impl.insertongsort.ShellSort;
import com.lll.sort.service.impl.mergesort.DownTopOrderBySort;
import com.lll.sort.service.impl.mergesort.TopDownOrderBySort;
import com.lll.sort.service.impl.quicksort.QuickSort;
import com.lll.sort.service.impl.selectionsort.SelectionSort;

public enum SortMnum {

    Selection_Sort(new SelectionSort()),
    Shell_Sort(new ShellSort()),
    Binary_Insertong_Sort(new BinaryInsertongSort()),
    Insertion_Sort(new InsertionSort()),
    TopDown_OrderBy_Sort(new TopDownOrderBySort()),
    DownTop_OrderBy_Sort(new DownTopOrderBySort()),
    Quick_Sort(new QuickSort()),
    ;


    public IArrayWork sort;

    private SortMnum(IArrayWork sort) {
        this.sort = sort;
    }
}
