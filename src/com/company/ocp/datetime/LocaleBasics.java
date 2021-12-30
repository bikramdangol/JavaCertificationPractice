package com.company.ocp.datetime;

import javax.swing.text.NumberFormatter;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.FormatStyle;
import java.util.Date;
import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.stream.Stream;

/**
 * Created by bikra on 12/17/2019 3:27 PM.
 */
public class LocaleBasics {

    // It doesn't throw Checked Exception.
    public static void printProperties(Locale locale) {
        ResourceBundle rb = ResourceBundle.getBundle("Zoo", locale);
        System.out.println(rb.getString("hello"));
        System.out.println(rb.getString("open"));
        // System.out.println(rb.getString("notValidKey")); // MissingResourceException
    }
    public static void main(String[] args) {
        // Default Locale
        Locale locale = Locale.getDefault();
        System.out.println("Default Locale: " + locale); // en_US

        // Creating Locale using Constructor. (Language, Country)
        Locale npLocal = new Locale("np", "NP");
        System.out.println("New Locale: " + npLocal); // np_NP
        // Building Locale using builder. Note Language becomes lowercase and Region(same as but NOT Country) becomes uppercase:
        Locale localeCheck = new Locale.Builder().setLanguage("EN").setRegion("us").build();
        System.out.println("Locale case of language and REGION: " + localeCheck);
        Locale enLocal = (new Locale.Builder())
                .setRegion("US")
                .setLanguage("en")
                .build();

        System.out.println("\nList of US Locale");
        Stream.of(Locale.getAvailableLocales())
                .filter(local -> local.toString().contains("US"))
                .forEach(System.out::println);

        System.out.println("\nEnglish Version:");
        printProperties(enLocal);

        System.out.println("\nNepali Version:");
        printProperties(npLocal);

        // Java Class Resource Bundle
        System.out.println();
        ResourceBundle resourceBundle = ResourceBundle.getBundle("Zoo", enLocal);
        // It doesn't look at en_US.properties becasue we have en_US.java file.
        // System.out.println("Does it look en_US Properties? : " + resourceBundle.getString("only_in_en_US_properties"));
        System.out.println("open key, value from bundle class: " + resourceBundle.getString("open"));
        System.out.println("en_properties key, value from properties file: " + resourceBundle.getString("en_US_properties"));

        System.out.println("\nReading using Properties:");
        // Properties
        Properties props = new Properties();
        props.putIfAbsent("open", "Zoo is open from properties class.");
        props.putIfAbsent("hello", "Hello");
        System.out.println(props.getProperty("hello"));
        System.out.println(props.get("open"));
        // Gets the default value when key is not found.
        System.out.println(props.getProperty("khula", "Khulla Chha."));

        //NumberFormatter
        System.out.println("\nFormatting of Numbers");
        NumberFormat format = NumberFormat.getInstance(Locale.US);
        double numberOfVisitors = 3_200_4567.756;
        String numberString = "3456";
        // format.parse(numberString); ParseException is Checked exception.
        try {
            Number intNum = format.parse(numberString);
            int intValue = intNum.intValue();
            System.out.println(intValue);

            Number number = 5;
            int numberInt = (int) number;
            int numberIntValue = number.intValue();
            System.out.println(numberInt + " " + numberIntValue);

        } catch (ParseException e) {

        }
        System.out.println("US Number format: " + format.format(numberOfVisitors));

        // getInstance and getNumberInstance are equivalent.
        NumberFormat frFormatter = NumberFormat.getNumberInstance(Locale.FRANCE);
        System.out.println("France Number format: " + frFormatter.format(numberOfVisitors));

        NumberFormat deFormatter = NumberFormat.getCurrencyInstance(Locale.GERMANY);
        System.out.println("Germany Currency format: " + deFormatter.format(numberOfVisitors));

        DateFormat dfUK = DateFormat.getDateInstance(DateFormat.SHORT, Locale.UK);
        System.out.println("UK Date format: " + dfUK.format(new Date())); // How do you format Local Date using Locale?

        // Local Date format using Locale.
        DateTimeFormatter dfUKwithLocale = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT).withLocale(Locale.UK);
        System.out.println("UK Date format for Local Date: " + dfUKwithLocale.format(LocalDate.of(2021, 4, 12)));

    }
}


