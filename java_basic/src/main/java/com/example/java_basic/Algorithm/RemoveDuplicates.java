package com.example.java_basic.Algorithm;

public class RemoveDuplicates {
    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[]{1,2}));
        System.out.println(removeDuplicates(new int[]{1,1,1}));
        System.out.println(removeDuplicates(new int[]{1,1,2}));
        System.out.println(removeDuplicates(new int[]{1,1,2,2,2}));
        System.out.println(removeDuplicates(new int[]{1,2,3}));
        System.out.println(removeDuplicates(new int[]{1,1,2,2,3,3,4}));
        System.out.println(removeDuplicates(new int[]{1,1,1,2}));
        System.out.println(removeDuplicates(new int[]{1,1,1,2,2,2}));
        System.out.println(removeDuplicates(new int[]{1,1,1,2,2,2,3}));
    }

    private static int removeDuplicates(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }

        int slow = 0;
        for (int fast = 1; fast < nums.length; fast++) {
            if (nums[fast] == nums[slow]) {
                if (fast + 1 < nums.length) {
                    nums[slow + 1] = nums[fast + 1];
                }
            } else {
                slow++;
            }
        }
        return slow + 1;
    }
}
