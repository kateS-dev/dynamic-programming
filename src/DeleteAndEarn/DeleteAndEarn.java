package DeleteAndEarn;

import java.util.ArrayList;

public class DeleteAndEarn {
    public static int deleteAndEarn(int[] nums) {
        int maxNum = 0;

        //1. get the maximum number from this array
        for (int num : nums) {
            maxNum = Math.max(maxNum, num);
        }

        //2. create a dp array with size of max and fill the total amount of each number
        int[] dp = new int[maxNum+1];
        for (int num : nums) {
            dp[num] += num;
        }

        //3. use the dp array to get the maximum and follow rob problem
        ArrayList<Integer> totalArray = new ArrayList<>();
        totalArray.add(dp[0]);
        if (dp.length >= 2) {
            totalArray.add(Math.max(dp[0], dp[1]));

            for (int i = 2; i < dp.length; i++) {
                // select this number
                int currentMax = totalArray.get(i-2) + dp[i];

                // not select this number
                int currentIgnore = totalArray.get(i-1);

                totalArray.add(Math.max(currentMax, currentIgnore));
            }
        }
        return totalArray.get(totalArray.size() - 1);
    }


    public static void main(String[] args) {
        int[] input = {3,4,2};
        int res = deleteAndEarn(input);
        
        System.out.println("res: "+res);
    }
}
