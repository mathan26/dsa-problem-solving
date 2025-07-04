package com.mathan.neetcode.binary_search;

public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while(left <= right) {
            int mid = (left+right) / 2;

            if(nums[mid] == target) {
                return mid;
            }

            // left half sorted
            if(nums[left] <=nums[mid]) {
                if(nums[left] <= target && target <nums[mid]) {
                    right = mid - 1;
                }else {
                    left = mid + 1;
                }
            }else {
                // right half sorted
                if(nums[mid] < target && nums[right] >=target ) {
                    left = mid +1;
                }else{
                    right = mid -1;
                }
            }
        }
        return -1;
    }
}
