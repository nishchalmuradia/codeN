package coreJava;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class StreamAPIEx2 {
    public static void main(String[] args) {

        List<Integer> nums = Arrays.asList(2, 3, 6, 7, 3, 1);
        List<Integer> nums1 = Arrays.asList(2, 3, 6, 7, 3, 1);


        /*Predicate<Integer> p = new Predicate<Integer>() {
            public boolean test(Integer n) {
                return n%2==0;
            }
        };*/

        // -> converting above method to lambda expression:
        Predicate<Integer> p = n -> n % 2 == 0;
        // so insgtead of p , we can direct put  n-> n%2==0 this expression.

       /* Function<Integer,Integer> fun = new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer t) {
                return t*2;
            }
        };*/
// convertin to lamba exporession:
        Function<Integer, Integer> fun = t -> t * 2;
        // so  at the place of fun we can write  t-> t*2 easily.
        Integer result1 = nums.stream()
                .filter(p)
                .map(fun)
                .reduce(0, (c, e) -> c + e);

        //System.out.println(result1);

        Stream<Integer> sortedVaues = nums1.stream()
                .filter(a -> a % 2 == 0)
                .sorted();
        sortedVaues.forEach(n -> System.out.println(n));

    }
}

