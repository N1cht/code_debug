package leetcode.dp;

/**
 * Created by Sou1AtLab on 2018/3/8 0008.
 */
public class InterleavingString {

    public static void main(String[] args) {

    }

    public static boolean isInterleave(String s1, String s2, String s3) {
        int strLength1 = s1.length();
        int strLength2 = s2.length();

        if(strLength1 + strLength2  != s3.length()) return false;

        //dp[i][j]represent that whether s3.substring(0, i+j+1) is interleaving of s1.substring(0, i+1) and s2.substring(0, j+1)
        boolean[][] dp = new boolean[strLength1 + 1][strLength2 + 1];

        dp[0][0] = true;

        for (int i = 1; i < strLength1 + 1; i++) {
            dp[i][0] = dp[i - 1][0] && s1.charAt(i - 1) == s3.charAt(i - 1);
        }

        for (int j = 1; j < strLength2 + 1; j++) {
            dp[0][j] = dp[0][j - 1] && s2.charAt(j - 1) == s3.charAt(j - 1);
        }

        for (int i = 1; i < strLength1 + 1; i++) {
            for (int j = 1; j < strLength2 + 1; j++) {
                dp[i][j] = (dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1)) || (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1));
            }
        }

        return dp[strLength1][strLength2];
    }
}
