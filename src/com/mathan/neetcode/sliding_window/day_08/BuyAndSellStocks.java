package com.mathan.neetcode.sliding_window.day_08;

public class BuyAndSellStocks {
    // It's about tracking the minimum so far and comparing it with the current price to get max profit.
//🟡 Name: Best Time to Buy and Sell Stock

// 📌 Pattern:
//    - Track min so far
//    - Check today's price - min so far
//    - Greedy approach (similar to Kadane’s)

// 🔁 Loop Logic:
//    - If price < min -> update min
//    - Else update profit = max(profit, price - min)

// 🧠 Key Variables:
//    minPrice = Integer.MAX_VALUE
//    maxProfit = 0

// 💡 Why it works:
//    - Buying low, selling high.
//    - Only one transaction allowed.
//    - One-pass, O(n) time.

    public int maxProfit(int[] prices) {
        int profit = 0;
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
            }
            profit = Math.max(profit, (prices[i] - min));
        }
        return profit;
    }
}


