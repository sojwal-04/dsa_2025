package sheet.arrays;

import java.util.HashMap;
import java.util.Map;

public class PairOfSongsWithTotalDurationDivisibleBy60 {


//    https://leetcode.com/problems/pairs-of-songs-with-total-durations-divisible-by-60/submissions/1639582499/

//    TC : O(N) Sc: Space Complexity: O(1), NOT O(N)

//    The keys in freq are the remainders modulo 60, so they range from 0 to 59.
//
//That means at most 60 unique keys in the map.

    public static void main(String[] args) {
        PairOfSongsWithTotalDurationDivisibleBy60 p = new PairOfSongsWithTotalDurationDivisibleBy60();

        int[] time = {30, 20, 150, 100, 40};

        int cnt = p.numPairsDivisibleBy60(time);

        System.out.println("Number of pairs of songs divisible by 60 are " + cnt);
    }

    private final int duration = 60;

    public int numPairsDivisibleBy60(int[] time) {
        // return brute(time);
        return optimal(time);
    }

    private int optimal(int[] time) {
        // take module of each time duration
        int n = time.length;

        for (int i = 0; i < n; i++) {
            time[i] = time[i] % duration;
        }

        // use hashmap, then check for the counterpart of the 60 - currTime
        // Add the frequecne of the counterpart in the cnt
        Map<Integer, Integer> freq = new HashMap<>();

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            int currDuration = time[i];

            // Important: using (duration - currDuration) % duration ensures that
            // when currDuration is 0, the remainingDuration is also 0
            // (instead of incorrectly becoming 60, which is not a valid mod class)
            int remainingDuration = (duration - currDuration) % duration;

            cnt += freq.getOrDefault(remainingDuration, 0);
            freq.put(currDuration, freq.getOrDefault(currDuration, 0) + 1);
        }

        // return cnt;

        return cnt;
    }

    private int brute(int[] time) {
        int cnt = 0;
        int n = time.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if ((time[i] + time[j]) % duration == 0) cnt++;
            }
        }
        return cnt;
    }
}
