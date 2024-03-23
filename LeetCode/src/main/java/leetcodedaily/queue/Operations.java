package leetcodedaily.queue;

import java.util.LinkedList;
import java.util.Queue;

class Operation {

    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        int N = 8;
        int[] a = new int[]{1, 2, 3, 4, 5, 2, 3, 1};
        int M = 5;
        int[] b = new int[]{1, 3, 2, 9, 10};


        for (int i = 0; i < N; i++) {

            insert(q, a[i]);
        }

        for (int i = 0; i < M; i++) {

            int f = findFrequency(q, b[i]);
            if (f != 0) {
                System.out.print(f + " ");
            } else {
                System.out.print("-1"
                        + " ");
            }
        }
    }

    static void insert(Queue<Integer> q, int k) {
        q.add(k);
    }

    static int findFrequency(Queue<Integer> q, int k) {
        int cntFrequency = 0;
        int size = q.size();

        while (size-- != 0) {

            int x = q.poll(); // return and remove the top element (obv front)

            if (x == k) {
                cntFrequency++;
            }
            q.add(x);
        }
        return cntFrequency;
    }
}

