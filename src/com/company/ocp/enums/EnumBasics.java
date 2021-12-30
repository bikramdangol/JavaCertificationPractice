package com.company.ocp.enums;

/**
 * Created by bikra on 12/23/2019 4:30 PM.
 */
public class EnumBasics {
    private enum SEASON {
        WINTER("low") {
            @Override protected void openHours() {
                System.out.println("Open from 10am to 4 pm.");
            }
        },
        SPRING("medium") {
            @Override protected void openHours() {
                System.out.println("Open from 10am to 5 pm.");
            }
        },
        SUMMER("high");

        private String visitors;

        // enum Constructor is private by default.
        SEASON(String visitors) {
            this.visitors = visitors;
        }
        // It can be private and is applied for each SEASON. This applies only when the enum is inside the class.
        // If Enum is outside the class or public Enum, what happens?
        private String getVisitors() {
            return this.visitors;
        }

        // it can be protected or default but not private as it has to be overridden by each SEASON.
        // if it is abstract method, then all the SEASONs must override.
        protected void openHours() {
            System.out.println("Open from 9 am to 5 pm");
        }

        public static void sayHi() {
            System.out.println("Hello from Enum.");
        }
    }

    public static void main(String[] args) {
        SEASON season = SEASON.WINTER;
        System.out.println(season.getVisitors()); // prints low
        // Note: private methods and variables are available for each Enum value.
        System.out.println(season.visitors); // prints low
        season.openHours(); // Overloaded version: Open from 10am to 4 pm.
        SEASON.SUMMER.openHours(); // default version: Open from 9 am to 5 pm

        System.out.println("\nPrinting ordinal and name");
        System.out.println(SEASON.SPRING.ordinal()); // 1, Starts from 0 index.
        System.out.println(SEASON.SPRING.name()); // SPRING

        SEASON spring = SEASON.valueOf("spring".toUpperCase()); // should match the case
        System.out.println(spring);


        System.out.println("\nPrinting all values: ");
        for(SEASON item: SEASON.values()) {
            System.out.println(item);
            System.out.println(item.getVisitors());
        }

        SEASON.sayHi();
        season.sayHi();

        // Enum can be used in switch case statement.
        System.out.println("\nEnum in Switch Case: ");
        switch (season) {
            case SPRING:
                System.out.println("spring season");
                break;
            case SUMMER:
                System.out.println("It's summer");
                break;
            default:
                System.out.println("Other seasons");
        }
    }

}
