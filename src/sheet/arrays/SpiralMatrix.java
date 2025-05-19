package sheet.arrays;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

    public static void main(String[] args) {
        int[][] mat = {{1,2,3}, {4,5,6}, {7,8,9}};

        List<Integer> spiral = spiralOrder(mat);

        System.out.println(spiral);
    }


    public static List<Integer> spiralOrder(int[][] mat) {
        List<Integer> res = new ArrayList<>();

        int m = mat.length, n = mat[0].length;
        int top = 0, bottom = m - 1;
        int left = 0, right = n - 1;


        while (left <= right && top <= bottom) {
            for (int j = left; j <= right; j++) {
                res.add(mat[top][j]);
            }
            top++;

            for (int i = top; i <= bottom; i++) {
                res.add(mat[i][right]);
            }
            right--;

            if (top <= bottom) {
                for (int j = right; j >= left; j--) {
                    res.add(mat[bottom][j]);
                }
                bottom--;
            }


            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    res.add(mat[i][left]);
                }
                left++;
            }
        }


        return res;
    }


}
