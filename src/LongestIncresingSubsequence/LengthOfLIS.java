package LongestIncresingSubsequence;

import java.util.Arrays;

public class LengthOfLIS {
    public static int lengthOfLIS(int[] nums) {
        if (nums.length == 0) return 0;

        int[] dp = new int[nums.length];
        int ans = 0;

        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1; // base: LIS ending at i at least includes nums[i]
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    // dp[j] is the length of numbers below nums[j]
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
//        int[] input = {0,1,0,3,2,3};
        int[] input = {10,9,2,5,3,7,101,18};

        int res = lengthOfLIS(input);
        System.out.println("The longest incresing subsequence: "+ res);
    }
}
