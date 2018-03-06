package leetcode.dp;

public class MinimumPathSum {

	public static void main(String[] args){
		int[][] arr = new int[3][2];
		arr[0] = new int[]{1,2};
		arr[1] = new int[]{5,6};
		arr[2] = new int[]{1,1};
		System.out.println(minPathSum(arr));
	}
	
	public static int minPathSum(int[][] grid) {
        int length = grid.length;
        int width = grid[0].length;
        int[][] map = new int[length][width];
        map[0][0] = grid[0][0];
        for(int i = 1; i < length; i++){
            map[i][0] = map[i-1][0]+grid[i][0];
        }
        for(int j = 1; j < length; j++){
            map[0][j] = map[0][j-1]+grid[0][j];
        }
        for(int i = 1; i < length; i++){
            for(int j = 1; j < width; j++){
                map[i][j] = Math.min(map[i-1][j], map[i][j-1]) + grid[i][j];
            }
        }
        
        return map[length-1][width-1];
	}
}
