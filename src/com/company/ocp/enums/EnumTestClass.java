package com.company.ocp.enums;

/**
 * Created by bikra on 4/25/2021 9:46 AM.
 */
enum CarType{
    NISSAN("Cheaper"),
    TOYOTa("Cheap"),
    BMW("Expensive"),
    HONDA("Cheap");
    private int wheels = 4;
    private String Price;
    private CarType(String Price){
        this.Price = Price;
    }

    public String getPriceInfo() {
        // System.out.println(this.Price);
        return this.Price;
    }

    public void printPrice() {
        System.out.println(Price);
    }
}

public class EnumTestClass {


    public static void main(String[] args) {
        CarType car = CarType.TOYOTa;
        car.printPrice();
        System.out.println(CarType.BMW.getPriceInfo());
        System.out.println(car.getPriceInfo());

        System.out.println(car);
        System.out.println(car.ordinal());
        System.out.println(car.name());

        //you can create an enum from a String
        CarType bmwCar = CarType.valueOf("BMW");
        //System.out.println("Wheels: " + bmwCar.wheels);

        for (CarType eCar: CarType.values()) {
            System.out.println(eCar.name() + " " + eCar.ordinal() + " " + eCar + " " + eCar.toString() + " " + eCar.getPriceInfo());
        }
    }
}
