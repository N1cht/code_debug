package leetcode.dp;

public class JumpGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = new int[]{2,3,1,1,4};
		System.out.println(canJump(arr));
	}

	public static boolean canJump(int[] nums) {
        int n = nums.length;
        if(n == 1) return true;
        int max = 0;
        int[] longestIndex = new int[n];
        for(int i = 0; i <= max ; i++){
            max = Math.max(max, i + nums[i]);
            if(max >= n-1) return true;
        }
        return false;
    }
}
