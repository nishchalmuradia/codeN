package coreJava;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorTest {

    public static void main(String[] args) {

        Comparator<String> cm = new Comparator<String>() {
            public int compare(String i, String j) {
                if (i.length() > j.length()) {
                    return 1;
                } else {
                    return -1;
                }
            }
        };
        List<String> nums = new ArrayList<>();

        nums.add("N");
        nums.add("Ni");
        nums.add("Nis");
        nums.add("Nish");

        Collections.sort(nums, cm);
        System.out.println(nums);
    }
}
