package leetcode.dp;

public class BestTimetoBuyandSellStock {

    public static void main(String[] args) {
        int[] arr = new int[]{8,3,6,2,8,8,8,4,2,0,7,2,9,4,9};
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
        if(length <= 1){
            return 0;
        }
        int[] interpolation = new int[length];
        int[][] sum = new int[3][length];
        int[][] maxSum = new int[3][length];


        for (int i = 1; i < length; i++) {
            interpolation[i] = prices[i] - prices[i-1];
        }
        //twoProfit is the new array mentioned above

        for (int i = 1; i < length; i++) {
            maxSum[0][i] = (maxSum[0][i-1] + interpolation[i]) > 0 ? maxSum[0][i-1] + interpolation[i] : 0;
        }

        for (int j = 1; j < length; j++) {
            sum[1][j] = (maxSum[1][j-1] + interpolation[j]) > 0 ? maxSum[0][j-1] + interpolation[j] : 0;
            maxSum[1][j] = Math.max(maxSum[0][j-1] + interpolation[j], maxSum[1][j-1]);
        }

        for (int k = 1; k < length; k++) {
            if(sum[2][k - 1] == maxSum[2][k - 1]) {
                sum[2][k] = maxSum[2][k - 1] + interpolation[k];
                maxSum[2][k] = Math.max(maxSum[2][k - 1] + interpolation[k], maxSum[2][k - 1]);
            }else{
                sum[2][k] = maxSum[1][k - 1] + interpolation[k];
                maxSum[2][k] = Math.max(maxSum[1][k - 1] + interpolation[k], maxSum[2][k - 1]);
            }
        }

        return maxSum[2][length-1];
    }
}
