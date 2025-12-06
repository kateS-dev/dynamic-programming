package HouseRobber;

import java.util.ArrayList;

public class Rob {
    public static int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);

        ArrayList<Integer> totalArray = new ArrayList<>();
        totalArray.add(nums[0]);
        totalArray.add(Math.max(nums[0], nums[1]));

        for (int i = 2; i < nums.length; i++) {
            //rob the current house
            int currentMax = totalArray.get(i-2) + nums[i];

            // not rob the current house
            int currenIgnore = totalArray.get(i-1);
            totalArray.add(Math.max(currentMax, currenIgnore));
        }

        return totalArray.get(totalArray.size() - 1);
    }

    public static void main(String[] args) {
        int[] stashes = {1,2,3,1};
        int res = rob(stashes);
        System.out.println("the maximum amount is: "+ res);
    }
}
