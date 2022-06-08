package com.example.java_basic.DateTime;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.TemporalAdjusters;
import java.util.Calendar;
import java.util.Date;

public class LocalDateTimeDemo {
    private static Calendar calendar = Calendar.getInstance();

    public static void main(String[] args) {
        // getDateOfWeekOrMonth();

        // getDaysOfMonth();

        getDaysDiff();
    }

    private static void getDateOfWeekOrMonth() {
        LocalDate now = LocalDate.now();
        System.out.println("first day of this week: "
                + now.with(TemporalAdjusters.previous(DayOfWeek.SUNDAY)).plusDays(1).atStartOfDay());
        System.out.println("last day of this week: "
                + now.with(TemporalAdjusters.next(DayOfWeek.MONDAY)).atStartOfDay().minusSeconds(1));
        System.out.println("first day of this month: " + now.with(TemporalAdjusters.firstDayOfMonth()).atStartOfDay());
        System.out.println("last day of this month: "
                + now.with(TemporalAdjusters.firstDayOfNextMonth()).atStartOfDay().minusSeconds(1));
        System.out.println("today: " + LocalDateTime.now().toLocalDate());
        System.out.println("testday: " + LocalDateTime.now().toLocalDate().plusDays(1));
        System.out.println("first day of last month: "
                + LocalDate.now().minusMonths(1).with(TemporalAdjusters.firstDayOfMonth()).atStartOfDay());
        System.out.println("last day of last month: "
                + LocalDate.now().with(TemporalAdjusters.firstDayOfMonth()).atStartOfDay().minusSeconds(1));
        System.out.println("first day of last week: " + now.minusWeeks(1).with(DayOfWeek.MONDAY).atStartOfDay());
        System.out.println("last day of last week: " + now.with(DayOfWeek.MONDAY).atStartOfDay().minusSeconds(1));
    }

    private static void getDaysOfMonth() {
        LocalDate localDate = LocalDate.now();
        // LocalDate localDate = LocalDate.parse("2021-02-01");
        ZonedDateTime zonedDateTime = localDate.atStartOfDay(ZoneId.systemDefault());
        calendar.setTime(Date.from(zonedDateTime.toInstant()));
        System.out.println(calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
    }

    private static void getDaysDiff() {
        Period period = Period.between(LocalDate.parse("2021-06-07"), LocalDate.parse("2021-06-13"));
        System.out.println(period.getDays());
        LocalDate now = LocalDate.now();
        System.out.println(now.minusDays(7));
    }
}