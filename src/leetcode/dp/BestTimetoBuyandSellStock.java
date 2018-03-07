package leetcode.dp;

public class BestTimetoBuyandSellStock {

    public static void main(String[] args) {
        int[] arr = new int[]{3,3,5,0,0,3,1,4};
        System.out.println(maxProfit3(arr));
    }

    public static int maxProfit1(int[] prices) {
//        int minprice = Integer.MAX_VALUE;
//        int maxprofit = 0;
//        for (int i = 0; i < prices.length; i++) {
//            if (prices[i] < minprice) {
//                minprice = prices[i];
//            }
//            else if (prices[i] - minprice > maxprofit) {
//                maxprofit = prices[i] - minprice;
//            }
//        }
//        return maxprofit;
        int maxCur = 0, maxSoFar = 0;
        for(int i = 1; i < prices.length; i++) {
            maxCur = Math.max(0, maxCur += prices[i] - prices[i-1]);
            maxSoFar = Math.max(maxCur, maxSoFar);
        }
        return maxSoFar;
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

    public static int maxProfit3(int[] prices) {
        //convert this problem to find the top two maximum subarray sum
        //twoProfit is the new array mentioned above
        int length = prices.length;
        if(length == 0){
            return 0;
        }
        int[] twoProfit = new int[length];
        int[][] dp = new int[2][length];
        int currentProfit = 0;
        int maxProfit = 0;


        for (int i = 1; i < length; i++) {
            twoProfit[i] = prices[i] - prices[i-1];
        }
        //twoProfit is the new array mentioned above

        for (int j = 0; j < length; j++) {
            if(currentProfit + twoProfit[j] >= 0){
                currentProfit = currentProfit + twoProfit[j];
                maxProfit = Math.max(currentProfit, maxProfit);
                dp[0][j] = maxProfit;
            }else{
                dp[0][j] = dp[0][j-1];
                currentProfit = 0;
            }
        }

        for (int i = 0; i < length; i++) {
            System.out.print(dp[0][i] + "\t");
        }
        System.out.println("\n");

        for (int j = 1; j < length; j++) {
            if(twoProfit[j] >= 0){
                dp[1][j] = Math.max(dp[1][j-1] + twoProfit[j], dp[1][j-1]);
            }else{
                dp[1][j] = Math.max(dp[0][j-1] + twoProfit[j], dp[1][j-1]);
            }
        }

        return dp[1][length-1];
    }
}
