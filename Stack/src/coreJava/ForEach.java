package coreJava;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ForEach {
    public static void main(String[] args) {
/*        List<Integer> nums = Arrays.asList(2, 3, 6, 7, 3, 1);

        Consumer<Integer> con = new Consumer<Integer>() {

            public void accept(Integer n) {
                System.out.println(n);
            }
        };*/
// we can tranfer this to lembda:

        List<Integer> nums = Arrays.asList(2, 3, 6, 7, 3, 1);

        Consumer<Integer> con = n -> System.out.println(n);
        nums.forEach(con);
        // other direct way : like instread os using con , direcrt use the right hand
        // side values
        // nums.forEach(n -> System.out.println(n)); //-- this one
    }
}
