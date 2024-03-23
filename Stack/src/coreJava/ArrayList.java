package coreJava;


import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class ArrayList {

    public static void main(String[] args) {
        List<Integer> nums = new java.util.ArrayList<Integer>();

        Set<Integer> s = new HashSet();
        nums.add(1);
        nums.add(12);

        s.add(1);
        s.add(12);
        s.add(1);
        s.add(8);


        for(int n :nums){
            System.out.println(n);
        }

        Iterator<Integer> iterator = s.iterator();


        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

}
