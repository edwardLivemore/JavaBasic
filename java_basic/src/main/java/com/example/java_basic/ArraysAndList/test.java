package com.example.java_basic.ArraysAndList;

import java.util.ArrayList;
import java.util.List;

public class test {
    public static void main(String[] args) {
        // String[] names = new String[]{"a", "b"};
        // Integer[] names = {1,2,3};
        // List namelist = Arrays.asList(names);
        // System.out.println(namelist.get(0));
        // System.out.println(namelist.get(1));
        // System.out.println(namelist.get(2));
        // printList(namelist);
        // namelist.add(4);
        // printList(namelist);

        ArrayList<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        // for (String s : list) {
        //     if (s.equals("3")) {
        //         list.remove(s);
        //     }
        // }
        list.removeIf(s -> s.equals("3"));
        System.out.println(list);
    }

    private static <T> void printList(List<T> namelist) {
        for (T name : namelist) {
            System.out.println(name);
        }
    }
}
