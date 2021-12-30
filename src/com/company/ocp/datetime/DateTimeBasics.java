package com.company.ocp.datetime;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

/**
 * Created by bikra on 12/17/2019 10:45 AM.
 */
public class DateTimeBasics {
    public static void main(String[] args) {
        LocalDate ld = LocalDate.now();
        //LocalDate.parse("2019-102-25", DateTimeFormatter.ISO_LOCAL_DATE);

        LocalDate valentineDay = LocalDate.of(2015, 2, 14);
        valentineDay = valentineDay.plusYears(1);
        valentineDay = valentineDay.plusDays(15);
        System.out.println(valentineDay);

        // Formatting date weirdly.
        LocalDate ldFormatterOutCheck = LocalDate.of(2019, 1, 2);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("M/d\\y ,:MM");
        System.out.println(dateTimeFormatter.format(ldFormatterOutCheck));

        LocalDate ld2 = LocalDate.of(2018,10,18);
        LocalTime lt1 = LocalTime.of(13, 15, 30);
        LocalTime lt2 = LocalTime.of(14, 30, 30);
        System.out.println(lt1);

        System.out.println(ld.isBefore(ld2));
        System.out.println("January Month value: " + Month.JANUARY.getValue());
        System.out.println("January Month ordinal: " + Month.JANUARY.ordinal());
        System.out.println("January Month name: " + Month.JANUARY.name());
        //System.out.println("January Month displayName: " + Month.JANUARY.getDisplayName());

        System.out.println();
        LocalDateTime ldt;
        System.out.println("LocalDateTime: " + (ldt = LocalDateTime.of(ld, lt1)));
        System.out.println("ZonedDateTime: " + ZonedDateTime.of(ldt, ZoneId.of("US/Eastern")));
        Instant instant = Instant.now();
        ZoneId zoneId = ZoneId.of("US/Eastern");
        System.out.println("Instant: " + instant);
        ZonedDateTime zdt = ZonedDateTime.ofInstant(instant, zoneId);
        System.out.println("Zoned Date Time from instant: " + zdt);

        /*ZoneId.getAvailableZoneIds().stream()
                .filter(zone -> zone.contains("US") || zone.contains("America"))
                .sorted()
                .forEach(System.out::println);*/

        System.out.println(ld);
        System.out.println("After 5 weeks: " + ld.plusWeeks(5));
        System.out.println("Before 5 weeks: " + ld.plusWeeks(-5));


        // Period
        System.out.println();
        Period p1 = Period.of(0,15,45);
        System.out.println("Period of 15 Mo, 45 days: " + p1); // P15M45D Note: 15 Months is as is in Period.
        Period p2 = Period.ofDays(45);
        System.out.println("Period of 45 days: " + p2); // P45D

        //Duration
        Duration d1 = Duration.ofDays(1);
        System.out.println("Duration of 1 Day: " + d1); // PT24H Note: 1 Day Duration is calculated as hours.
        Duration d2 = Duration.of(10, ChronoUnit.HOURS);

        System.out.println();
        System.out.println("Days difference between dates: " + ChronoUnit.DAYS.between(ld, ld2));
        System.out.println("Hours difference between times: " + ChronoUnit.HOURS.between(lt1, lt2));// Order start and end. hence end-start
        System.out.println("Hours difference between times: " + ChronoUnit.MINUTES.between(lt2, lt1));

        // see the period between two dates. Same dates but different days!
        System.out.println();
        System.out.println("LD1: " + ld);
        System.out.println("LD2: " + ld2);
        System.out.println("Period between two local dates: " + Period.between(ld2, ld)); // P-1Y-1M-30D
        System.out.println("Period between two local dates: " + Period.between(ld, ld2)); // P1Y1M-9D ?? Not really!

        // Duration equals or not.
        System.out.println();
        System.out.println("No Chaining: " + Duration.ofDays(1).ofHours(1));// PT1H Note: No chaining. Days is ignored. It picks the last one.
        String m1 = Duration.of(1, ChronoUnit.MINUTES).toString();
        Duration sixtySec = Duration.of(60, ChronoUnit.SECONDS);
        String s = sixtySec.toString();
        System.out.println("1 min and 60 sec duration equal? : " + m1.equals(s)); // true

        // Period equals or not
        Period year2 = Period.ofYears(2);
        Period month24 = Period.ofMonths(24);
        System.out.println("2 years and 24 months equal? : " + year2.toString().equals(month24.toString())); // false
        Period weeks = Period.ofWeeks(4);
        System.out.println("Four weeks period: " + weeks); // P28D Note: Converted to days from week.

        //Duration on Local Date
        // It throws exception.
        //ld.plus(Duration.of(1, ChronoUnit.DAYS));
        LocalDate localDate1 = LocalDate.of(2000, 1, 15);
        LocalDate localDate2 = localDate1.plusDays(2).minusDays(1).minusDays(1);
        System.out.println("Date representing the same day equals or not? " + localDate1.equals(localDate2)); // true
        ld.equals(ld2);
        ld.getMonth();
        Period pbetweenld = ld.until(ld2);
        long days = ld.until(ld2, ChronoUnit.DAYS);
        long days1 = ChronoUnit.DAYS.between(localDate1, localDate2);

        LocalDate birthDay1 = LocalDate.of(1990, 2, 3);
        LocalDate birthDay2 = LocalDate.of(1990, 2, 3);

        System.out.println("Check if two date are equal: " + birthDay1.isEqual(birthDay2));

        assert true : "Invalid state1";
        assert(false) : "Invalid state2";
    }
}
