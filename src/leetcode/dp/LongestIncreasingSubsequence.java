package leetcode.dp;

import java.util.Arrays;

/**
 * Created by Sou1AtLab on 2018/3/12 0012.
 */
public class LongestIncreasingSubsequence {

    public static void main(String[] args) {
        LongestIncreasingSubsequence temp = new LongestIncreasingSubsequence();
        System.out.println(temp.lengthOfLIS2(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
    }

    public int lengthOfLIS(int[] nums) {
        int length = nums.length;

        int[] dp = new int[length];
        int max = 1;
        dp[0] = 1;

        for (int i = 1; i < length; i++) {
            int currentMax = 0;
            for (int j = 0; j < i; j++) {

                if(nums[j] < nums[i]){
                    currentMax = Math.max(dp[j] + 1, currentMax);
                }
            }
            dp[i] = currentMax;
            max = Math.max(max, dp[i]);
        }

        return max;
    }

    //binary search
    public int lengthOfLIS2(int[] nums) {
        int[] dp = new int[nums.length];
        int len = 0;
        for (int num : nums) {
            int i = Arrays.binarySearch(dp, 0, len, num);
            if (i < 0) {
                i = -(i + 1);
            }
            dp[i] = num;
            if (i == len) {
                len++;
            }
        }
        return len;
    }

}
