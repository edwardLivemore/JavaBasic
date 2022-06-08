package com.example.java_basic.Param;

public class RefDemo {
    public static void main(String[] args) {
        StringBuilder str = new StringBuilder("ab");
        StringBuilder s = test(str);
        System.out.println("main: " + str);
        // System.out.println("is same object? " + str == s);

        // Student s1 = new Student("student1");
        // System.out.println("main: s1: " + s1.name);
        // Student s2 = testStudent(s1);
        // System.out.println("main s1: " + s1.name);
        // if(s1 == s2){
        //     System.out.println("main: s1 == s2");
        // }

        Student s1 = new Student("s1");
        System.out.println("main: s1: " + s1.name);
        Student s2 = new Student("s2");
        System.out.println("main: s2: " + s2.name);
        swap(s1, s2);
        System.out.println("main: s1: " + s1.name);
        System.out.println("main: s2: " + s2.name);
    }

    private static void swap(Student s1, Student s2) {
        // copy changed
        Student temp = s1;
        s1 = s2;
        s2 = temp;

        // value changed
        // String name = s1.name;
        // s1.name = s2.name;
        // s2.name = name;
        System.out.println("swap: s1: " + s1.name);
        System.out.println("swap: s2: " + s2.name);
    }

    private static Student testStudent(Student s1) {
        System.out.println("change student name...");
        s1.name = "testStudent";
        return s1;
    }

    private static StringBuilder test(StringBuilder s) {
        s.delete(0, 2).append("cd");
        System.out.println("test: " + s);
        return s;
    }
}

class Student {
    public String name;

    public Student(String name){
        this.name = name;
    }
}
