package leetcodedaily.intervals;

import java.util.Arrays;
import java.util.Comparator;

public class NonOverlappingIntervals {
    //Given an array of intervals intervals where intervals[i] = [starti, endi], return the minimum number of intervals
    // you need to remove to make the rest of the intervals non-overlapping.


    public static int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }
        int result = 0;
        Arrays.sort(intervals, Comparator.<int[], Integer>comparing(arr -> arr[0]).thenComparing(arr -> arr[1]));
        int[] currentInterval = intervals[0];


        for (int i = 1; i < intervals.length; i++) {
            int[] nextInterval = intervals[i];
            if (currentInterval[1] > nextInterval[0]) {
                result++;
                if (currentInterval[1] > nextInterval[1]) {
                    currentInterval = nextInterval;
                }
            } else {
                currentInterval = nextInterval;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] interval = {{1, 2}, {2, 3}, {3, 4}, {1, 3}};
        int count = eraseOverlapIntervals(interval);
        System.out.println(count);
    }


}
