package leetcodedaily.intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

//You are given an array of non-overlapping intervals intervals where intervals[i] = [starti, endi] represent the
// start and the end of the ith interval and intervals is sorted in ascending order by starti. You are also given an
// interval newInterval = [start, end] that represents the start and end of another interval.
//Insert newInterval into intervals such that intervals is still sorted in ascending order by starti and
// intervals still does not have any overlapping intervals (merge overlapping intervals if necessary).
//Return intervals after the insertion.


public class InsertInterval {
    public static int[][] insertAndReturnMergeOverlapping(int[][] intervals, int[] newInterval) {
        List<int[]> intervalList = new ArrayList<>();
        List<int[]> mergedIntervals = new ArrayList<>();
        for (int[] a : intervals) {
            intervalList.add(a);
        }
        intervalList.add(newInterval);

        intervalList.sort(Comparator.<int[], Integer>comparing(arr -> arr[0])
                .thenComparing(arr -> arr[1]));
        int[] currentInterval = intervalList.get(0);
        for (int i = 1; i < intervalList.size(); i++) {
            int[] nextInterval = intervalList.get(i);

            if (currentInterval[1] >= nextInterval[0]) {
                currentInterval[1] = Math.max(currentInterval[1], nextInterval[1]);
            } else {
                //create another  interval and merge
                mergedIntervals.add(currentInterval);
                currentInterval = nextInterval;
            }
        }
        //add last one
        mergedIntervals.add(currentInterval);
        return mergedIntervals.toArray(new int[mergedIntervals.size()][]);

    }

    public static void main(String[] args) {
        int[][] interval = {{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
        int[] newInterval = {4, 8};

        int[][] ans = insertAndReturnMergeOverlapping(interval, newInterval);
        System.out.println(Arrays.deepToString(ans));
    }
}
