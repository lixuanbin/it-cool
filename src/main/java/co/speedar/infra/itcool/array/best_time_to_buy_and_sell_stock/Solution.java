package co.speedar.infra.itcool.array.best_time_to_buy_and_sell_stock;

class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int max = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                int delta = prices[j] - prices[i];
                if (delta > max) {
                    max = delta;
                }
            }
        }
        return max;
    }
}