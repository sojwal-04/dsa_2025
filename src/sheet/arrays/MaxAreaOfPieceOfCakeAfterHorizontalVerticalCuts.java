package sheet.arrays;

import java.util.Arrays;

public class MaxAreaOfPieceOfCakeAfterHorizontalVerticalCuts {
    public static void main(String[] args) {
        int h = 5, w = 4;

        int[] horizontalCuts = {1,2,4};
        int[] verticalCuts = {1,3};

        MaxAreaOfPieceOfCakeAfterHorizontalVerticalCuts solution = new MaxAreaOfPieceOfCakeAfterHorizontalVerticalCuts();

        int maxArea = solution.maxArea(h, w, horizontalCuts, verticalCuts);

        System.out.println("Maximum area after the cuts is " + maxArea);
    }


    private final int MOD = 1_000_000_007;


    public int maxArea(int h, int w,
                       int[] horizontalCuts, int[] verticalCuts)
    {

        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);

        int hLen = horizontalCuts.length;
        int vLen = verticalCuts.length;
        int maxWidth = 0;

        for(int vInd = 0; vInd <= vLen; vInd++){
            int prev = (vInd == 0) ? 0 : verticalCuts[vInd - 1];
            int curr = (vInd == vLen) ? w : verticalCuts[vInd];

            maxWidth = Math.max(maxWidth, curr - prev);
        }

        int maxHeight = 0;

        for(int hInd = 0; hInd <= hLen; hInd++){
            int prev = (hInd == 0) ? 0 : horizontalCuts[hInd - 1];
            int curr = (hInd == hLen) ? h : horizontalCuts[hInd];

            maxHeight = Math.max(maxHeight, curr - prev);
        }

        long maxArea =  1L * maxWidth * maxHeight;

        return (int) (maxArea % MOD);
    }

}
