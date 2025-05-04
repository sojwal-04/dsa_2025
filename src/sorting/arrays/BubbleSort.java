package sorting.arrays;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {

        int[] nums = {10, 2, 3, -1, 8};


        System.out.println("Before sorting : " + Arrays.toString(nums));

        bubbleSort(nums);

        System.out.println("After sorting : " + Arrays.toString(nums));
    }


    private static void bubbleSort(int[] nums) {

        // The idea is to move the largest element to the as right as possible
        int n = nums.length;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n - i - 1; j++){
                if(nums[j] > nums[j + 1]) {
                    Swap.swap(nums, j, j + 1);
                }
            }
        }
    }
}
