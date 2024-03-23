package leetcodedaily.intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

//Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals,
// and return an array of the non-overlapping intervals that cover all the intervals in the input.
public class MergeOverlappingIntervals {
    public static int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length <= 1) {
            return intervals;
        }

        Arrays.sort(intervals, Comparator.<int[], Integer>comparing(arr -> arr[0]).thenComparing(arr -> arr[1]));
        List<int[]> mergedIntervals = new ArrayList<>();
        int[] currentInterval = intervals[0];

        for (int i = 1; i < intervals.length; i++) {
            int[] nextInterval = intervals[i];

            if (currentInterval[1] >= nextInterval[0]) {
                //we are merging intervals here
                currentInterval[1] = Math.max(currentInterval[1], nextInterval[1]);
            } else {
                // else means no merge, so we should create this a separate interval and store it
                mergedIntervals.add(currentInterval);
                currentInterval = nextInterval;
            }

        }
        // Add the last merged interval to the result
        mergedIntervals.add(currentInterval);
        return mergedIntervals.toArray(new int[mergedIntervals.size()][]);
    }

    public static void main(String[] args) {
        int[][] interval = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};

        int[][] ans = merge(interval);
        System.out.println(Arrays.deepToString(ans));
    }

}
