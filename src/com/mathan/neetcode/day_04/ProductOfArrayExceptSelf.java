package com.mathan.neetcode.day_04;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        // brute force two for loop except first loop index
        // optimal
        // prefix and suffix sum

        int[] result = new int[nums.length];
        Arrays.fill(result, 1);

        int pre = 1, post = 1;
        // Left Pass - Store prefix product
        for (int i = 0; i < nums.length; i++) {
            result[i] = pre;
            pre = nums[i] * pre;
        }
        // Right Pass - Multiply suffix product
        for (int i = nums.length - 1; i >= 0; i--) {
            // result[i] * post ---> because final result prefix * post
            result[i] = result[i] * post;
            post = post * nums[i];
        }
        return result;
    }
}
