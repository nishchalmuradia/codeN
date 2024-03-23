package coreJava;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Student {
    int age;
    String name;

    public Student(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public String toString() {
        return "student{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}

public class ComparatorTest1 {

    public static void main(String[] args) {

        Comparator<Student> cm = new Comparator<Student>() {
            public int compare(Student i, Student j) {
                if (i.age > j.age){
                    return 1;
                } else {
                    return -1;
                }
            }
        };
        List<Student> st = new ArrayList<>();

        st.add(new Student(21, "Navin"));
        st.add(new Student(12, "Nishchal"));
        st.add(new Student(18    , "Kiran"));

        Collections.sort(st,cm);
        for(Student s : st){
            System.out.println(s);
        }
    }
}
