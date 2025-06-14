package sheet.arrays;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumsDivisibleByK {

    public static void main(String[] args) {

        int[] nums = {4,5,0,-2,-3,1};


        SubarraySumsDivisibleByK subarraySumsDivisibleByK = new SubarraySumsDivisibleByK();

        int cnt = subarraySumsDivisibleByK.subarraysDivByK(nums, 4141);
        int k = 4141;

        System.out.println("Count of subarrays divisible by K = " + k + " = " + cnt);
    }


    public int subarraysDivByK(int[] nums, int k) {

        return optimal(nums, k);
    }

    private int brute(int[] nums, int k) {

        int count = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            long sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums[j];
                if (sum % k == 0) count++;
            }
        }

        return count;
    }

    private int optimal(int[] nums, int k) {
        Map<Integer, Integer> modCount = new HashMap<>();
        int prefixMod = 0;
        modCount.put(0, 1);

        int count = 0;

        for (int value : nums) {
            int remainder = value % k;
            if (remainder < 0) remainder += k;
            prefixMod = (prefixMod + remainder) % k;

            count += modCount.getOrDefault(prefixMod, 0);

            modCount.put(prefixMod, modCount.getOrDefault(prefixMod, 0) + 1);
        }

        return count;
    }
}
