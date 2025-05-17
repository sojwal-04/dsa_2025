package sorting.arrays;

public class Swap {
    static void swap(int[] A, int i, int j) throws ArrayIndexOutOfBoundsException {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}


