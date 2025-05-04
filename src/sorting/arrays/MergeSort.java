package sorting.arrays;

import java.util.Arrays;
import java.util.Random;

 a

//tc : N log(N), sc: O(N)
public class MergeSort {

    public static void main(String[] args) {
        Random random = new Random();
        int size = random.nextInt(50) + 1;

        int[] nums = new int[size];

        for(int i = 0; i < size; i++){
            nums[i] = random.nextInt(100) + 1;
        }


        System.out.println("Before sorting : " + Arrays.toString(nums));

        recursiveMergeSort(nums, 0, size - 1);

        System.out.println("After sorting : " + Arrays.toString(nums));

    }

    private static void recursiveMergeSort(int[] nums, int s, int e){

        if(s >= e) return;

        int mid = s + (e - s) / 2;

        // keep dividing
        recursiveMergeSort(nums, s, mid);
        recursiveMergeSort(nums, mid + 1, e);

        recursiveMerge(nums, s, mid, mid + 1, e);
    }

    private static void recursiveMerge(int[] nums, int s1, int e1, int s2, int e2){
        int[] temp = new int[e2 - s1 + 1];

        int i = s1, j = s2, k = 0;

        while(i <= e1 && j <= e2){
            if(nums[i] < nums[j]){
                temp[k++] = nums[i++];
            }else{
                temp[k++] = nums[j++];
            }
        }

        while(i <= e1) temp[k++] = nums[i++];
        while(j <= e2) temp[k++] = nums[j++];

        k = 0;
        while(s1 <= e2){
            nums[s1++] = temp[k++];
        }
    }
}
