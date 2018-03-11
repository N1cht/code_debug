package leetcode.dp;

/**
 * Created by Sou1AtLab on 2018/3/11 0011.
 */
public class MaximumProductSubarray {
    public static void main(String[] args) {
        MaximumProductSubarray temp = new MaximumProductSubarray();
        System.out.println(temp.maxProduct2(new int[]{-1, -2, -6, -9}));
    }

    // TLE
    public int maxProduct(int[] nums) {

        int length = nums.length;
        int max = Integer.MIN_VALUE;
        int currentStartIndex = 0;
        for (int i = 0; i < length; i++) {
            if(nums[i] == 0 || i == length - 1){
                if(nums[i] == 0){
                    max = Math.max(maxProductForSubArray(nums, currentStartIndex, i, max), max);
                    max = Math.max(max, 0);
                    currentStartIndex = i + 1;
                }else{
                    max = Math.max(maxProductForSubArray(nums, currentStartIndex, i + 1, max), max);
                }
            }
        }

        return max;
    }

    private int maxProductForSubArray(int[] nums, int startIndex, int endIndex, int currentMax){
        int length = endIndex - startIndex;
        if(length == 0) return 0;
        int max = currentMax;

        int[] product = new int[length + 1];
        product[0] = 1;
        for (int i = 1; i <= length; i++) {
            product[i] = nums[i - 1 + startIndex] * product[i - 1];
        }

        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j <= length; j++) {
                max = Math.max(max, product[j] / product[i]);
            }
        }

        return max;
    }

    //Bug: java cannot swap two value
    public int maxProduct2(int[] nums){

        // store the result that is the max we have found so far
        int r = nums[0];

        // imax/imin stores the max/min product of
        // subarray that ends with the current number A[i]
        for (int i = 1, imax = r, imin = r; i < nums.length; i++) {
            // multiplied by a negative makes big number smaller, small number bigger
            // so we redefine the extremums by swapping them
            if (nums[i] < 0){
                int temp = imax;
                imax = imin;
                imin = imax;
            }

            // max/min product for the current number is either the current number itself
            // or the max/min by the previous number times the current one
            imax = Math.max(nums[i], imax * nums[i]);
            imin = Math.min(nums[i], imin * nums[i]);

            // the newly computed max value is a candidate for our global result
            r = Math.max(r, imax);
        }
        return r;
    }
}
