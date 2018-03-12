package leetcode.dp;

/**
 * Created by Sou1AtLab on 2018/3/12 0012.
 */
public class UglyNumber {
    public int nthUglyNumber(int n) {

        int[] dp = new int[n];
        dp[0] = 1;
        int twoB = 0;
        int threeB = 0;
        int fiveB = 0;
        for(int i = 1; i < n; i++){
            dp[i] = Math.min(Math.min(dp[twoB] * 2, dp[threeB] * 3), dp[fiveB] * 5);
            if (dp[i] == dp[twoB] * 2) twoB++;
            if (dp[i] == dp[threeB] * 3) threeB++;
            if (dp[i] == dp[fiveB] * 5) fiveB++;
        }

        return dp[n - 1];
    }
}
