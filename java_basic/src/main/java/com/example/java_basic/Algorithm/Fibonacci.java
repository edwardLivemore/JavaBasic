package com.example.java_basic.Algorithm;

public class Fibonacci {
    public static void main(String[] args) {
        int num = 10;
        System.out.println(recurse(num));
        System.out.println(duplicateRecurse(new int[num + 1], num));
        System.out.println(dynamic(num));
    }

    // 递归, 时间: O(N*2)
    private static int recurse(int num) {
        if (num == 0 || num == 1) {
            return num;
        }
        return recurse(num - 2) + recurse(num - 1);
    }

    // 去重递归, 时间: O(N), 空间: O(N)
    private static int duplicateRecurse(int array[], int num) {
        if (num == 0 || num == 1) {
            return num;
        }
        if (array[num] == 0) {
            array[num] = duplicateRecurse(array, num - 2) + duplicateRecurse(array, num - 1);
        }
        return array[num];
    }

    // 双指针(动态规划), 时间: O(N), 空间: O(1)
    private static int dynamic(int num) {
        if (num == 0 || num == 1) {
            return num;
        }

        int first = 0, second = 1;
        for (int i = 2; i <= num; i++) {
            int sum = first + second;
            first = second;
            second = sum;
        }

        return second;
    }
}
