package leetcode.dp;

public class BestTimetoBuyandSellStock {

    public static void main(String[] args) {

    }

    public static int maxProfit1(int[] prices) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice) {
                minprice = prices[i];
            }
            else if (prices[i] - minprice > maxprofit) {
                maxprofit = prices[i] - minprice;
            }
        }
        return maxprofit;
    }
    public static int maxProfit2(int[] prices) {

        int length = prices.length;
        if(length == 0) {
            return 0;
        }

        int currentProfit = 0;
        int sumProfit = 0;
        int minPrice = prices[0];

        for (int i = 1; i < length; i++) {

            if(prices[i] < minPrice){
                minPrice = prices[i];
            }

            if(prices[i] >= prices[i-1]){
                currentProfit = prices[i] - minPrice;
            }else{
                minPrice = prices[i];
                sumProfit += currentProfit;
                currentProfit = 0;
            }
        }
        return sumProfit + currentProfit;
    }
}
