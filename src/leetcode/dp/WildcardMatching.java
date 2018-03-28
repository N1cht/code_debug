package leetcode.dp;

/**
 * Created by Sou1AtLab on 2018/3/9 0009.
 */
public class WildcardMatching {

    public static void main(String[] args) {
        //System.out.println(isMatch("abefcdgiescdfimde", "ab*cd?i*de"));
        System.out.println(isMatch2("aa", ".*"));
    }

    public static boolean isMatch(String s, String p) {
        int strLength1 = s.length();
        int strLength2 = p.length();

        boolean dp[][] = new boolean[strLength2 + 1][strLength1 + 1];

        dp[0][0] = true;

        for (int i = 1; i <= strLength2 ; i++) {
            dp[i][0] = (p.charAt(i - 1) == '*') && dp[i - 1][0];
        }

        for (int i = 1; i < strLength2 + 1; i++) {
            for (int j = 1; j < strLength1 + 1; j++) {
                if(p.charAt(i - 1) != '*'){
                    if(p.charAt(i - 1) == '?'){
                        dp[i][j] = dp[i - 1][j - 1];
                    }else{
                        dp[i][j] = (s.charAt(j - 1) == p.charAt(i - 1)) && dp[i - 1][j - 1];
                    }
                }else{
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                }
            }
        }

        return dp[strLength2][strLength1];
    }

    public static boolean isMatch2(String s, String p) {
        int strLength1 = s.length();
        int strLength2 = p.length();

        boolean dp[][] = new boolean[strLength1 + 1][strLength2 + 1];

        dp[0][0] = true;

        for (int i = 1; i <= strLength2; i++) {
            if (p.charAt(i - 1) == '*' && i > 1){
                dp[0][i] = dp[0][i - 2];
            }
        }

        for (int i = 1; i <= strLength1; i++) {
            for (int j = 1; j <= strLength2; j++) {
                if (p.charAt(j - 1) == '.'){
                    dp[i][j] = dp[i - 1][j - 1];
                }else if (p.charAt(j - 1) == '*'){
                    if(j > 2 && dp[i][j - 2]){
                        dp[i][j] = true;
                    }else{
                        dp[i][j] = dp[i][j - 2] || (dp[i - 1][j] && (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.'));
                    }
                }else{
                    dp[i][j] = dp[i - 1][j - 1] && (s.charAt(i - 1) == p.charAt(j - 1));
                }
            }
        }

        return dp[strLength1][strLength2];
    }
}
