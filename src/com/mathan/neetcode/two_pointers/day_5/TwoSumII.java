package com.mathan.neetcode.two_pointers.day_5;

public class TwoSumII {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;

        // Two points to track and check the target since it is sorted
        while (left < right) {
            int currentSum = numbers[left] + numbers[right];
            if (currentSum == target) {
                return new int[] { left + 1, right + 1 };
            }
            // target is less than currentSum so move right ptr to before
            // so that sum will be reduced
            if (currentSum > target) {
                right--;
            } else {
                left++;
            }
        }
        return new int[] { left + 1, right + 1 };
    }
}
