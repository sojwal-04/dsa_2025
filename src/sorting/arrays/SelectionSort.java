package sorting.arrays;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] nums = {10, 2, 3, -1, 8};

        System.out.println("Before sorting : " + Arrays.toString(nums));

        selectionSort(nums);

        System.out.println("After sorting : " + Arrays.toString(nums));
    }

    private static void selectionSort(int[] nums) {
        // start putting the smallest element at the start

        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            int smallestInd = i;
            for (int j = i + 1; j < n; j++) {
                if (nums[j] < nums[smallestInd]) {
                    smallestInd = j;
                }
            }

            Swap.swap(nums, smallestInd, i);
        }
    }
}
