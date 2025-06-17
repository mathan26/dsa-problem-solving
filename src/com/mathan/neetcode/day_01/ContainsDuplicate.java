package com.mathan.neetcode.day_01;

import java.util.HashSet;

public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        // set will have only unique value
        HashSet<Integer> seenNumbers = new HashSet<>();

        // iterate
        for(int num : nums) {
            // if already num is there then duplicate already exist
            if(seenNumbers.contains(num)) {
                return true;
            }
            // otherwise add the number to hashset
            seenNumbers.add(num);
        }
        // after iterating all the list return false
        return false;

    }
}
