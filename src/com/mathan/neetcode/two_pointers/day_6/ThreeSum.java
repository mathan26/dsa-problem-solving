package com.mathan.neetcode.two_pointers.day_6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        // sort to find duplicate
        Arrays.sort(nums);
        // store result
        List<List<Integer>> result = new ArrayList<>();

        // iterate and nums[i] <= 0; we dont want to check num >=0 i.e that end with > 0
        // Step 2: Fix the first element one by one and find the other two using two pointers
        for (int i = 0; i < nums.length && nums[i] <= 0; i++) {
            // Skip duplicate elements to avoid duplicate triplets
            if (i == 0 || nums[i] != nums[i - 1]) {
                // Call helper to find pairs that sum with nums[i] to zero
                twoSum2(nums, i, result);
            }
        }
        return result;
    }

    void twoSum2(int[] nums, int i, List<List<Integer>> result) {
        // Pointer to the element just after i
        int left = i + 1;
        int right = nums.length - 1;

        while (left < right) {
            int sum = nums[i] + nums[left] + nums[right];
            // If sum is less than zero, we need a larger number → move left pointer forward
            if (sum < 0) {
                left++;
            } else if (sum > 0) {
                // If sum is more than zero, we need a smaller number → move right pointer backward
                right--;
            } else {
                // Triplet found with zero sum → add to result list
                result.add(Arrays.asList(nums[i], nums[left++], nums[right--]));
                // Skip duplicates for the second number
                while (left < right && nums[left] == nums[left - 1]) {
                    ++left;
                }
            }

        }
    }
}
