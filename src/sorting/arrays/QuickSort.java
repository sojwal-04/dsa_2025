package sorting.arrays;

import java.util.Arrays;
import java.util.Random;

public class QuickSort {

    public static void main(String[] args) {
        Random random = new Random();
        int size = random.nextInt(50) + 1;

        int[] nums = new int[size];

        for(int i = 0; i < size; i++){
            nums[i] = random.nextInt(100) + 1;
        }



        System.out.println("Before sorting : " + Arrays.toString(nums));

        recursiveQuickSort(nums, 0, size - 1);

        System.out.println("After sorting : " + Arrays.toString(nums));
    }



    private static void recursiveQuickSort(int[] nums, int s, int e){

        if(s >= e) return;


        int partitionIndex = partition(nums, s, e);

        recursiveQuickSort(nums, s, partitionIndex - 1);
        recursiveQuickSort(nums, partitionIndex + 1, e);
    }


    private static int partition(int[] nums, int low, int high){


        int pivotElement = nums[high];


//        Pivot index is index for which the element to the right side are greater or equal to element at pivot index
//        and element to the left are smaller or equal to pivot element

//        Assuming it to be the pivot element


        int pivotIndex = low;

        for(int i = low; i < high; i++){
            if(nums[i] < pivotElement){
                Swap.swap(nums, i, pivotIndex);
                pivotIndex += 1;
            }
        }

        Swap.swap(nums, pivotIndex, high);

        return pivotIndex;
    }
}
