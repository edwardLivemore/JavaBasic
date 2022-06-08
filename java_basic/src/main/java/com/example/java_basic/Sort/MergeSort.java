package com.example.java_basic.Sort;

public class MergeSort {
    public static void sort(int[] array, int left, int right){
        if(right <= left){
            return;
        }

        int mid = (left + right) >> 1;

        sort(array, left, mid);
        sort(array, mid + 1, right);
        merge(array, left, mid, right);
    }

    private static void merge(int[] array, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;

        while(i <= mid && j <= right){
            temp[k++] = array[i] <= array[j] ? array[i++] : array[j++];
        }

        while(i <= mid) temp[k++] = array[i++];
        while(j <= right) temp[k++] = array[j++];

        System.arraycopy(temp, 0, array, left, temp.length);
    }
}
