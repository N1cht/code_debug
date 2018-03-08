package leetcode.dp;

public class BestTimetoBuyandSellStock {

    public static void main(String[] args) {
        int[] arr = new int[]{1,2};
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
        /* this way fails
        //convert this problem to find the top two maximum subarray sum
        //twoProfit is the new array mentioned above
        int length = prices.length;
        if(length <= 1){
            return 0;
        }
        int[] interpolation = new int[length];
        int[][] maxSum = new int[3][length];

        for (int i = 1; i < length; i++) {
            interpolation[i] = prices[i] - prices[i-1];
        }
        //twoProfit is the new array mentioned above

        for (int i = 1; i < length; i++) {
            maxSum[0][i] = (maxSum[0][i-1] + interpolation[i]) > 0 ? maxSum[0][i-1] + interpolation[i] : 0;
        }

        for (int j = 1; j < length; j++) {
            maxSum[1][j] = Math.max(maxSum[0][j-1] + interpolation[j], maxSum[1][j-1]);
        }

        for (int k = 1; k < length; k++) {
            maxSum[2][k] = Math.max(maxSum[2][k - 1] + interpolation[k], maxSum[2][k - 1]);
        }

        return maxSum[2][length-1];*/
        int length = prices.length;
        if(length <= 1){
            return 0;
        }
        int ret = 0;
        int minPrice = prices[0];
        int maxPrice = prices[length - 1];
        int[] forward = new int[length];
        int[] backward = new int[length];

        for(int i = 1; i < length; i++){
            minPrice = Math.min(minPrice, prices[i]);
            forward[i] = Math.max(forward[i - 1], prices[i] - minPrice);
        }

        for(int j = length - 2; j >= 0; j--){
            maxPrice = Math.max(maxPrice, prices[j]);
            backward[j] = Math.max(backward[j + 1], maxPrice - prices[j]);
        }

        for (int k = 0; k < length; k++) {
            ret = Math.max(forward[k] + backward[k], ret);
        }

        return ret;
    }
}
