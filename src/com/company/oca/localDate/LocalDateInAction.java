package com.company.oca.localDate;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;
import java.util.Currency;
import java.util.Locale;
import java.util.regex.Pattern;

/**
 * Created by bikra on 11/26/2019 8:10 AM.
 */
public class LocalDateInAction {
    public static void main(String[] args) {
        LocalDate localDate = LocalDate.of(2019, 11, 25); // Month from 1-12;
        DateTimeFormatter dtf = DateTimeFormatter.ISO_DATE;
        DateTimeFormatter dtf2 = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);
        DateTimeFormatter dtf3 = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);
        System.out.println("Formatted date value using ISO DATE: " + dtf.format(localDate));
        System.out.println("Formatted date value using date Format Style SHORT: " + dtf2.format(localDate));
        LocalDateTime dateTime = LocalDateTime.of(2021, 4, 21, 20, 26);
        System.out.println("Formatted date value using dateTime Format Style SHORT: " + dtf3.format(dateTime));

        System.out.println(localDate.getDayOfWeek().getValue());
        LocalTime localTime = LocalTime.of(13, 20);
        LocalDateTime localDateTime = LocalDateTime.of(2019, 11, 25, 8, 25, 5, 200);



        Period period = Period.of(1, 1,1);
        localDateTime = localDateTime.plus(period);

        System.out.println(localDateTime);

        LocalDate zooVisitDate = LocalDate.of(2020, 1, 31);
        Period month = Period.ofMonths(1);
        LocalDate afterZooVisitDate = zooVisitDate.plus(month);
        System.out.println("\nAfter adding one month on Jan 31st: " + afterZooVisitDate);
        afterZooVisitDate = afterZooVisitDate.plus(month);
        System.out.println("After adding one month on Feb 29: " + afterZooVisitDate);
        Period twoMonths = Period.ofMonths(2);
        LocalDate after2MonthsOfZooVisitDate = zooVisitDate.plus(twoMonths);
        System.out.println("After adding two month on Jan 31st: " + after2MonthsOfZooVisitDate);

        System.out.println("\nuntil date days: " + zooVisitDate.until(afterZooVisitDate, ChronoUnit.DAYS));
        System.out.println("until date days: " + ChronoUnit.DAYS.between(zooVisitDate, afterZooVisitDate));

        Currency us = Currency.getInstance(Locale.CHINA);
        System.out.println(us.getCurrencyCode());
        System.out.println(us.getSymbol());

        NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale( "en", "IN"));
        double price = 123456.788;
        System.out.println("\nIndia currency format: " + nf.format(price));

        NumberFormat nfi = NumberFormat.getCurrencyInstance(Locale.US);
        System.out.println("USA currency format: " + nfi.format(price));

        String s = "He   !,?._'is a very very good boy, %isn't he?@.";
        // String s = "!,?  ._'@?@.";
        s = s.replaceFirst("[!,?. _'@]+", "");
        String[] result = s.split("[^A-Za-z]+");
        int length = result.length;
        System.out.println(length);
        for (int i = 0; i < length; i++) {
            System.out.println(result[i]);
        }

        long n = 16;
        int m = 3;

        String generatedNumber = "";
        for (long i = 0; i < n; i++) {
            generatedNumber += "1";
        }
        System.out.println(Long.parseLong(generatedNumber) % (long) m);
        long dividend = 1111L;
        int divisor = 3;
        System.out.println(solve(dividend, divisor));
    }

    static int solve(long n, int m) {
        String numString = "";
        for (long i = 0; i < n; i += 1) {
            numString += "1";
        }
        long number = Long.parseLong(numString);
        long remainder = number % m;
        return (int) remainder;
    }
}
