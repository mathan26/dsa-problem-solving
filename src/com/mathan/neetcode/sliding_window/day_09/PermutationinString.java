package com.mathan.neetcode.sliding_window.day_09;

import java.util.Arrays;

public class PermutationinString {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }

        int[] s1count = new int[26];
        int[] s2count = new int[26];

        // count freq of char in s1 and s2

        for (int i = 0; i < s1.length(); i++) {
            s1count[s1.charAt(i) - 'a']++;
            s2count[s2.charAt(i) - 'a']++;
        }

        if (Arrays.equals(s1count, s2count)) {
            return true;
        }

        //slide the window
        for (int i = s1.length(); i < s2.length(); i++) {
            s2count[s2.charAt(i) - 'a']++; // add new char
            s2count[s2.charAt(i - s1.length()) - 'a']--; //remove old char from s2 for maintain window size //brack mistake might be happen carful
            if (Arrays.equals(s1count, s2count)) {
                return true;
            }
        }
        return false;
    }
}
