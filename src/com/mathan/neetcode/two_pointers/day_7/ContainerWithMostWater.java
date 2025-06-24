package com.mathan.neetcode.two_pointers.day_7;

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;
        while (left < right) {
            int width = right - left;
            int minHeight = Math.min(height[left], height[right]);
            // area formula for rectangle
            int area = minHeight * width;
            // update the maxArea
            maxArea = Math.max(maxArea, area);
            // move to next shortline
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }
}
