package leetcode.dp;

public class EditDistance {

    public static void main(String[] args){

        System.out.println(minDistance("test", "text"));
    }

    public static int minDistance(String word1, String word2) {

        int length = word1.length();
        int width = word2.length();
        int[][] distence = new int[length+1][width+1];

        for(int i = 1; i <= length; i++){
            distence[i][0] = i;
        }

        for(int j = 1; j <= width; j++){
            distence[0][j] = j;
        }

        for(int i = 1; i <= length; i++){
            for(int j = 1; j <= width; j++){
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    distence[i][j] = distence[i-1][j-1];
                }else{
                    distence[i][j] = Math.min(Math.min(distence[i-1][j-1], distence[i-1][j]), distence[i][j-1]) + 1;
                }
            }
        }
        return distence[length][width];
    }
}
