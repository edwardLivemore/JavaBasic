package com.example.java_basic.Sort;

public class QuickSort {
    public static void sort(int[] array, int begin, int end){
        if(end <= begin){
            return;
        }

        int pivot = getPivot(array, begin, end);
        sort(array, begin, pivot - 1);
        sort(array, pivot + 1, end);
    }

    private static int getPivot(int[] array, int begin, int end) {
        int pivot = array[end];
        int count = begin;
        for(int i = begin; i < end; i++){
            if(array[i] < pivot){
                int temp = array[i];
                array[i] = array[count];
                array[count] = temp;
                count++;
            }
        }
        int temp = array[count];
        array[count] = array[end];
        array[end] = temp;
        return count;
    }
}
