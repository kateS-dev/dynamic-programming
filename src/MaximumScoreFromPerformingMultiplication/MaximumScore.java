package MaximumScoreFromPerformingMultiplication;

public class MaximumScore {
// method 2 for dp
//    public static int dfs(int left, int right, int[] nums, int[] multipliers, int index, HashMap<String, Integer> memo) {
//        if (index == multipliers.length) return 0;
//
//        String key = left + "," + index;
//        if (memo.containsKey(key)) return memo.get(key);
//
//        int pickLeft = nums[left] * multipliers[index] + dfs(left+1, right, nums, multipliers, index+1, memo);
//        int pickRight = nums[right] * multipliers[index] + dfs(left, right-1, nums, multipliers,index+1, memo);
//
//        int res = Math.max(pickLeft, pickRight);
//        memo.put(key, res);
//        return res;
//    }

// method 3 for dp
    private static int dfs(int left, int[] nums, int[] multipliers, int index, Integer[][] memo) {
        if (index == multipliers.length) return 0;
        if (memo[index][left] != null) return memo[index][left];

        int right = nums.length - 1 - (index - left);

        int pickLeft = nums[left] * multipliers[index] + dfs(left+1, nums, multipliers, index+1, memo);
        int pickRight = nums[right] * multipliers[index] + dfs(left, nums, multipliers, index+1, memo);

        memo[index][left] = Math.max(pickLeft, pickRight);
        return memo[index][left];
    }

    public static int maximumScore(int[] nums, int[] multipliers) {
// method 3
        int m = multipliers.length;
        Integer[][] memo = new Integer[m][m];
        return dfs(0, nums, multipliers, 0, memo);
// method 2
// use HashMap to store the result of subproblems
//        HashMap<String, Integer> memo = new HashMap<>();
//
//        int res = dfs(0, nums.length - 1, nums, multipliers, 0, memo);
//        return res;

// method 1
// from ai
//        int n = nums.length;
//        int m = multipliers.length;
//        int[] dp = new int[m + 1];
//        for (int i = m - 1; i >= 0; i--) {
//            int[] newDp = new int[m + 1];
//
//            for (int left = i; left >= 0; left--) {
//                // Calculate right index
//                int right = n - 1 - (i - left);
//
//                // Score if we pick from left + best future score
//                int pickLeft = nums[left] * multipliers[i] + dp[left + 1];
//
//                // Score if we pick from right + best future score
//                int pickRight = nums[right] * multipliers[i] + dp[left];
//
//                // Take maximum
//                newDp[left] = Math.max(pickLeft, pickRight);
//            }
//            dp = newDp;
//        }
//
//        return dp[0];
    }

    public static void main(String[] args) {
        // Test cases
        test(new int[]{-5, -3, -3, -2, 7, 1}, new int[]{-10, -5, 3, 4, 6}, 102);
        test(new int[]{1, 2, 3}, new int[]{3, 2, 1}, 14);
    }

    private static void test(int[] nums, int[] multipliers, int expected) {
        int result = maximumScore(nums, multipliers);
        System.out.println("Result: " + result + " | Expected: " + expected +
                " | " + (result == expected ? "✓ PASS" : "✗ FAIL"));
    }
}