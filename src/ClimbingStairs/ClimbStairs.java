package ClimbingStairs;

// Each time you can either climb 1 or 2 steps.

public class ClimbStairs {
    public static int climbStairs(int n) {
        int res = 0;
        if (n == 0 || n == 1 || n == 2 || n == 3) {
            return n;
        }

        if (n > 3) {
            res = climbStairs(n-1) + climbStairs(n-2);
        }
        return res;
    }

    public static void main(String[] args) {
        int n = 5;
        int res = climbStairs(n);
        System.out.println(res);
    }
}
