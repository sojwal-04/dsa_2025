package sorting.arrays;

import java.util.Arrays;

public class InsertionSort {

    public static void main(String[] args) {
        int[] nums = {10, 2, 3, -1, 8};

        System.out.println("Before sorting : " + Arrays.toString(nums));

        insertionSort(nums);

        System.out.println("After sorting : " + Arrays.toString(nums));
    }


    private static void insertionSort(int[] nums){
        int n = nums.length;

        for(int i = 1; i < n; i++){
            int currentElement = nums[i];

            int j = i - 1;

            while(j >= 0 && nums[j] > currentElement){
                nums[j + 1] = nums[j];
                j--;
            }

            nums[j + 1] = currentElement;
        }
    }
}
