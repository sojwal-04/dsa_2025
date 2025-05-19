package sheet.arrays;

public class ContainerWithMostWater {

    public static void main(String[] args) {
        int[] heights = {1,8,6,2,5,4,8,3,7};
        int maxArea = maxArea(heights);
        System.out.println("Max area = " + maxArea);
    }


    public static int maxArea(int[] heights) {
//        return bruteForce(heights);
        return efficientWay(heights);
    }

//    TC: O(n) and SC: O(1)
    public static int efficientWay(int[] heights) {
        int n = heights.length;

        // Initialize the maximum area to 0
        int maxArea = 0;

        // Use two pointers, starting from both ends of the array
        int i = 0, j = n - 1;

        // Continue until the pointers meet
        while (i < j) {
            // Width is the distance between the two lines
            int width = j - i;

            // The height of the container is limited by the shorter line
            int height = Math.min(heights[i], heights[j]);

            // Calculate the area for the current pair of lines
            int currentArea = width * height;

            // Update max area if current is greater
            maxArea = Math.max(maxArea, currentArea);

            /**
             * Now we move one of the pointers inward.
             *
             * Since the area is limited by the shorter line,
             * we try to move the pointer at the shorter line inward.
             *
             * Why? Because:
             * - Moving the longer line won’t help — the height can't increase
             *   and width is guaranteed to decrease, which means area will either
             *   decrease or stay the same.
             *
             * - But moving the shorter line might lead to a taller line,
             *   and though width decreases, if the height increases enough,
             *   it could lead to a larger area.
             *
             * This is a greedy choice — always try to seek a taller line
             * in hopes of maximizing the area while the width shrinks.
             */

            if (heights[i] < heights[j]) {
                i++; // Move left pointer forward to possibly find a taller line
            } else {
                j--; // Move right pointer backward
            }
        }

        // Return the maximum area found
        return maxArea;
    }

//    Time Limit Exceeded TC: O(n2), SC: O(1)
    private static int bruteForce(int[] heights){
        int maxA = 0;

        // consider one line at time
        int n = heights.length;

        for(int i = 0; i < n; i++){

            // loop with antoher lines and calucate the area between outer and in this

            for(int j = i + 1; j < n; j++){

                // if max, update max area
                int h = Math.min(heights[i], heights[j]);
                int w = j - i;
                int newArea = w * h;

                maxA = Math.max(maxA, newArea);
            }
        }

        return maxA;
    }
}
