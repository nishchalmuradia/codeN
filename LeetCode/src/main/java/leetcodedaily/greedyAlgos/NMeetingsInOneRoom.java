package leetcodedaily.greedyAlgos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
//Problem Statement: There is one meeting room in a firm. You are given two arrays,
// start and end each of size N.For an index ‘i’, start[i] denotes the starting time of the ith meeting while end[i]
// will denote the ending time of the ith meeting. Find the maximum number of meetings that can be accommodated
// if only one meeting can happen in the room at a  particular time. Print the order in which these meetings will be performed.
class Meetings {
    int start;
    int end;
    int position;

    public Meetings(int start, int end, int position) {
        this.start = start;
        this.end = end;
        this.position = position;
    }
}

class MeetingComparator implements Comparator<Meetings> {

    @Override
    public int compare(Meetings o1, Meetings o2) {
        if (o1.end < o2.end)
            return -1;
        else if (o1.end > o2.end)
            return 1;
        else if (o1.position < o2.position)
            return -1;
        return 1;
    }
}

public class NMeetingsInOneRoom {
    public static ArrayList<Integer> maxMeetings(int start[], int end[], int n) {
        List<Meetings> meets = new ArrayList<>();
        ArrayList<Integer> answer = new ArrayList<>();

        // add to the meets
        for (int i = 0; i < start.length; i++) {
            meets.add(new Meetings(start[i], end[i], i + 1));
        }

        //sort based on the end time
        MeetingComparator meetingComparator = new MeetingComparator();
        Collections.sort(meets, meetingComparator);

        answer.add(meets.get(0).position);
        int limit = meets.get(0).end;

        //compare end of now to next's start and find conficts
        for (int i = 1; i < start.length; i++) {
            if (meets.get(i).start > limit) {
                limit = meets.get(i).end;
                answer.add(meets.get(i).position);
            }
        }
        return answer;
    }

    public static void main(String args[]) {
        int n = 6;
        int start[] = {1, 3, 0, 5, 8, 5};
        int end[] = {2, 4, 5, 7, 9, 9};
        ArrayList<Integer> arrayList = maxMeetings(start, end, n);
        System.out.println(arrayList);

    }
}
