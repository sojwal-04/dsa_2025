package sheet.arrays;

import java.util.Arrays;

public class RotateImage {

    public static void main(String[] args) {
        RotateImage ri = new RotateImage();

        int[][] mat = {{1,2,3}, {4,5,6}, {7,8,9}};

//        Expected output [[7,4,1],[8,5,2],[9,6,3]]

        System.out.println("Before rotating");
        print(mat);

        ri.rotate(mat);

        System.out.println("After rotating");
        print(mat);
    }


    public  void rotate(int[][] mat) {


        // 1 4 7
        // 2 5 8
        // 3 6 9
        transform(mat);
        reverseRows(mat);
    }

    private void transform(int[][] mat) {
        int m = mat.length, n = mat[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = i; j < n; j++) {
                int temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;
            }
        }
    }

    private void reverseRows(int[][] mat) {
        for (int[] row : mat) {
            int i = 0, j = row.length - 1;
            while (i < j) swap(row, i++, j--);
        }
    }

    private void swap(int[] row, int i, int j) {
        int temp = row[i];
        row[i] = row[j];
        row[j] = temp;
    }


    private static void print(int[][]mat){
        for(int[] row: mat) System.out.println(Arrays.toString(row));
    }
}

