package com.mathan.neetcode.day_02;

import java.util.HashMap;
import java.util.Map;

public class TwoSums {
    public int[] twoSum(int[] nums, int target) {
        // good for tracking and quick access
        Map<Integer, Integer> map = new HashMap<>();

        // iterate and identify target-value is present or not
        for (int i=0; i < nums.length; i++) {
            int complement = target - nums[i];

            if(map.containsKey(complement)) {
                return new int[] {map.get(complement), i};
            }
            map.put(nums[i], i);
        }

        return new int[]{};
    }
}
