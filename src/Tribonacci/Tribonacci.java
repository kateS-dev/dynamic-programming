package Tribonacci;

public class Tribonacci {
    public static int tribonacci(int n) {
        int[] dp = new int[(n > 3 ? n : 3)+1];
        // add base
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;

        // fill the dp array
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i-3] + dp[i-2] + dp[i-1];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int n = 4;
        int n1 = 0;
        int res = tribonacci(n1);
        System.out.println("res: "+ res);
    }
}
