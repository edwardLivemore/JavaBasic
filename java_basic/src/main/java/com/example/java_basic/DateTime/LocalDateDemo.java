package com.example.java_basic.DateTime;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LocalDateDemo {
    public static void main(String[] args) {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyyMM");
        LocalDate now = LocalDate.now();
        System.out.println(now.format(df));
    }
}