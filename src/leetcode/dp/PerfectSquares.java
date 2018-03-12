package leetcode.dp;

/**
 * Created by Sou1AtLab on 2018/3/12 0012.
 */
public class PerfectSquares {

    public int numSquares(int n) {
        int[] sum = new int[n + 1];
        int len = (int)Math.sqrt(n);
        sum[1] = 1;
        for(int i = 2; i <= n; i++){
            int min = Integer.MAX_VALUE;
            for(int j = 1; j <= len; j++){
                if (j * j <= i) {
                    min = Math.min(min, sum[i - j * j] + 1);
                }
            }
            sum[i] = min;
        }
        return sum[n];
    }
}
