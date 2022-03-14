package com.cleo.revision.java_coding_problems.ch02;

import java.awt.*;

public class Main {

    public static void main(String[] args) {
        Car car = new Car("Mazda", Color.GREEN);

    //    car.assignDriver(null,new Point(123,123));
      //  car.assignDriver("India",null);
        car.assignDriver("India", new Point(123, 123));
    }
}
