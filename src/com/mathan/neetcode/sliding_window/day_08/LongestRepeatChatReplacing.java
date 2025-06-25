package com.mathan.neetcode.sliding_window.day_08;

public class LongestRepeatChatReplacing {
    public int characterReplacement(String s, int k) {
        int[] occurance = new int[26];
        int left = 0, right = 0;
        int ans = 0;
        int maxOccurance = 0;

        for (; right < s.length(); right++) {
            maxOccurance = Math.max(maxOccurance, ++occurance[s.charAt(right) - 'A']);
            int currentWindowLength = right - left + 1;
            if (currentWindowLength - maxOccurance > k) {
                occurance[s.charAt(left) - 'A']--;
                left++;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
}
/*
🟡 Name: Longest Repeating Character Replacement

📌 Pattern: Sliding Window + Frequency Array

🧠 Goal:
        - Find the length of the longest substring that can be converted
into all same characters by replacing at most `k` characters.

🔁 Sliding Window Logic:
        - Move `right` to expand the window.
        - Track frequency of each character using a 26-sized array.
        - `maxOccurance` = most frequent character in the window.
        - If (window size - maxOccurance) > k → window is invalid.
     ➤ Shrink window from the `left`.

        📦 Variables:
        - `occurance[26]` → frequency of characters in current window
   - `maxOccurance` → highest frequency char in window
   - `ans` → max valid window length found

🔑 Key Insight:
        - To make all characters the same:
        ➤ Replace all non-majority characters (i.e., `windowSize - maxOccurance`)
   - Window is valid as long as `charsToChange <= k`

        🚫 Common Mistake:
        - Recalculating `maxOccurance` every time is NOT needed.
     ➤ Just keep it as the maximum seen so far. It works because window shrinks only if needed.

⏱️ Time Complexity:
        - O(n), where n is the length of the string.

        ✅ Edge Example:
        - s = "AABABBA", k = 1 → max length = 4
        */
