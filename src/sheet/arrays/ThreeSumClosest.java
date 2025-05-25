package sheet.arrays;

import java.util.Arrays;

public class ThreeSumClosest {

//    https://leetcode.com/problems/3sum-closest/submissions/1639533480/
    public static void main(String[] args) {
        int[] nums = {-1,2,1,-4};
        int target = 1;

        ThreeSumClosest tsc = new ThreeSumClosest();

        int closest = tsc.threeSumClosest(nums, target);

        System.out.println("Closest sum is this");
        System.out.println(closest);
    }



    public int threeSumClosest(int[] nums, int target) {
        // Brute force

        // return brute(nums, target);
        return optimal(nums, target);
    }

    private int optimal(int[] nums, int target){

        // Sort the array
        Arrays.sort(nums);

        // use outer lopp
        int n = nums.length;
        int closest = 0;
        int minDiff = Integer.MAX_VALUE;
        for(int i = 0; i < n - 2; i++){


            // inside inner loop, use two pointer
            int j = i + 1, k = n - 1;
            while(j < k){

                int sum = nums[i] + nums[j] + nums[k];

                int diff = Math.abs(sum - target);
                // if sum == target, return the sum itself
                if(sum == target) return sum;


                // while looping using pointer, store the closest one
                if(diff < minDiff) {
                    minDiff = diff;
                    closest = sum;
                }

                if(sum < target){
                    j++;
                }else{
                    k--;
                }
            }
        }
        return closest;
    }

    private int brute(int[] nums, int target){
        int closest = Integer.MAX_VALUE;
        int minDiff = Integer.MAX_VALUE;
        int n = nums.length;
        for(int i = 0; i < n - 2; i++){
            for(int j = i + 1; j < n - 1; j++){
                for(int k = j + 1; k < n; k++){
                    int sum = nums[i] + nums[j] + nums[k];

                    if(sum == target) return sum;

                    if(Math.abs(target - sum) < minDiff){
                        closest = sum;
                        minDiff = Math.abs(target - sum);
                    }
                }
            }
        }
        return closest;
    }
}
