package sheet.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {

    public static void main(String[] args) {

        int[][] intervals = {{1,4}, {2,3}, {8,9}, {9, 10}};

        int[][] merged = merge(intervals);


        for(int[] interval: merged){
            System.out.println(Arrays.toString(interval));
        }


    }


    public static int[][] merge(int[][] intervals) {
        // Sort an array based on starting, and then ending


        Arrays.sort(intervals, Comparator.comparing((int[] a) -> a[0]).thenComparing(a -> a[1]));



        // Create an arraylist for storing merged intervals

        List<int[]> merged = new ArrayList<>();

        // Merge intervals
        int i = 0;

        int n = intervals.length;

        while(i < n){
            int j = i;
            int start = intervals[i][0];
            int end = intervals[i][1];
            while(j + 1 < n && intervals[j + 1][0] <= end){
                end = Math.max(end, intervals[j + 1][1]);
                j++;
            }
            merged.add(new int[]{start, end});
            i = j + 1;
        }

        // conver the merged INtervals list to an array, and return
        return merged.toArray(new int[merged.size()][]);
    }
}


