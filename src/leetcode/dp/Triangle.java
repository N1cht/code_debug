package leetcode.dp;

import java.util.ArrayList;
import java.util.List;

public class Triangle {
    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();

        List<Integer> list1 = new ArrayList<Integer>();
        list1.add(-1);

        List<Integer> list2 = new ArrayList<Integer>();
        list2.add(3);
        list2.add(2);

        List<Integer> list3 = new ArrayList<Integer>();
        list3.add(-3);
        list3.add(1);
        list3.add(-1);

        List<Integer> list4 = new ArrayList<Integer>();
        list4.add(4);
        list4.add(1);
        list4.add(8);
        list4.add(3);

        list.add(list1);
        list.add(list2);
        list.add(list3);
//        list.add(list4);

        System.out.println(minimumTotal(list));
    }

    public static int minimumTotal(List<List<Integer>> triangle) {

        int rowNums = triangle.size();
        if (rowNums == 0) {
            return 0;
        }
        if(rowNums == 1){
            return triangle.get(0).get(0);
        }
        int[][] dp = new int[rowNums][rowNums];
        int minPath = Integer.MAX_VALUE;

        dp[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < rowNums; i++) {
            dp[i][0] += triangle.get(i).get(0) + dp[i-1][0];
            dp[i][i] += triangle.get(i).get(i) + dp[i-1][i-1];
        }

        for (int i = 1; i < rowNums; i++) {
            for (int j = 1; j < i; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - 1]) + triangle.get(i).get(j);
            }
        }

        for (int k = 0; k < rowNums; k++) {
            minPath = Math.min(dp[rowNums-1][k], minPath);
        }
        return minPath;
    }
}
