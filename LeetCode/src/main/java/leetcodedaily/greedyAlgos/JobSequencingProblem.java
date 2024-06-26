package leetcodedaily.greedyAlgos;

//Problem Statement: You are given a set of N jobs where each job comes with a deadline and profit.
// The profit can only be earned upon completing the job within its deadline.
// Find the number of jobs done and the maximum profit that can be obtained.
// Each job takes a single unit of time and only one job can be performed at a time.

import java.io.IOException;
import java.util.Arrays;

class Job {
    int id, profit, deadline;
    Job(int x, int y, int z) {
        this.id = x;
        this.deadline = y;
        this.profit = z;
    }
}

class JobSequencingProblem {
    // return an array of size 2 having the 0th element equal to the count
    // and 1st element equal to the maximum profit
    int[] JobScheduling(Job arr[], int n) {
        Arrays.sort(arr, (a, b) -> (b.profit - a.profit));


        //choosing highest deadline to create an array of size of that size
        int maxi = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i].deadline > maxi) {
                maxi = arr[i].deadline;
            }
        }

        int result[] = new int[maxi + 1];

        for (int i = 1; i <= maxi; i++) {
            result[i] = -1;
        }

        int countJobs = 0, jobProfit = 0;

        for (int i = 0; i < n; i++) {
                //filling array via deadline right to left order
            for (int j = arr[i].deadline; j > 0; j--) {

                // Free slot found
                if (result[j] == -1) {
                    result[j] = i;
                    countJobs++;
                    jobProfit += arr[i].profit;
                    break;
                }
            }
        }

        int ans[] = new int[2];
        ans[0] = countJobs;
        ans[1] = jobProfit;
        return ans;

    }
}
class Main {
    public static void main(String[] args) throws IOException {

        //size of array
        Job[] arr = new Job[4];
        arr[0] = new Job(1, 4, 20);
        arr[1] = new Job(2, 1, 10);
        arr[2] = new Job(3, 1, 40);
        arr[3] = new Job(4, 1, 30);

        JobSequencingProblem ob = new JobSequencingProblem();

        //function call
        int[] res = ob.JobScheduling(arr, 4);
        System.out.println(res[0] + " " + res[1]);

    }
}