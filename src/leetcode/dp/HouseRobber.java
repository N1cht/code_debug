package leetcode.dp;

/**
 * Created by Sou1AtLab on 2018/3/10 0010.
 */
public class HouseRobber {

    public static void main(String[] args) {
        System.out.println(rob(new int[]{2,1}));
    }

    public static int rob(int[] nums) {
        int length = nums.length;
        if(length == 0) return 0;
        if(length == 1) return nums[length - 1];
        int[] dp = new int[length + 1];
        dp[0] = 0;
        dp[1] = nums[0];

        for(int i = 2; i <= length; i++){
            dp[i] = Math.max(dp[i - 2] + nums[i - 1], dp[i - 1]);
        }

        return Math.max(dp[length], dp[length - 1]);
    }
}
