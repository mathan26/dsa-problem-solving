package com.mathan.neetcode.array_and_hashing.day_03;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

//https://leetcode.com/problems/top-k-frequent-elements/submissions/1670091903/
public class TopKFreqElement {
    public int[] topKFrequent(int[] nums, int k) {

        // edge case
        if (k == nums.length) {
            return nums;
        }

        //map for iterate and count
        Map<Integer, Integer> countMap = new HashMap<>();

        for (int n : nums) {
            countMap.put(n, countMap.getOrDefault(n, 0) + 1);
        }
        // used for keep only max element, understand poll and how comparator works
        Queue<Integer> heap = new PriorityQueue<>((a, b) -> (countMap.get(a) - countMap.get(b)));

        for (int n : countMap.keySet()) {
            heap.add(n);
//            once above the k size poll so least saved element will be removed
            if (heap.size() > k) {
                heap.poll();
            }
        }
        int[] ans = new int[k];

        for (int i = 0; i < k; i++) {
            ans[i] = heap.poll();
        }
        return ans;
    }
}
