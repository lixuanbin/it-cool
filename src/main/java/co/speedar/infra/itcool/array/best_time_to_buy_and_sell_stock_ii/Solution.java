package co.speedar.infra.itcool.array.best_time_to_buy_and_sell_stock_ii;

class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        // 贪心策略，一趟遍历
        boolean isHeld = false;
        int lastPrice = 0;
        int profit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (i < prices.length - 1 && !isHeld) {
                // 是否应该买
                if (prices[i + 1] > prices[i]) {
                    isHeld = true;
                    lastPrice = prices[i];
                    continue;
                }
            }
            if (isHeld) {
                if (i == prices.length - 1 || prices[i + 1] < prices[i]) {
                    // 是否应该卖
                    isHeld = false;
                    profit += prices[i] - lastPrice;
                    lastPrice = 0;
                }
            }
        }
        return profit;
    }
}