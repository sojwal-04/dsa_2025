package sheet.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.HashSet;

public class GeneratePermuations {


    public static void main(String[] args) {


        int[] nums = {1,2,3,4};
        List<List<Integer>>  res = permute(nums);



        for(List<Integer> permutation: res){
            System.out.println(permutation);
        }
        System.out.println("Total Permutations : " + res.size());
    }


    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        permute(nums, 0, res);

        return res;
    }


    private static void permute(int[] nums, int i, List<List<Integer>> res){
        // Check the base case
        // way1(nums, new ArrayList<>(), new HashSet<>(), res);

        List<Integer> temp = new ArrayList<>();
        for(int it: nums) temp.add(it);

        way2(nums, i, temp, res);
    }

//    tc : O(n!),

    private static void way2(int[] nums, int i, List<Integer> temp, List<List<Integer>> res){
        // Base case

        if(i >= nums.length){
            res.add(new ArrayList<>(temp));
            return;
        }


        // start a loop from j = i to j < n
        for(int j = i; j < nums.length; j++){

            // swap i th element with the j th element
            Collections.swap(temp, i, j);

            // call the function for the next index i + 1
            way2(nums, i + 1, temp, res);

            // swap back
            Collections.swap(temp, i, j);
        }
    }

//    tc : O(n!) and Sc : O(n)

    private void way1(int[] nums, List<Integer> temp,
                      Set<Integer> usedIndices,
                      List<List<Integer>> res){
        // Base case

        if(temp.size() == nums.length){
            res.add(new ArrayList<>(temp));
            return;
        }


        // Run a loop from 0 to n

        for(int ind = 0; ind < nums.length; ind++){

            // If the element at the current index is used, then skip
            if(usedIndices.contains(ind)) continue;

            // Adding the element in the temp list
            usedIndices.add(ind);
            temp.add(nums[ind]);

            // Call the function
            way1(nums, temp, usedIndices, res);

            // remove from the temp list
            usedIndices.remove(ind);
            temp.remove(temp.size() - 1);
        }
    }
}
