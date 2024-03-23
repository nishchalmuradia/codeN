package coreJava;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class StreamAPI {

    public static void main(String[] args) {

        List<Integer> nums = Arrays.asList(2, 3, 6, 7, 3, 1);

        Stream<Integer> s1 = nums.stream();
        Stream<Integer> s2 = s1.filter(n -> n % 2 == 0);
        Stream<Integer> s3 = s2.map(n -> n * 2);
        Integer result = s3.reduce(0, (c, e) -> c + e);
        System.out.println(result);
        System.out.println();
        // ACtually we can write all in one line =>

        Integer result1 = nums.stream()
                .filter(n -> n % 2 == 0)
                .map(n -> n * 2)
                .reduce(0, (c, e) -> c + e);

        System.out.println(result1);
    }
}
