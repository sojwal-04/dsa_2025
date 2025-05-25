package sheet.arrays;

import java.util.*;

public class FourSum {

    public static void main(String[] args) {
        FourSum fs = new FourSum();

        int[] nums = {1,0,-1,0,-2,2};
        int target = 0;

        List<List<Integer>> res = fs.fourSum(nums, target);


        System.out.println("Unique quadruplets : ");

        for(List<Integer> quad: res){
            System.out.println(quad);
        }
    }


    public List<List<Integer>> fourSum(int[] nums, int target) {
        // return brute(nums, target);
        // return brute2(nums, target);
        return optimal(nums, target);
    }

    // TC: O(n³), SC: O(k)

    private List<List<Integer>> optimal(int[] A, int target){
        List<List<Integer>> res = new ArrayList<>();

        // Sort the array

        Arrays.sort(A);

        int n = A.length;
        for(int i = 0; i < n - 2; i++){
            // Skip duplicates
            if(i > 0 && A[i] == A[i - 1]) continue;


            for(int j = i + 1; j < n - 1; j++){

                // Skip duplicates
                if(j > i + 1 && A[j] == A[j - 1]) continue;

                // use while loop
                int left = j + 1, right = n - 1;

                // do loop until left < right

                while(left < right){
                    // calc sum
                    long sum = (long) A[i] + (long)  A[j] + (long)  A[left] + (long)  A[right];

                    // check for sum

                    // if sum is same then add
                    if(sum == target){

                        // Add into the res

                        res.add(Arrays.asList(A[i], A[j], A[left], A[right]));
                        left++;
                        right--;

                        // skip duplicates for left
                        while(left < right && A[left] == A[left - 1]) left++;
                        // skip duplicates for right
                        while(left < right && A[right] == A[right + 1]) right--;

                        continue;
                    }




                    // if sum < target , then left++ else right--
                    if(sum < target) left++;
                    else right--;
                }
            }
        }

        return res;
    }

    // TC: O(n³), SC: O(n + k) - > (O(n) for the hash set used in each iteration + O(k) for the output list)
    private List<List<Integer>> brute2(int[] A, int target){
        Set<List<Integer>> res = new HashSet<>();

        int n = A.length;
        for(int i = 0; i < n - 2; i++){
            for(int j = i + 1; j < n - 1; j++){

                Set<Integer> hash = new HashSet<>();

                for(int k = j + 1; k < n; k++){

                    int a = A[i], b = A[j], c = A[k];
                    long compLong = (long) target - (long) a - (long) b - (long) c;

                    if (compLong < Integer.MIN_VALUE || compLong > Integer.MAX_VALUE) continue;
                    int comp = (int) compLong;

                    if(hash.contains(comp)){
                        int d = comp;
                        long sum = a + b + c + d;
                        List<Integer> quad = Arrays.asList(a, b, c, d);
                        Collections.sort(quad);
                        res.add(quad);
                    }

                    hash.add(A[k]);
                }
            }
        }

        return new ArrayList<>(res);
    }

    // Brute Force Solution

    // TC: O(n⁴), SC: O(k) (where k is the number of unique quadruplets in the result)

    private List<List<Integer>> brute(int[] A, int target){
        Set<List<Integer>> res = new HashSet<>();

        int n = A.length;
        for(int i = 0; i < n - 3; i++){
            for(int j = i + 1; j < n - 2; j++){
                for(int k = j + 1; k < n - 1; k++){
                    for(int l = k + 1; l < n; l++){
                        int a = A[i], b = A[j], c = A[k], d = A[l];
                        long sum = a + b + c + d;
                        if(sum == target){
                            List<Integer> quad = Arrays.asList(a, b, c, d);
                            Collections.sort(quad);
                            res.add(quad);
                        }
                    }
                }
            }
        }

        return new ArrayList<>(res);
    }
}
