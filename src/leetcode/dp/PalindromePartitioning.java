package leetcode.dp;

import java.util.List;

/**
 * Created by Sou1AtLab on 2018/3/9 0009.
 */
public class PalindromePartitioning {
    public static void main(String[] args) {

    }

    public static List<List<String>> partition(String s) {

        return null;
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
}
