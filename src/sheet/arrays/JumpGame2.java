package sheet.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class JumpGame2 {

    public static void main(String[] args) {
        JumpGame2 jg = new JumpGame2();

        int[] nums = {2, 3, 1, 1, 4};
        int jumps = jg.dynamic(nums);

        System.out.println(jumps);
    }


    public int jump(int[] nums) {
//         return (int) recursive(nums, 0, new HashMap<>());
        return dynamic(nums);
    }


    // Bottom-Up DP:
    // Time Complexity: O(n²) worst case
    // Space Complexity: O(n) (dp array)

    private int dynamic(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        // i + nums[i] >= j
        for (int j = 1; j < n; j++) {
            for (int i = 0; i < j; i++) {
                if (i + nums[i] >= j && dp[i] != Integer.MAX_VALUE) {
                    dp[j] = Math.min(dp[j], 1 + dp[i]);
                }
            }
        }
        return dp[n - 1];
    }


    // Brute or recursive solution

    // Recursive + Memo:
    // Time Complexity: O(n²) worst case
    // Space Complexity: O(n) (memo + recursion stack)


    private long recursive(int[] nums, int i, Map<Integer, Long> memo) {


        // Base case
        if (i >= nums.length - 1) return 0;

        if (memo.containsKey(i)) return memo.get(i);

        // Start loop from curr position

        // Get curr Element


        int curr = nums[i];

        // if curr element is greater than eqaul to last index return 1;

        if (curr >= nums.length - 1) return 1;

        // run loop from curr index to index position less than it


        long mins = Integer.MAX_VALUE;

        for (int j = 1; j <= curr && i + j < nums.length; j++) {
            long currMin = 1 + recursive(nums, i + j, memo);
            mins = Math.min(mins, currMin);
        }

        memo.put(i, mins);
        return mins;
    }
}

