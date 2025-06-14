package sheet.arrays;

import java.util.HashSet;
import java.util.Set;

public class FirstMissingPositive {

    public static void main(String[] args) {
        int[] nums = {3, 4, -1, 1};

        FirstMissingPositive solution = new FirstMissingPositive();

        int firstMissingPositive = solution.firstMissingPositive(nums);

        System.out.println("First missing positive value is " + firstMissingPositive);
    }

    public int firstMissingPositive(int[] nums) {
        return optimized(nums);
    }


    //    TC : O(3n) ~ o(n) and SC: O(1) but the input is being modified
    private int optimized(int[] nums) {
        // Values below 1 and above n are not necessary
        int n = nums.length;
        boolean isOnePresent = false;
        // Remove those
        for (int i = 0; i < n; i++) {
            int val = nums[i];
            if (val == 1) isOnePresent = true;

            if (val <= 0 || val > n) {
                nums[i] = 1;
            }
        }

        if (!isOnePresent) return 1;

        // mark negative

        for (int i = 0; i < n; i++) {
            int hashIndex = Math.abs(nums[i]);
            if (hashIndex == n) {
                // since there will no element with valuue zero after our transformation,
                // To store the info about if n is present, or not, we will use 0 th index,
                // if n was present, mark the 0th index as negative, and after we are doen checking all eleentnts
                // We will check thi 0 th ind valu, if ts negative, then it was presetn, we cant return tath too,
                // but it was not present, the value at the 0 th index will remain positive, and if its greater than 0,
                // it means no n was there, return it
                nums[0] = -Math.abs(nums[0]);
            } else {
                nums[hashIndex] = -Math.abs(nums[hashIndex]);
            }
        }

        // Start checking from 1, bcz we are fiding missing values from 1 ofc, for postivies

        for (int i = 1; i < n; i++) {
            // if this value at this index was not marked negative, there was no other element with this value, whihc could have acted as index
            //  and marked the elemtn at this index as negative
            if (nums[i] > 0) return i;
        }

        if (nums[0] > 0) return n;

        return n + 1;
    }

    //    TC : O(n) and SC : o(n)
    private int brute(int[] nums) {
        // find max, then run a loop till taht, store all elements in the nums

        Set<Integer> set = new HashSet<>();
        int max = nums[0];
        for (int it : nums) {
            set.add(it);
            max = Math.max(max, it);
        }

        if (max < 0) return 1;

        for (int probableMissing = 1; probableMissing <= max; probableMissing++) {
            if (!set.contains(probableMissing)) return probableMissing;
        }
        return max + 1;
    }
}
