package com.mathan.neetcode.sliding_window.day_08;

import java.util.HashSet;

public class LongestSubStringWithoutRepeatChar {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        if(s.length() == 1){
            return 1;
        }

        int left=0, right = 0;
        int ans = 0;
        HashSet<Character> hashset = new HashSet<>();
        while(right < s.length()) {
            char c = s.charAt(right);
            while(hashset.contains(c)) {
                hashset.remove(s.charAt(left));
                left++;
            }
            hashset.add(c);
            ans = Math.max(ans, right-left+1);
            right++;
        }
        return ans;
    }
}

//
//🟡 Name: Longest Substring Without Repeating Characters
//
//📌 Pattern: Sliding Window + HashSet
//
//🔁 Loop Logic:
//        - Use two pointers: `left` and `right`
//        - Expand `right` one step at a time → check character `s.charAt(right)`
//        - If duplicate is found in the set:
//        → Shrink the window using `while (set.contains(c))` and move `left`
//        - Update max length after each valid step
//
//📦 Tools:
//        - HashSet to track current window characters
//   - Two pointers (`left`, `right`) to define the window
//
//🔑 Key Insight:
//        - Window should always have **unique characters**
//        - `while (set.contains(c))` is **necessary** to:
//        ✅ Remove **all earlier occurrences** of the duplicate
//     ✅ Keep the window **valid** (no repeats)
//
//        🚫 Mistake to Avoid:
//        - Using `if` instead of `while` when handling duplicates
//     → Won’t remove all duplicates → incorrect window → wrong answer
//
//🧠 Think:
//        - "Sliding Window" that dynamically expands and shrinks
//   - Only expand when no repeats, shrink when a duplicate enters

