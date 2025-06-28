package com.mathan.neetcode.stack.day09;

import java.util.Stack;

public class DailyTemperature {
    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        solution.dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73});
    }
}
class Solution2 {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;

        // This array will store the answer for each day
        int[] ans = new int[n];

        // Stack to keep the indices of temperatures, not the values themselves
        Stack<Integer> stack = new Stack<>();

        // Loop through each day's temperature
        for (int i = 0; i < n; i++) {

            // While stack is not empty AND current temperature is warmer
            // than the temperature at the index on top of the stack
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {

                // Pop the index from the stack since we found a warmer day
                int index = stack.pop();

                // Calculate how many days we waited and store in the answer array
                ans[index] = i - index;
            }

            // Push the current day's index onto the stack
            // We'll find its warmer day in the future
            stack.push(i);
        }

        // Return the final answer array
        return ans;
    }
}
