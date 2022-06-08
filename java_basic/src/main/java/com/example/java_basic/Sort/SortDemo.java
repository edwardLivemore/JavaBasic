package com.example.java_basic.Sort;

import java.util.Arrays;

public class SortDemo {
    public static void main(String[] args) {
        int[] array = new int[]{3, 44, 38, 5, 41, 1};
        QuickSort.sort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));

        array = new int[]{3, 44, 38, 5, 41, 1};
        MergeSort.sort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }
}
