package sheet.arrays;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {

    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 3, -2, 4};
        int cnt = subarraySum(nums, 2);
        System.out.println(cnt);
    }


    public static int subarraySum(int[] nums, int k) {

        // Declare cnt
        int cnt = 0;
        int n = nums.length;
        int prefixSum = 0;

        Map<Integer, Integer> hashMap = new HashMap<>();

        // initial condition
        hashMap.put(0, 1);

        for(int i = 0; i < n; i++){
            prefixSum += nums[i];

            int comp = prefixSum - k;
            // check if sum - curr is present, if present then add its frequcney in cnt
            cnt += hashMap.getOrDefault(comp, 0);
            // put the element into the map, if present increase its frequcney by 1
            hashMap.put(prefixSum, hashMap.getOrDefault(prefixSum, 0) + 1);
        }

        return cnt;
    }
}
