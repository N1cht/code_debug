package leetcode.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sou1AtLab on 2018/3/9 0009.
 */
public class PalindromePartitioning {
    private List<String> currentPartition;
    private List<List<String>> result;

    public static void main(String[] args) {

        PalindromePartitioning temp = new PalindromePartitioning();

        System.out.println(temp.minCut("abab"));
    }

    public List<List<String>> partition(String s) {
        result = new ArrayList<List<String>>();
        currentPartition = new ArrayList<String>();

        dfs(s, 0);
        return result;
    }

    private void dfs(String s, int startIndex){
        if(currentPartition.size() > 0 && startIndex >= s.length()) {
            List<String> temp = new ArrayList<String>();
            for (int i = 0; i < currentPartition.size(); i++) {
                temp.add(currentPartition.get(i));
            }

            result.add(temp);
        }
        for (int i = startIndex; i < s.length(); i++) {
            if(isPalindrome(s, startIndex, i)){
                currentPartition.add(s.substring(startIndex, i + 1));
                dfs(s, i + 1);
                currentPartition.remove(currentPartition.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String str, int startIndex, int endIndex){

        if(startIndex == endIndex) return true;
        while(startIndex < endIndex){
            if(str.charAt(startIndex) != str.charAt(endIndex)) return false;
            startIndex ++;
            endIndex --;
        }
        return true;
    }

    //TODO use manachar to solve this problem, maybe O(n)?
    public int minCut(String s) {
        int len = s.length();

        boolean[][] matrix = new boolean[len][len];
        int cuts[] = new int[len+1];

        if (s == null || s.length() == 0)
            return 0;
        for (int i=0; i<len; ++i){
            cuts[i] = len - i;  //cut nums from i to len [i,len]
        }
        for (int i = len-1; i >= 0; i--){
            for (int j=i; j<len; j++){
                if ((s.charAt(i) == s.charAt(j) && (j-i<2))
                        || (s.charAt(i) == s.charAt(j) && matrix[i+1][j-1])){
                    matrix[i][j] = true;
                    cuts[i] = Math.min(cuts[i], cuts[j + 1]+1);
                }
            }
        }
        return cuts[0]-1;
    }
}
