package sheet.arrays;

import java.util.ArrayList;
import java.util.List;

public class FindDuplicatesInArray {

    //442. Find All Duplicates in an Array

    /*
    Given an integer array nums of length n where all the integers of nums are in the range [1, n]
        and each integer appears at most twice, return an array of all the integers that appears twice.

    You must write an algorithm that runs in O(n) time and uses only constant auxiliary space,
        excluding the space needed to store the output
     */

    public static void main(String[] args) {

        FindDuplicatesInArray fdia = new FindDuplicatesInArray();

        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};

        List<Integer> res = fdia.findDuplicates(nums);

        System.out.println(res);
    }

    //    TC: O(n) and SC: O(1)
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();

        for (int it : nums) {
            int index = Math.abs(it) - 1;

            if (nums[index] < 0) {
                res.add(Math.abs(it));
            } else {
                nums[index] *= -1;
            }
        }
        return res;
    }
}
