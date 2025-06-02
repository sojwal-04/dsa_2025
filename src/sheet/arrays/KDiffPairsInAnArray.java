package sheet.arrays;

import java.util.*;

public class KDiffPairsInAnArray {

    /*

        532. K-diff Pairs in an Array
        Solved
        Medium
        Topics
        premium lock icon
        Companies
        Given an array of integers nums and an integer k, return the number of unique k-diff pairs in the array.

        A k-diff pair is an integer pair (nums[i], nums[j]), where the following are true:

        0 <= i, j < nums.length
        i != j
        |nums[i] - nums[j]| == k
        Notice that |val| denotes the absolute value of val.
     */
    public static void main(String[] args) {
        KDiffPairsInAnArray kDiffPairsInAnArray = new KDiffPairsInAnArray();

        int[] nums = {1, 2, 3, 4, 5};
        int k = 1;
        int differentUniquePairs = kDiffPairsInAnArray.findPairs(nums, k);


        System.out.println("Different unique pairs with absolute difference " + k + " = " + differentUniquePairs);
    }

    public int findPairs(int[] nums, int k) {
        // return brute(nums, k);
        return optimized(nums, k);
    }

    private int optimized(int[] nums, int k) {
        // Check if absolute diff is less than zero
        // Bcz abs diff cannot be less than zero
        if (k < 0) return 0;

        // store frequency of elemnts in the map
        Map<Integer, Integer> freq = new HashMap<>();
        for (int it : nums) {
            freq.put(it, freq.getOrDefault(it, 0) + 1);
        }

        // then chekcy for each key if key + k exists, if yes, hten increase count only by one
        // bcz, we want unique pairs

        int cnt = 0;
        for (int key : freq.keySet()) {
            // if abs diff is zero, the curr element must be presetnt more thatn 1 time to negate itself
            if (k == 0) {
                if (freq.get(key) >= 2) {
                    cnt++;
                }
            } else {
                // | a - b | = k, so a = b + k
                if (freq.containsKey(key + k)) {
                    cnt++;
                }
            }
        }

        // return coutn
        return cnt;
    }

    private int brute(int[] nums, int k) {
        Set<List<Integer>> pairs = new HashSet<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int x = nums[i], y = nums[j];
                long diff = Math.abs(x - y);

                if (diff == k) {
                    pairs.add(List.of(Math.min(x, y), Math.max(x, y)));
                }
            }
        }
        return pairs.size();
    }
}
