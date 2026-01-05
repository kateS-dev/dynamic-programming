package ClimbingStairs;

// Each time you can either climb 1 or 2 steps.

public class ClimbStairs {
    public static int climbStairs(int n) {
        int res = 0;
        if (n == 0 || n == 1 || n == 2 || n == 3) {
            return n;
        }

        int left = 2;
        int right = 3;

        for (int i = 4; i <= n ; i++) {
            res = left + right;
            left = right;
            right = res;
        }

        return res;
    }

    public static void main(String[] args) {
        int n = 5;
        int res = climbStairs(n);
        System.out.println(res);
    }
}
