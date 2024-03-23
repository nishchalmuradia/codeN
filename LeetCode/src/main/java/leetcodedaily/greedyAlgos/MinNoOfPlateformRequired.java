package leetcodedaily.greedyAlgos;


import java.util.Arrays;

//Problem Statement: We are given two arrays that represent the arrival and departure times of trains that stop at the
// platform. We need to find the minimum number of platforms needed at the railway station so that no train has to wait.
public class MinNoOfPlateformRequired {

    static int countPlatforms(int n, int[] arr, int[] dep) {
        Arrays.sort(arr);
        Arrays.sort(dep);
        int plat_needed = 1, result = 1;
        int i = 1, j = 0;

        while (i < n && j < n) {
            if (arr[i] <= dep[j]) {
                plat_needed++;
                i++;
            } else if (arr[i] > dep[j]) {
                plat_needed--;
                j++;
            }
            if (plat_needed > result) {
                result = plat_needed;
            }
        }
        return result;
    }

    public static void main(String[] args) {

        int[] arr = {900, 920, 940, 950, 1000, 1015, 1030, 1100, 1130, 1200};
        int[] dep = {930, 940, 1030, 1050, 1130, 1145, 1230, 1200, 1300, 1245};

        int n = arr.length;
        int totalCount = countPlatforms(n, arr, dep);
        System.out.println("Minimum number of Platforms required " + totalCount);
    }
}
