package sheet.arrays;

import java.util.*;


//medium level - 17 / 05 / 2025

// https://leetcode.com/problems/3sum/
public class ThreeSumProblem {

    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};

        List<List<Integer>> res = threeSum(nums);

        for(List<Integer> uniqueTriplet: res){
            System.out.println(uniqueTriplet);
        }
    }


//    Optimal Tc o(n2) and sc o(1)
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> triplets = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;

        for(int i = 0; i < n; i++){
            if(i > 0 && nums[i] == nums[i - 1]) continue;


            int j = i + 1, k = n - 1;
            while(j < k){

                // check sum
                int sum = nums[i] + nums[j] + nums[k];

                if(sum == 0){
                    triplets.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++; k--;


                    // skip duplicates
                    while(j < k && nums[j] == nums[j - 1]) j++;
                    while(j < k && nums[k] == nums[k + 1]) k--;

                    continue;
                }

                if(sum > 0){
                    k--;
                }else{
                    j++;
                }

            }
        }
        return triplets;
    }


//    Time complexity: O(n2) and Space: O(n)

    /*
    public static List<List<Integer>> threeSum(int[] nums) {

        int n = nums.length;

        Set<List<Integer>> set = new HashSet<>();
        for(int i = 0; i < n; i++){
            int first = nums[i];
            Set<Integer> seen = new HashSet<>();

            for(int j = i + 1; j < n; j++){
                if(seen.contains(-first - nums[j])){
                    List<Integer> triplet = new ArrayList<>(List.of(first, nums[j], -first - nums[j]));
                    Collections.sort(triplet);
                    set.add(triplet);
                }
                seen.add(nums[j]);
            }

        }

        return new ArrayList<>(set);
    }
    */

    // Time limit exceeded
    /*
    public static List<List<Integer>> threeSum(int[] nums) {
        // Create a set
        Set<Triplet> set = new HashSet<>();


        // Try all the triplets
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        int[] triplet = {nums[i], nums[j], nums[k]};
                        Arrays.sort(triplet);
                        set.add(new Triplet(triplet[0], triplet[1], triplet[2]));
                    }
                }
            }
        }


        // return in the list format

        List<List<Integer>> res = new ArrayList<>();
        for (Triplet triplet : set) {
            res.add(List.of(triplet.i, triplet.j, triplet.k));
        }
        return res;
    }

    */


}


class Triplet {
    int i, j, k;

    Triplet(int i, int j, int k) {
        this.i = i;
        this.j = j;
        this.k = k;
    }

    @Override
    public int hashCode() {
        return Objects.hash(i, j, k);
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Triplet)) return false;

        Triplet t = (Triplet) o;

        return this.i == t.i && this.j == t.j && this.k == t.k;

    }
}
