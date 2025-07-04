package com.mathan.neetcode.binary_search;

public class FindMin {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int ans = nums[0]; // Assume first element is the smallest

        // Edge case: only one element
        if (nums.length == 1) {
            return nums[0];
        }

        while (left <= right) {
            // If subarray is already sorted, take the leftmost as min
            if (nums[left] <= nums[right]) {
                ans = Math.min(ans, nums[left]);
                break; // Early exit, we found the minimum
            }

            int mid = (left + right) / 2;
            ans = Math.min(ans, nums[mid]); // Update min answer

            // If left half is sorted, the min must be in the right half
            if (nums[left] <= nums[mid]) {
                left = mid + 1;
            } else {
                // Rotation happened in the left half
                right = mid - 1;
            }
        }

        return ans;
    }
}
