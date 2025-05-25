package sheet.arrays;

import java.util.HashMap;
import java.util.Map;

public class MaxPointsYouCanObtainFromCards {


    public static void main(String[] args) {
        MaxPointsYouCanObtainFromCards mx =
                new MaxPointsYouCanObtainFromCards();


        int[] cardPoints = {1, 2, 3, 4, 5, 6, 1};
        int k = 3;
        int score = mx.optimal(cardPoints, k);

        System.out.println("Maximum score = " + score);
    }

    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;

//        return max(cardPoints, 0, n - 1, k, new HashMap<>());

        return optimal(cardPoints, k);
    }

    //    TC : O(n) and SC : O(1)
    private int optimal(int[] cards, int k) {
        int n = cards.length;
        // both end length is k
        //  so the required end length
        k = n - k;
        int sum = 0;
        for (int it : cards) sum += it;

        if (k == 0) return sum;
        int currScore = 0;
        int min = sum;

        for (int i = 0; i < n; i++) {
            currScore += cards[i];

            if (i >= k - 1) {
                min = Math.min(min, currScore);
                currScore -= cards[i - k + 1];
            }
        }
        return sum - min;
    }


//    O(k²) in worst case:
//    Each recursive call reduces k by 1.
//    Maximum unique states: O(k) values of k × O(k) values of i ⇒ O(k²)
//    Even though i and j change, only i and k are used as keys.

//    O(k²) for the memoization map.
//    O(k) recursive call stack (since each call reduces k by 1).

    private int max(int[] cards, int i, int j, int k, Map<String, Integer> memo) {
        if (k == 0) return 0;


        String key = i + "_" + k;

        if (memo.containsKey(key)) return memo.get(key);

        int maxPoints = 0;


        // take left
        int newPoints = cards[i] + max(cards, i + 1, j, k - 1, memo);
        maxPoints = Math.max(maxPoints, newPoints);

        // take right
        newPoints = cards[j] + max(cards, i, j - 1, k - 1, memo);
        maxPoints = Math.max(maxPoints, newPoints);

        memo.put(key, maxPoints);
        return maxPoints;
    }

}
