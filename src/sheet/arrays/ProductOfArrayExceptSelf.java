package sheet.arrays;

import java.util.Arrays;
import java.util.Random;

public class ProductOfArrayExceptSelf {

    public static void main(String[] args) {

        Random rand = new Random();

        for (int t = 1; t <= 5; t++) {
            // Generate random size between 2 and 20
            int size = rand.nextInt(19) + 2;

            int[] nums = new int[size];
            for (int i = 0; i < size; i++) {
                // Random integers from -15 to 15
                nums[i] = rand.nextInt(31) - 15;
            }

            System.out.println("Test " + t + " Input:  " + Arrays.toString(nums));
            int[] res = productExceptSelf(nums);
            System.out.println("Test " + t + " Output: " + Arrays.toString(res));
            System.out.println("-----------------------------------------");
        }
    }

    public static int[] productExceptSelf(int[] nums) {
        int leftProduct = 1;
        int rightProduct = 1;

        int n = nums.length;

        int[] res = new int[n];
        res[0] = 1;

        for(int i = 1; i < n; i++){
            res[i] = res[i - 1] * nums[i - 1];
        }

        int rightProd = 1;
        for(int i = n - 1; i >= 0; i--){
            res[i] *= rightProd;
            rightProd *= nums[i];
        }
        return res;
    }
}
