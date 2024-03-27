package com.example.java_basic.Algorithm;

public class SqrtX {
    public static void main(String[] args) {
        int x = 24;
        System.out.println(binarySearch(x));
        System.out.println(newton(x));
    }

    private static Integer binarySearch(int x) {
        Integer index = null;
        int left = 0, right = x;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid * mid <= x) {
                index = mid;
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }
        return index;
    }

    private static Integer newton(int x) {
        if (x == 0) {
            return 0;
        }
        return (int)sqrtX(x, x);
    }

    private static double sqrtX(double i, int x) {
        double res = (i + x/i)/2;
        if (res == i) {
            return i;
        }
        return sqrtX(res, x);
    }

}
