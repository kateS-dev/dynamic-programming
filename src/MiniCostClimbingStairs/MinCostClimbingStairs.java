package MiniCostClimbingStairs;

import java.util.*;

public class MinCostClimbingStairs {
    public static int minCostClimbingStairs(int[] cost) {
        int n = cost.length;

        // dp[i] represents the minimum cost to reach step i
        int[] dp = new int[n];

        // Base cases: cost to reach first two steps
        dp[0] = cost[0];
        dp[1] = cost[1];

        // Fill the dp array
        for (int i = 2; i < n; i++) {
            // To reach step i, we can come from step i-1 or i-2
            // Choose the path with minimum cost
            dp[i] = cost[i] + Math.min(dp[i-1], dp[i-2]);
        }

        // We can reach the top from either the last or second-to-last step
        return Math.min(dp[n-1], dp[n-2]);
    }

    public static void main(String[] args) {
        int[] input = {10,15,20}; // output is 15
        int[] input1 = {1,100,1,1,1,100,1,1,100,1}; // output is 6
        int[] input2 = {0,1,2,2}; // output is 2
        System.out.println("Test 1: " + minCostClimbingStairs(input)); // 15
        System.out.println("Test 2: " + minCostClimbingStairs(input1)); // 6
        System.out.println("Test 3: " + minCostClimbingStairs(input2)); // 2
    }
}
