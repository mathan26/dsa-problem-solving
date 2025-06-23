package com.mathan.neetcode.array_and_hashing.day_05;

import java.util.HashSet;

//https://leetcode.com/problems/longest-consecutive-sequence/description/
public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        HashSet<Integer> set = new HashSet<>();

        for (int n : nums) {
            set.add(n);
        }

        int lcs = 1;
        // Iterate from the set not number
        for (int n : set) {
            if (set.contains(n - 1)) {
                continue;
            } else {
                int currentNum = n;
                int count = 1;
                while (set.contains(currentNum + 1)) {
                    count++;
                    currentNum++;
                }
                // if greater the lcs assign current lcs
                if (count > lcs) {
                    lcs = count;
                }
            }

        }
        return lcs;
    }
}
