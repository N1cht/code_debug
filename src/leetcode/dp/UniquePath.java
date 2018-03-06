package leetcode.dp;

public class UniquePath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[][] arr = new int[3][4];
		arr[0] = new int[]{0,0,0,0};
		arr[1] = new int[]{0,1,0,0};
		arr[2] = new int[]{0,0,0,0};
		System.out.println(uniquePathsWithObstacles(arr));
	}
	
	public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
	    int columnSize = obstacleGrid[0].length;
	    int[] c = new int[columnSize];
	    c[0] = 1;
	    for (int[] row : obstacleGrid) {
	        for (int j = 0; j < columnSize; j++) {
	            if (row[j] == 1)	//if there is obstacle
	                c[j] = 0;
	            else if (j >= 1)
	                c[j] += c[j - 1];
	        }
	    }
	    return c[columnSize - 1];
	}
}
