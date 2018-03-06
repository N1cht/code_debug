package leetcode.dp;

import java.util.Stack;

public class LongestValidParentheses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(longestValidParentheses("()(()"));
	}

	public static int longestValidParentheses(String s) {
		int size = s.length();
        if(size == 0) return 0;
        int currentAddSum = 0;
        int currentStartIndex = -1;
        int maxLength = 0;
        
        for(int i = 0; i < size; i++){
        	if(s.charAt(i) == '('){
        		currentAddSum += 1;
        	}else if(s.charAt(i) == ')'){
        		currentAddSum -= 1;
        	}
        	
        	if(currentAddSum < 0){
        		currentStartIndex = i;
        		currentAddSum = 0;
        	}else if(currentAddSum == 0){
        		maxLength = Math.max(i - currentStartIndex, maxLength);
        	}
        }
        
        currentAddSum = 0;
        currentStartIndex = size - 1;
        
        for(int i = size - 1; i >= 0; i--){
        	if(s.charAt(i) == '('){
        		currentAddSum += 1;
        	}else if(s.charAt(i) == ')'){
        		currentAddSum -= 1;
        	}
        	
        	if(currentAddSum > 0){
        		currentStartIndex = i;
        		currentAddSum = 0;
        	}else if(currentAddSum == 0){
        		maxLength = Math.max(currentStartIndex - i, maxLength);
        	}
        }
        
        return maxLength;
    }

}
