package com.mathan.neetcode.binary_search;

public class KokoEatingBananas {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1; // Minimum possible speed
        int right = 1; // Will hold the maximum pile size

        // Step 1: Find the maximum pile size
        for (int i : piles) {
            right = Math.max(i, right);
        }

        // Step 2: Binary Search to find the minimum K that allows Koko to finish in h hours
        while (left < right) {
            int mid = left + (right - left) / 2; // Try mid speed

            if (canFinish(h, mid, piles)) {
                right = mid; // Try to find a smaller speed
            } else {
                left = mid + 1; // Need to increase speed
            }
        }

        // Step 3: Left is the minimum speed that works
        return left;
    }

    // Helper method to check if Koko can eat all bananas at given speed within h hours
    public boolean canFinish(int h, int speed, int[] piles) {
        int hours = 0;

        for (int pile : piles) {
            // Time to finish current pile at given speed (use ceil)
            hours += Math.ceil((double) pile / speed);
        }

        return hours <= h; // True if she can finish within h hours
    }
}
