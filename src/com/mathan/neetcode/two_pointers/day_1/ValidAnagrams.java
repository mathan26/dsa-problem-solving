package com.mathan.neetcode.two_pointers.day_1;

public class ValidAnagrams {
    public boolean isAnagram(String s, String t) {
        // length is not matched then this is not anagram
        if (s.length() != t.length()) {
            return false;
        }

        // array for couting char frequencies
        int[] charCounts = new int[26]; //assume lowercase only

        for (int i = 0; i < s.length(); i++) {
            // one char at array location add ++
            charCounts[s.charAt(i) - 'a']++;
            // for the other char minus --
            charCounts[t.charAt(i) - 'a']--;
        }

        for (int num : charCounts) {
            // if this mets then not an valid anagram
            if (num != 0) {
                return false;
            }
        }
        // other wise s and t has same letters
        return true;
    }
}
